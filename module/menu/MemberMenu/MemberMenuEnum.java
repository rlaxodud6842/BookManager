package module.menu.MemberMenu;
public enum MemberMenuEnum {
    MEMBERADD(1),MAMBERCHANGE(2),MEMBERSHOW(3),MAINMENU(4);
    private final int value;
    MemberMenuEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}