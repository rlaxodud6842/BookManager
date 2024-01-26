package module.menu.BookMenu;

class Book implements Comparable<Book>{
    private String bookName;
    private String publicationYear;
    private String publisher;
    private String state;
    private String etc;
    
    public Book(String bookname, String publisher, String publicationYear,String state,String etc){
        this.bookName = bookname;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.state = state;
        this.etc = etc;
    }
    //도서명 bookname
    //출판사 publisher
    //출판년도(년월일) Publication year
    //상태(대출 가능, 대출 중, 대출 불가) state
    public String getBookName(){
        return this.bookName;
    }

    public String getPublisher(){return this.publisher;}
    public String getPublishcationYear(){
        return this.publicationYear;
    }
    public String getId(){return "id";}
    public String getState(){ return this.state;}
    public String getEtc(){ return this.etc;}
    public String changeState(){
        this.state = "대출 불가";
        return "변경이 완료되었습니다";
    };
    
    @Override
    public int compareTo(Book o) {
        int compareResult = this.bookName.compareTo(o.bookName);
        if (compareResult < 0) {
            return -1;
        } else if (compareResult > 0) {
            return 1;
        }
        return 0;
    }

}

// 도서 관리 정보는 다음과 같다.
// ● 잡지 도서 정보: ID (M+2자리 숫자), 도서명, 출판사, 출판년도(년월일), 상태(대출 가능, 대출 중, 대출 불가), 권/호
// ● 전공 도서 정보: ID (B+2자리 숫자), 도서명, 출판사, 출판년도(년월일), 상태(대출 가능, 대출 중, 대출 불가), 세부 주제

//아이디는 별개
//잡지는 권호, 전공도서는 세부주제
//나머지는 동일