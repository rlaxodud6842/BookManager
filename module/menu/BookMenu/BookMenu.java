package module.menu.BookMenu;
import module.menu.LoanMenu.Loan;
import module.menu.LoanMenu.LoanMenu;
import module.menu.MemberMenu.Member;
import module.menu.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookMenu implements Menu, Serializable {
    private static ArrayList<Book> bookList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void add(){
//        전공인지 잡지인지 확인하기
//        이후 추가 정보 입력하게 하기
        System.out.println("잡지인가요, 전공인가요?");
        String classification = sc.nextLine();

        System.out.println("도서명은 무엇입니까?");
        String bookname = sc.nextLine();
        System.out.println("출판사는 어디입니까?");
        String publisher = sc.nextLine();
        System.out.println("출판년도(년월일)는 언제입니까?");
        String publicationYear = sc.nextLine();
        System.out.println("| 대출가능 | 대출중 | 대출불가 |\n 상태를 입력해주세요");
        String state = sc.nextLine();

        if (classification.equals("잡지")){
            //잡지일 경우
            System.out.println("권/호를 입력해주세요");
            String etc = sc.nextLine();
            Book magazine = new Magazine(classification,bookname,publisher,publicationYear,state,etc,getLastId("M"));
            bookList.add(magazine);
       }else if (classification.equals("전공")){
            System.out.println("세부주제를 입력해주세요");
            String etc = sc.nextLine();
            Book studyField = new StudyField(classification,bookname,publisher,publicationYear,state,etc,getLastId("S"));
            bookList.add(studyField);
       }else{
            System.out.println(classification + "<- 잘못 입력된 문자");
       }
    }

    public ArrayList<Book> getEachBookList(ArrayList<Book> bookList, boolean flag){
        //flag로 true면 잡지 리스트 리턴, false면 전공 리스트 리턴
        ArrayList<Book> magazineList = new ArrayList<>();
        ArrayList<Book> studyFieldList = new ArrayList<>();
        for (Book book : bookList) {
            //교수인지 학생인지 구분 후 각각 배열에 넣기
            if(book.getId().charAt(0) == 'M' && flag){
                magazineList.add(book);
            } else if (book.getId().charAt(0) == 'B' && !flag) {
                studyFieldList.add(book);
            }
        }
        if (flag){
            return magazineList;
        }else{
            return studyFieldList;
        }
    }

    public void change(){
        LoanMenu loanMenu = new LoanMenu();
        sc = new Scanner(System.in);
        System.out.println("변경시키고 싶은 ID를 입력하세요");
        String targetId = sc.nextLine();
        String loaner = "";

        ArrayList<Loan> loanList = loanMenu.getLoanList();

        //loanlist를 불러와서, 변경할 책 찾기전에 책이 있는지 확인함과 동시에 있다면 상태 가져오기, 찾은놈 이름, 책이름 출력
        //사용자에게 변경할 ID 입력

        //배열중에서 찾아서 변경시키기
        for (Book book : bookList) {
            //바꾸려는게 있나요?
            if(book.getId().equals(targetId)){
                //있으면 대출중인가요?
                if(book.getState().equals("대출중")){
                    //아 일단 대출중인건 안되고요
                    System.out.println("대출중인 도서는 변경 불가능합니다.");
                    //금마 누가 빌려간건지 알려줄게요
                    for (Loan loaninfo : loanList){
                        if (loaninfo.getbookId().equals(targetId)){
                            //그녀석 대출 정보중에 2,3 즉 반납일이 없으면 그녀석이 지금 빌려간놈입니다
                            ArrayList<String[]> loanInformation = loaninfo.getLoanInformation();
                            for (String[] loanArray : loanInformation){
                                if (loanArray[2] == null){
                                    loaner = loanArray[0];
                                }
                            }
                        }
                    }
                    System.out.printf("대출중인 도서명 : %s 대출자 이름 : %s\n",book.getBookName(),loaner);
                    break;
                }
                if(book.getState().equals("대출가능")){
                    book.changeStateToLoanX();
                    System.out.println("대출가능 -> 대출불가 변경되었습니다");
                } else if (book.getState().equals("대출불가")) {
                    book.changeStateToLoanO();
                    System.out.println("대출불가 -> 대출가능 변경되었습니다");
                }else{
                    System.out.println("Error");
                    return;
                }
            }
        }
    }

    public void print(Book book){
        StringBuilder sb = new StringBuilder();
        
        sb.append(book.getId()).append(" | ");
        sb.append(book.getBookName()).append(" | ");
        sb.append(book.getPublisher()).append(" | ");
        sb.append(book.getPublishcationYear()).append(" | ");
        sb.append(book.getState()).append(" | ");
        sb.append(book.getEtc()).append(" | ");
        System.out.println(sb);
    }
    public void show(){
        ArrayList<Book> studyFieldsList = getEachBookList(bookList,false);
        ArrayList<Book> magazinList = getEachBookList(bookList,true);

        //이름 오름차순 정렬
        Collections.sort(magazinList);
        Collections.sort(studyFieldsList);

        //잡지 출력
        System.out.println("==================================================");
        System.out.println("ID | 도서명 | 출판사 | 출판년도 | 상태 | 권/호 |");
        System.out.println("--------------------------------------------------");
        for (Book magazine : magazinList) {
            print(magazine);
        }
        //전공 출려
        System.out.println("==================================================");
        System.out.println("ID | 도서명 | 출판사 | 출판년도 | 상태 | 세부 주제 |");
        System.out.println("--------------------------------------------------");
        for (Book studyFields : studyFieldsList) {
            print(studyFields);
        }
    }
    public void sync(String bookId,boolean loanFalg){
        for (Book book : bookList){
            if (book.getId().equals(bookId)){
                if(loanFalg){
                    book.changeStateToLoaning();
                }else{
                    book.changeStateToLoanO();
                }
            }
        }

    }
    public ArrayList<Book> getBookList(){
        return BookMenu.bookList;
    }
    public void loadBookList(ArrayList<Book> loadedList){
        BookMenu.bookList = loadedList;
    }

    public int getLastId(String kind){
        ArrayList<Book> studyFieldsList = getEachBookList(bookList,false);
        ArrayList<Book> magazinList = getEachBookList(bookList,true);
        int maxId = Integer.MIN_VALUE;
        ArrayList<Book> targetList = null;

        if(kind.equals("M")){
            targetList = magazinList;
            //학생을 찾는다면
        } else if (kind.equals("S")) {
            //교수를 찾는다면
            targetList = studyFieldsList;
        }

        if (!targetList.isEmpty()){
            for (Book book : targetList){
                if(maxId < book.getRawId()){
                    maxId = book.getRawId();
                }
            }
        }else{
            return 0;
        }
        return maxId;
    }
}

