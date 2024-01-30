package module.menu.LoanMenu;

public class Date {
    private int year;
    private int month;
    private int day;
    public Date(String date){
        String [] array = date.split("\\.");
        this.year = Integer.parseInt(array[0]);
        this.month = Integer.parseInt(array[1]);
        this.day = Integer.parseInt(array[2]);
    }
    public String getLoanDate(Date returnDay){
        int totalLoanDate = 0;
        totalLoanDate += (returnDay.year - this.year)*365;
        totalLoanDate += (returnDay.month - this.month)*30;
        totalLoanDate += (returnDay.day - this.day);
        return String.valueOf(totalLoanDate);
    }
    public boolean isSmallerThanArgument(Date argument){
        //인자로 들어온놈보다 현재놈이 작으면 true
        return this.year <= argument.year && this.year <= argument.month && this.day <= argument.day;
    }
    public boolean isSameValue(Date argument){
        return this.year == argument.year && this.year == argument.month && this.day == argument.day;
    }

}
