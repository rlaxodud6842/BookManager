package module.menu.BookMenu;
public enum BookMenuEnum {
    BOOKADD(1),BOOKCHANGE(2),BOOKSHOW(3),MAINMENU(4);
    private final int value;
    BookMenuEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}