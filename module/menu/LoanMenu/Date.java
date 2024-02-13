package module.menu.LoanMenu;

import java.io.Serializable;

public class Date{
    private String originalDate;
    private int year;
    private int month;
    private int day;
    public Date(String date){
        String [] array = date.split("\\.");
        this.year = Integer.parseInt(array[0]);
        this.month = Integer.parseInt(array[1]);
        this.day = Integer.parseInt(array[2]);
        this.originalDate = date;
    }
    public String getLoanDate(Date returnDay){
        int totalLoanDate = 0;
        totalLoanDate += (returnDay.year - this.year)*365;
        totalLoanDate += (returnDay.month - this.month)*30;
        totalLoanDate += (returnDay.day - this.day);
        return String.valueOf(totalLoanDate);
    }


}
