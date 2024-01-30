package module.menu.LoanMenu;
import module.menu.BookMenu.Book;
import module.menu.BookMenu.BookMenu;
import module.menu.MemberMenu.MemberMenu;
import module.menu.Menu;

import module.menu.MemberMenu.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class LoanMenu implements Menu{
    Scanner sc = new Scanner(System.in);
    private static ArrayList<Loan> loanList = new ArrayList<>();
    BookMenu bm = new BookMenu();
    MemberMenu mm = new MemberMenu();

    public boolean isRealMember(ArrayList<Member> memberList, String memberId){
        //여기서 찾는겨 두 맴버들이 확실한지.
        for (Member member : memberList){
            if(member.getId().equals(memberId)){return true;}
        }
        return false;
    }
    public boolean isRealBook(ArrayList<Book> bookList, String bookId){
        //여기서 찾는겨 두 맴버들이 확실한지.
        for (Book book : bookList){
            if(book.getId().equals(bookId)){return true;}
        }
        return false;
    }


    public void add(){
        ArrayList<Member> memberList = mm.getMemberList();
        ArrayList<Book> bookList = bm.getBookList();

        System.out.println("빌릴 구성원 ID를 입력해주세요");
        String targetmemberId = "U1";//sc.nextLine();
        System.out.println("빌릴 도서 ID를 입력해주세요");
        String targetbookId = "M1";//sc.nextLine();
        System.out.println("대출일자를 입력해주세요");
        String loanDate = "2023.01.01";//sc.nextLine();

        String membername = null;
        boolean earlyflag = true;

        if(isRealMember(memberList,targetmemberId) && isRealBook(bookList,targetbookId)){
            for(Member member : memberList){
                member.getState().equals("졸업");

                if(member.getId().equals(targetmemberId)){
                    if(member.getState().equals("졸업")){
                        //타겟 멤버가 졸업이면
                        System.out.println("현재 입력받은 ID의 구성원은 졸업했기 때문에 대출불가합니다.");
                        earlyflag = false;
                    } else if (member.getState().equals("퇴사")) {
                        System.out.println("현재 입력받은 ID의 구성원은 퇴직했기 때문에 대출불가합니다.");
                        earlyflag = false;
                    }
                    membername = member.getName();
                }
                //퇴직, 졸업이면 출력하고 그냥 추가 종료해야함.
            }
            if (earlyflag){
                //졸업이거나 퇴사가 아니면
                for(Book book : bookList){
                    if(book.getId().equals(targetbookId)){
                        if(book.getState().equals("대출중")){
                            //대출중 이면
                            System.out.println("현재 입력받은 ID의 책은 대출중이기 때문에 대출불가합니다.");
                            break;
                        } else if (book.getState().equals("대출불가")) {
                            //대출 불가면
                            System.out.println("현재 입력받은 ID의 책은 대출불가이기 때문에 대출불가합니다.");
                            break;
                        }

                        //이게 기존에 있던건지 새로운건지 판단
                        if(loanList.size() > 0){
                            for (Loan loaninfo : loanList){
                                if(loaninfo.getBookName().equals(book.getBookName())){
                                    //정보만 추가해주하는 함수
                                    loaninfo.loaning(membername,loanDate);
                                }
                            }
                            //기존에 없던것이니 새로 등록해주는 함수
                        }else{
                            loanList.add(new Loan(book.getId(),book.getClassification(),book.getBookName(),membername,loanDate));
                        }
                        System.out.printf("%s이 %s에게 대출되었습니다\n",book.getBookName(),membername);
                        bm.sync(book.getId(),true); //동기화
                        break;
                    }
                }
            }else{
                //졸업이거나 퇴사면
            }
        }else{
            //아닌경우
            System.out.println("올바르지 않은 입력입니다.");
        }
    }
    public void change(){
        System.out.println("반납할 도서 ID를 입력해주세요");
        String targetbookId = sc.nextLine();
        System.out.println("반납일자를 입력해주세요");
        String returnDate = sc.nextLine();

        //loanlist에서 bookid를 찾는다.
        for (Loan loaninfo : loanList){
            if (loaninfo.getbookId().equals(targetbookId)){
                //찾아서 그녀석의 반납일자와 반납일을 갱신시켜준다
                loaninfo.returning(loaninfo.getbookId(),returnDate);
            }
        }
        //book 객체의 상태를 동기화 시켜준다.
        bm.sync(targetbookId,false);
    }
    public void show(){
        for (Loan loaninfo : loanList){
            loaninfo.print();
        }
    }
}

