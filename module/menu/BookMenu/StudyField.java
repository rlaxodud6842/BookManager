package module.menu.BookMenu;
class StudyField extends Book{
    private static int id = 0;
    private final int bid;

    public StudyField(String bookName, String publisher, String publicationYear,String state,String etc){
        super(bookName,publisher,publicationYear,state,etc);
        StudyField.id++;
        bid = StudyField.id;
    }
    public String getId(){
        return "B"+bid;
    }
    
}