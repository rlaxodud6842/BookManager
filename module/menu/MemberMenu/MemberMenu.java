package module.menu.MemberMenu;
import module.menu.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMenu implements Menu{
    ArrayList<Member> memberList = new ArrayList<Member>();

    public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("학생인가요 교수인가요? (s/l)");
        String identify = sc.nextLine();

        System.out.println("이름은 무엇입니까?");
        String name = sc.nextLine();
        System.out.println("전공은 무엇입니까?");
        String major = sc.nextLine();

        if (identify.equals("s")){ //학생일 경우
            Member student = new Student(name,major);
            memberList.add(student);
       }else if (identify.equals("l")){ // 교수일 경우
            Member lecture = new Lecture(name,major);
            memberList.add(lecture);
       }else{
            System.out.println(identify + "<- 잘못 입력된 문자");
       }
       
    }
    public void change(){}
    public void show(){
        System.out.println("보여주기");
        for (Member member : memberList) {
            System.out.println(member.getName());
        }
    }
    public void back(){}
}

