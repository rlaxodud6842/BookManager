package module.menu.BookMenu;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {
    private String bookName;
    private String publicationYear;
    private String publisher;
    private String state;
    private String etc;
    private String classification;
    
    public Book(String classification,String bookname, String publisher, String publicationYear,String state,String etc){
        this.classification = classification;
        this.bookName = bookname;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.state = state;
        this.etc = etc;
    }
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
    public String getClassification(){ return this.classification;}
    public void changeStateToLoanX(){
        this.state = "대출불가";
    }
    public void changeStateToLoaning(){
        this.state = "대출중";
    }

    public void changeStateToLoanO(){
        this.state = "대출가능";
    }

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
    public int getRawId(){
        return -1;
    }

}