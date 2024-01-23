import java.util.Scanner;

import module.menu.MainMenuSelection;
import module.menu.MemberMenu.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberMenu memberMenu = new MemberMenu();
        while (true) {
            System.out.println("\n1: 구성원 관리\n2: 도서 관리 \n3: 대출 관리 \n4: 종료");
            int mainMenuSelection = sc.nextInt();

            if (mainMenuSelection == MainMenuSelection.MEMBERMANAGE.getValue()) { //구성원 관리
                while(true){
                System.out.println("\n1: 구성원 추가\n2: 구성원 변경 \n3: 구성원 출력 \n4: 메인메뉴");
                int memberMenuSelection = sc.nextInt();
                if(memberMenuSelection == MemberMenuEnum.MEMBERADD.getValue()){
                        memberMenu.add();
                    }else if (memberMenuSelection == MemberMenuEnum.MAMBERCHANGE.getValue()){
                        memberMenu.change();
                    }else if (memberMenuSelection == MemberMenuEnum.MEMBERSHOW.getValue()){
                        memberMenu.show();
                    }else if(memberMenuSelection == MemberMenuEnum.MAINMENU.getValue()){
                        break;
                    }else{
                        System.out.println("올바른 숫자를 입력\n");
                    }
            }
            } else if (mainMenuSelection == MainMenuSelection.BOOKMANAGE.getValue()) { //도서 관리
                System.out.println("2번 메뉴");
            } else if (mainMenuSelection == MainMenuSelection.LOANMANAGE.getValue()) { //대출 관리
                System.out.println("3번 메뉴");
            } else if (mainMenuSelection == MainMenuSelection.EXIT.getValue()){
                break;
            }
        }
    }
}