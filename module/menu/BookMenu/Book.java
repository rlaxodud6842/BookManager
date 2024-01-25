package module.menu.BookMenu;

class Book implements Comparable<Book>{
    private String bookName;
    private String major;
    private String publicationYear;
    private String publisher;
    private String state;
    
    public Book(String bookname, String major, String publisher, String publicationYear,String state){
        this.bookName = bookname;
        this.major = major;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.state = state;
    }
    //도서명 bookname
    //출판사 publisher
    //출판년도(년월일) Publication year
    //상태(대출 가능, 대출 중, 대출 불가) state
    public String getBookName(){
        return this.bookName;
    }

    public String getMajor(){
        return this.major;
    }
    public String getId(){return "id";}

    public String getState(){
        
        this.state.equals("Loan available","On loan","No loan possible");
        return "state";
    }

    public void getAdditionalInformation(){}

    public String[] loadAdditionalInformation(){
        String[] informations = new String[0];
        return informations;
    }
    
    @Override
    public int compareTo(Book o) {
        int compareResult = this.name.compareTo(o.name);
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