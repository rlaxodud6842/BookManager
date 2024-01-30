package module.menu.BookMenu;
class Magazine extends Book{
    private static int id = 0;
    private int mid;

    public Magazine(String classification, String bookName, String publisher, String publicationYear,String state,String etc){
        super(classification,bookName,publisher,publicationYear,state,etc);
        Magazine.id++;
        mid = Magazine.id;
    }
    public String getId(){
        return "M"+mid;
    }
    
}
