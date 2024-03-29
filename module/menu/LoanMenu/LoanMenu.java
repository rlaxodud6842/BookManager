package module.menu.LoanMenu;
import module.menu.BookMenu.Book;
import module.menu.BookMenu.BookMenu;
import module.menu.MemberMenu.MemberMenu;
import module.menu.Menu;

import module.menu.MemberMenu.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LoanMenu implements Menu, Serializable {
    Scanner sc = new Scanner(System.in);
    private static ArrayList<Loan> loanList = new ArrayList<>();
    BookMenu bm = new BookMenu();
    MemberMenu mm = new MemberMenu();

    public boolean isMemberLoanable(ArrayList<Member> memberList,String targetmemberId){
        //여기서 찾는겨 두 맴버들이 확실한지.
        for (Member member : memberList){
            if(member.getId().equals(targetmemberId)){
                if(member.getState().equals("졸업")){
                    //타겟 멤버가 졸업이면
                    System.out.println("현재 입력받은 ID의 구성원은 졸업했기 때문에 대출불가합니다.");
                    return false;
                } else if (member.getState().equals("퇴사")) {
                    //퇴직이면
                    System.out.println("현재 입력받은 ID의 구성원은 퇴직했기 때문에 대출불가합니다.");
                    return false;
                }else{
                    //멤버는 맞는데 위 두 상태가 아니면 true
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isBookLoanable(ArrayList<Book> bookList, String targetbookId){
        //여기서 찾는겨 두 맴버들이 확실한지.
        for (Book book : bookList){
            if(book.getId().equals(targetbookId)){
                if(book.getState().equals("대출중")){
                    //대출중 이면
                    System.out.println("현재 입력받은 ID의 책은 대출중이기 때문에 대출불가합니다.");
                    return false;
                }else if (book.getState().equals("대출불가")) {
                    //대출 불가면
                    System.out.println("현재 입력받은 ID의 책은 대출불가이기 때문에 대출불가합니다.");
                    return false;
                }else{
                    // 멤버인건 맞고, 위 두 경우가 아니면 True
                    return true;
                }
            }
        }
        return false;
    }
    public void add(){
        ArrayList<Member> memberList = mm.getMemberList();
        ArrayList<Book> bookList = bm.getBookList();

        System.out.println("빌릴 구성원 ID를 입력해주세요");
        String targetmemberId = sc.nextLine();
        System.out.println("빌릴 도서 ID를 입력해주세요");
        String targetbookId = sc.nextLine();
        System.out.println("대출일자를 입력해주세요");
        String loanDate = sc.nextLine();
        String membername = null;

        if(isMemberLoanable(memberList,targetmemberId) && isBookLoanable(bookList,targetbookId)) {
            for(Member member : memberList){
                //타겟 아이디에 해당하는 이름을 얻어
                if(member.getId().equals(targetmemberId)){membername = member.getName();}
            }
            for(Book book : bookList){
                if(book.getId().equals(targetbookId)){
                    if(loanList.size() <= 0){
                        loanList.add(new Loan(book.getId(), book.getClassification(), book.getBookName(), membername, loanDate));
                    }else{
                        try{
                            for(Loan loaninfo : loanList){
                                if(loaninfo.getBookName().equals(book.getBookName())){
                                    loaninfo.loaning(membername,loanDate);
                                    break;
                                }else{
                                    loanList.add(new Loan(book.getId(), book.getClassification(), book.getBookName(), membername, loanDate));
                                }
                            }
                        }catch (Exception e){}
                    }
                    book.changeStateToLoaning();
                }
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
                loaninfo.returning(returnDate);
            }
        }
        //book 객체의 상태를 동기화 시켜준다.
        bm.sync(targetbookId,false);
    }
    public void show(){
        System.out.println("====================================================");
        System.out.println("구분 | 도서명 | 대출자 | 대출일 | 반납일 | 대출기간");
        System.out.println("----------------------------------------------------");

        ArrayList<Loan> magazineList = new ArrayList<>();
        ArrayList<Loan> studyFieldList = new ArrayList<>();

        for (Loan loaninfo : loanList) {
            //잡지이면
            if(loaninfo.getClassification().equals("잡지")){
                magazineList.add(loaninfo);
            }else{
                //전공이면
                studyFieldList.add(loaninfo);
            }
        }

        //각 이름 정렬
        Collections.sort(magazineList);
        Collections.sort(studyFieldList);

        for (Loan magazineLoan : magazineList){
            magazineLoan.print();
        }

        for (Loan studyFieldLoan : studyFieldList){
            studyFieldLoan.print();
        }
        System.out.println("====================================================");
    }
    public ArrayList<Loan> getLoanList(){
        return LoanMenu.loanList;
    }
    public void loadLoanList(ArrayList<Loan> loadedList){
        LoanMenu.loanList = loadedList;
    }

}

