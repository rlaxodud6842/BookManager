package module.menu;
public enum MainMenuSelection {
    MEMBERMANAGE(1),BOOKMANAGE(2),LOANMANAGE(3),EXIT(4);
    private final int value;
    MainMenuSelection(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}