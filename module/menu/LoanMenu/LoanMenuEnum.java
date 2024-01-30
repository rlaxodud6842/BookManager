package module.menu.LoanMenu;
public enum LoanMenuEnum {
    LOANBOOK(1),RETURNBOOK(2),SHOWLOAN(3),MAINMENU(4);
    private final int value;
    LoanMenuEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
