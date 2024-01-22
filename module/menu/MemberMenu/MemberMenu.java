package module.menu.MemberMenu;
import module.menu.Menu;

import java.util.ArrayList;
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
    public void change(){}
    public void show(){
        int limit = 0;
        System.out.println("보여주기");
        for (Member member : memberList) {
            StringBuilder sb = new StringBuilder();
            String[] addtionalInformataion = member.loadAdditionalInformation();
            sb.append(member.getId() + " | ");
            sb.append(member.getName() + " | ");
            sb.append(member.getMajor()+ " | ");
            sb.append(member.getState()+ " | ");
            //여기서 받아놓은 배열을 불러와서 정보 하나씩 출력

            if(member.getId().charAt(0) == 'U'){
                limit = 3;
            }else{
                limit = 2;
            }
            for (int i = 0; i<limit; i++){
                sb.append(addtionalInformataion[i] + " | ");
            }
            System.out.println(sb);
        }
    }
    public void back(){}
}

