package module.menu.MemberMenu;
import module.menu.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemberMenu implements Menu{
    ArrayList<Member> memberList = new ArrayList<Member>();
    Scanner sc = new Scanner(System.in);

    public void add(){
        System.out.println("학생인가요 교수인가요? (s/l)");
        String identify = sc.nextLine();

        System.out.println("이름은 무엇입니까?");
        String name = sc.nextLine();
        System.out.println("전공은 무엇입니까?");
        String major = sc.nextLine();

        if (identify.equals("s")){ //학생일 경우
            Member student = new Student(name,major);
            memberList.add(student);
            student.getAdditionalInformation();
       }else if (identify.equals("l")){ // 교수일 경우
            Member lecture = new Lecture(name,major);
            memberList.add(lecture);
            lecture.getAdditionalInformation();
       }else{
            System.out.println(identify + "<- 잘못 입력된 문자");
       }
    }

    public void change(){
        //사용자에게 변경할 ID 입력
        sc = new Scanner(System.in);
        System.out.println("변경시키고 싶은 ID를 입력하세요");
        String targetId = sc.nextLine();
        //배열중에서 찾아서 변경시키기
        for (Member member : memberList) {
            if(member.getId().equals(targetId)){
                if(member.state == true){
                    member.state = false;
                }else{
                    member.state = true;
                }
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
    public void show(){
        ArrayList<Member> lectureList = new ArrayList<>();
        ArrayList<Member> studentList = new ArrayList<>();
        
        System.out.println("보여주기");
        for (Member member : memberList) {
            //교수인지 학생인지 구분 후 각각 배열에 넣기
            if(member.getId().charAt(0) == 'F'){
                lectureList.add(member);
            }else{
                studentList.add(member);
            }
            //이름 오름차순 정렬
            Collections.sort(lectureList);
            Collections.sort(studentList);
        }
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
    public void back(){}
}

