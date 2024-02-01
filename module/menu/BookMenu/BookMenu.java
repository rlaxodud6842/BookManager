package module.menu.BookMenu;
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
//        System.out.println("잡지인가요, 전공인가요?");
//        String classification = sc.nextLine();
//
//        System.out.println("도서명은 무엇입니까?");
//        String bookname = sc.nextLine();
//        System.out.println("출판사는 어디입니까?");
//        String publisher = sc.nextLine();
//        System.out.println("출판년도(년월일)는 언제입니까?");
//        String publicationYear = sc.nextLine();
//        System.out.println("| 대출가능 | 대출중 | 대출불가 |\n 상태를 입력해주세요");
//        String state = sc.nextLine();
//
//        if (classification.equals("잡지")){
//            //잡지일 경우
//            System.out.println("권/호를 입력해주세요");
//            String etc = sc.nextLine();
//            Book magazine = new Magazine(classification,bookname,publisher,publicationYear,state,etc);
//            bookList.add(magazine);
//       }else if (classification.equals("전공")){
//            System.out.println("세부주제를 입력해주세요");
//            String etc = sc.nextLine();
//            Book studyField = new StudyField(classification,bookname,publisher,publicationYear,state,etc);
//            bookList.add(studyField);
//       }else{
//            System.out.println(classification + "<- 잘못 입력된 문자");
//       }
        Book m = new StudyField("전공","네트워크","publisher","publicationYear","대출가능","etc");
        Book b = new Magazine("잡지","콜라마시기","publisher","publicationYear","대출가능","etc");
        bookList.add((m));
        bookList.add((b));
    }

    public void change(){
        //사용자에게 변경할 ID 입력
        sc = new Scanner(System.in);
        System.out.println("변경시키고 싶은 ID를 입력하세요");
        String targetId = sc.nextLine();
        //배열중에서 찾아서 변경시키기
        for (Book book : bookList) {
            if(book.getId().equals(targetId)){
                if(book.getState().equals("대출중")){
                    System.out.println("대출중인 도서는 변경 불가능");
                    break;
                }
                System.out.println(book.changeStateToLoanX());
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
        ArrayList<Book> studyFieldsList = new ArrayList<>();
        ArrayList<Book> magazinList = new ArrayList<>();
        for (Book book : bookList) {
            //교수인지 학생인지 구분 후 각각 배열에 넣기
            if(book.getId().charAt(0) == 'M'){
                magazinList.add(book);

            }else{
                studyFieldsList.add(book);
            }
            //이름 오름차순 정렬
            Collections.sort(magazinList);
            Collections.sort(studyFieldsList);
        }
        //교수 출력
        System.out.println("==================================================");
        System.out.println("ID | 도서명 | 출판사 | 출판년도 | 상태 | 권/호 |");
        System.out.println("--------------------------------------------------");
        for (Book magazine : magazinList) {
            print(magazine);
        }
        //학생 출력
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
                    book.changeStateToLoan();
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
}

