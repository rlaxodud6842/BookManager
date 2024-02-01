import java.util.Scanner;

import module.menu.LoanMenu.LoanMenu;
import module.menu.LoanMenu.LoanMenuEnum;
import module.menu.MainMenuSelection;
import module.menu.MemberMenu.*;
import module.menu.BookMenu.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberMenu memberMenu = new MemberMenu();
        BookMenu bookMenu = new BookMenu();
        LoanMenu loanMenu = new LoanMenu();


        while (true) {

            System.out.println("====================================================");
            System.out.println("<< 메인 메뉴 >>");
            System.out.println("1). 구성원 관리\n2). 도서 관리 \n3). 대출 관리 \n4). 종료");
            System.out.println("====================================================\n");
            int mainMenuSelection = sc.nextInt();

            if (mainMenuSelection == MainMenuSelection.MEMBERMANAGE.getValue()) {
                //구성원 관리
                while(true){

                System.out.println("====================================================");
                System.out.println("<< 구성원 관리 메뉴 >>");
                System.out.println("1). 구성원 추가\n2). 구성원 변경 \n3). 구성원 출력 \n4). 메인메뉴");            
                System.out.println("====================================================\n");

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
            } else if (mainMenuSelection == MainMenuSelection.BOOKMANAGE.getValue()) { 
                //도서 관리
                while(true){
                    System.out.println("====================================================");
                    System.out.println("<< 도서 관리 메뉴 >>");
                    System.out.println("1). 도서 추가\n2). 도서 변경 \n3). 도서 출력 \n4). 메인메뉴");
                    System.out.println("====================================================\n");
                    int bookMenuSelection = sc.nextInt();
                    if(bookMenuSelection == BookMenuEnum.BOOKADD.getValue()){
                            bookMenu.add();
                        }else if (bookMenuSelection == BookMenuEnum.BOOKCHANGE.getValue()){
                            bookMenu.change();
                        }else if (bookMenuSelection == BookMenuEnum.BOOKSHOW.getValue()){
                            bookMenu.show();
                        }else if(bookMenuSelection == BookMenuEnum.MAINMENU.getValue()){
                            break;
                        }else{
                            System.out.println("올바른 숫자를 입력\n");
                        }
                    }
            } else if (mainMenuSelection == MainMenuSelection.LOANMANAGE.getValue()) { //대출 관리
                while(true){
                    System.out.println("====================================================");
                    System.out.println("<< 대출 관리 메뉴 >>");
                    System.out.println("1). 도서 대출\n2). 도서 반납 \n3). 대출/반납 정보 출력 \n4). 메인메뉴");
                    System.out.println("====================================================");

                    int loanMenuSelection = sc.nextInt();
                    if(loanMenuSelection == LoanMenuEnum.LOANBOOK.getValue()){
                        loanMenu.add();
                    }else if (loanMenuSelection == LoanMenuEnum.RETURNBOOK.getValue()){
                        loanMenu.change();
                    }else if (loanMenuSelection == LoanMenuEnum.SHOWLOAN.getValue()){
                        loanMenu.show();
                    }else if(loanMenuSelection == LoanMenuEnum.MAINMENU.getValue()){
                        break;
                    }else{
                        System.out.println("올바른 숫자를 입력\n");
                    }
                }
            } else if (mainMenuSelection == MainMenuSelection.EXIT.getValue()){
                break;
            }
        }
    }
}