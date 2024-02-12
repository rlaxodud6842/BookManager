package module.menu.MemberMenu;

import java.util.Scanner;

class Lecture extends Member{
    private static int id = 0;
    private String[] addtionalInformation = new String[2];
    private int lid;
    
    public Lecture(String name,String major,int lastId){
        loadNameAndMajor(name,major);
        Lecture.id = lastId;
        Lecture.id++;
        lid = Lecture.id;
    }

    public int getRawId(){
        return lid;
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
        for (int i = 0; i < 2; i++){
            if(i == 0){
                System.out.println("전공을 입력하세요");
            }else if (i == 1){
                System.out.println("연구실을 입력하세요");
            }
            this.addtionalInformation[i] = sc.nextLine();
        }
    }

    public String[] loadAdditionalInformation(){
        return this.addtionalInformation;
    }

}
