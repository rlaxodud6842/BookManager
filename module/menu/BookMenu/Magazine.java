package module.menu.BookMenu;

import java.util.Scanner;

class Magazine extends Book{
    private static int id = 0;
    private String[] addtionalInformation = new String[3];
    private int uid;

    public Magazine(String name, String major){
        super(name,major);
        Magazine.id++;
        uid = Magazine.id;
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
        System.out.println("추가 정보를 다음과 같은 순으로 입력해주세요 -> 학년, 학점, 연락처");
        for (int i = 0; i < 3; i++){this.addtionalInformation[i] = sc.nextLine();}
    }
    public String[] loadAdditionalInformation(){
        return this.addtionalInformation;
    }

    //각 자식한데 오버라이딩 하고 지들끼리 다시 get정보 하나씩 만들기
    
}
