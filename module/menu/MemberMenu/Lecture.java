package module.menu.MemberMenu;

import java.util.Scanner;

class Lecture extends Member{
    private static int id = 0;
    private String[] addtionalInformation = new String[2];
    private int lid;
    public Lecture(String name, String major){
        super(name,major);
        Lecture.id++;
        lid = Lecture.id;
    }

    public String getId(){
        return "F"+lid;
    }

    public String getState(){
        if (this.state == true){
            return "재직";
        }
        return "퇴사";
    }

    public void getAdditionalInformation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("추가 정보를 다음과 같은 순으로 입력해주세요 -> 전공, 연구실");
        for (int i = 0; i < 2; i++){this.addtionalInformation[i] = sc.nextLine();}
    }

    public String[] loadAdditionalInformation(){
        return this.addtionalInformation;
    }

}
