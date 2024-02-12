package module.menu.BookMenu;
class StudyField extends Book{
    private static int id = 0;
    private final int bid;

    public StudyField(String classification,String bookName, String publisher, String publicationYear,String state,String etc, int lastId){
        super(classification,bookName,publisher,publicationYear,state,etc);
        StudyField.id = lastId;
        StudyField.id++;
        bid = StudyField.id;
    }
    public int getRawId(){
        return bid;
    }
    public String getId(){
        return "B"+bid;
    }
    
}
