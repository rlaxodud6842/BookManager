package module.menu.MemberMenu;

import java.util.Scanner;

public class Student extends Member{
    private static int id = 0;
    private String[] addtionalInformation = new String[3];
    private int uid;

    public Student(String name,String major){
        loadNameAndMajor(name,major);
        Student.id++;
        uid = Student.id;
    }
    public String getId(){
        return "U"+uid;
    }
    public String getState(){
        if (this.state == true){
            return "재학";
        }
        return "졸업";
    }

    public void getAdditionalInformation(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            if(i == 0){
                System.out.println("학년을 입력하세요");
            }else if (i == 1){
                System.out.println("학점을 입력하세요");
            }else if (i == 2){
                System.out.println("연락처를 입력하세요");
            }
            this.addtionalInformation[i] = sc.nextLine();
        }

    }
    public String[] loadAdditionalInformation(){
        return this.addtionalInformation;
    }

    //각 자식한데 오버라이딩 하고 지들끼리 다시 get정보 하나씩 만들기
    
}
