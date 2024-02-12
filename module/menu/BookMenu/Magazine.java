package module.menu.BookMenu;
class Magazine extends Book{
    private static int id = 0;
    private int mid;

    public Magazine(String classification, String bookName, String publisher, String publicationYear,String state,String etc,int lastId){
        super(classification,bookName,publisher,publicationYear,state,etc);
        Magazine.id = lastId;
        Magazine.id++;
        mid = Magazine.id;
    }
    public String getId(){
        return "M"+mid;
    }
    public int getRawId(){
        return mid;
    }

    
}
