package module.menu.MemberMenu;
import module.menu.LoanMenu.Loan;
import module.menu.LoanMenu.LoanMenu;
import module.menu.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemberMenu implements Menu, Serializable {
    private static ArrayList<Member> memberList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void add(){
        System.out.println("학생인가요 교수인가요?");
        String identify = String.valueOf(sc.nextLine());

        System.out.println("이름은 무엇입니까?");
        String name = sc.nextLine();
        System.out.println("학과은 무엇입니까?");
        String major = sc.nextLine();
        if (identify.equals("학생")){ //학생일 경우
            Member student = new Student(name,major,getLastId("S"));
            memberList.add(student);
            student.getAdditionalInformation();
       }else if (identify.equals("교수")){ // 교수일 경우
            Member lecture = new Lecture(name,major,getLastId("L"));
            memberList.add(lecture);
            lecture.getAdditionalInformation();
       }else{
            System.out.println(identify + "<- 잘못 입력된 문자");
       }
    }

    public void change(){
        ArrayList<String> loaningBook = new ArrayList<>();
        LoanMenu loanmenu = new LoanMenu();
        ArrayList<Loan> loanArrayList = loanmenu.getLoanList();
        //사용자에게 변경할 ID 입력
        sc = new Scanner(System.in);
        System.out.println("변경시키고 싶은 ID를 입력하세요");
        String targetId = sc.nextLine();

        //맴버배열중에서 바꾸려는애를 찾아볼게요
        for (Member member : memberList) {
            if(member.getId().equals(targetId)){
            //찾는놈이랑 배열의 놈이랑 같아요.
                // 대출정보를 싹다 뒤져서 그녀석 대출정보가 있나 볼게요
                for (Loan loan : loanArrayList){
                    ArrayList<String[]> additonalInfo = loan.getLoanInformation();
                    //대출정보를 한번 볼게요
                    for (String[] list : additonalInfo){
                        //대출정보 0은 대출자를 의미하고, 그녀석이 타겟이름과 같고, 반납도 안했어요
                        if (list[0].equals(member.getName()) && list[2] == null) {
                            //대출안한 책들 리스트에 추가
                            loaningBook.add(loan.getBookName());
                        }
                    }
                }
            }else{
                continue;
            }
            //대출안한 책들을 추가한 리스트가 비어있지 않다 = 대출 안한거 한개라도 있다
            if (!loaningBook.isEmpty()){
                System.out.println("대출중인 도서가 있어서, 변경 불가능합니다. \n[반납안한 도서 목록]");
                for(String bookname : loaningBook){
                    System.out.println(bookname);
                }
                return;
            }else{
                //그게 아니면 상태를 바꿔요
                if(member.state){
                    member.state = false;
                }else{
                    member.state = true;
                }
                System.out.println("상태가 정상적으로 변경되었습니다.");
                return;
            }
        }
    }

    public void print(Member member, int limit){
        StringBuilder sb = new StringBuilder();
        String[] addtionalInformataion = member.loadAdditionalInformation();
        sb.append(member.getId() + " | ");
        sb.append(member.getName() + " | ");
        sb.append(member.getMajor()+ " | ");
        sb.append(member.getState()+ " | ");

        for (int i = 0; i<limit; i++){
            sb.append(addtionalInformataion[i] + " | ");
        }
        System.out.println(sb);
    }

    public ArrayList<Member> getEachMemberList(ArrayList<Member> memberList,boolean flag){
        //flag로 true면 학생 리스트 리턴, false면 교수 리스트 리턴
        ArrayList<Member> lectureList = new ArrayList<>();
        ArrayList<Member> studentList = new ArrayList<>();
        for (Member member : memberList) {
            //교수인지 학생인지 구분 후 각각 배열에 넣기
            if(member.getId().charAt(0) == 'U' && flag){
                studentList.add(member);
            } else if (member.getId().charAt(0) == 'F' && !flag) {
                lectureList.add(member);
            }
        }
        if (flag){
            return studentList;
        }else{
            return lectureList;
        }
    }
    public void show(){
        ArrayList<Member> lectureList = getEachMemberList(memberList,false);
        ArrayList<Member> studentList = getEachMemberList(memberList,true);

        //이름 오름차순 정렬
        Collections.sort(lectureList);
        Collections.sort(studentList);

        //교수 출력
        System.out.println("==================================================");
        System.out.println("ID | 성명 | 학과 | 상태 | 전공 | 연구실 |");
        System.out.println("--------------------------------------------------");
        for (Member lecture : lectureList) {
            print(lecture,2);
        }
        //학생 출력
        System.out.println("==================================================");
        System.out.println("ID | 성명 | 학과 | 상태 | 학년 | 학점 | 연락처 |");
        System.out.println("--------------------------------------------------");
        for (Member student : studentList) {
            print(student,3);
        }
    }
    public ArrayList<Member> getMemberList(){return MemberMenu.memberList;}
    public void loadMemberList(ArrayList<Member> loadedList){
        MemberMenu.memberList = loadedList;
    }
    public int getLastId(String kind){
        ArrayList<Member> lectureList = getEachMemberList(memberList,false);
        ArrayList<Member> studentList = getEachMemberList(memberList,true);
        int maxId = Integer.MIN_VALUE;
        ArrayList<Member> targetList = null;

        if(kind.equals("S")){
            targetList = studentList;
            //학생을 찾는다면
        } else if (kind.equals("L")) {
            //교수를 찾는다면
            targetList = lectureList;
        }

        if (!targetList.isEmpty()){
            for (Member member : targetList){
                if(maxId < member.getRawId()){
                    maxId = member.getRawId();
                }
            }
        }else{
            return 0;
        }
        return maxId;
    }

}

