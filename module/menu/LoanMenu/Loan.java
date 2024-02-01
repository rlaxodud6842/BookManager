package module.menu.LoanMenu;

import java.io.Serializable;
import java.util.ArrayList;

public class Loan implements Serializable {
    final private String classification;
    final private String bookName;
    final private String bookId;
    private ArrayList<String[]> loanInformation = new ArrayList<>();


    public Loan(String bookId,String classification,String bookName,String loaner,String loandate) {
        this.classification = classification;
        this.bookName = bookName;
        this.bookId = bookId;
        this.loaning(loaner,loandate);
    }

    public String getClassification(){return classification;}
    public String getBookName(){return bookName;}
    public String getbookId(){return bookId;}

    public void loanInfoAdd(String[] loanInfo){
        this.loanInformation.add(loanInfo);
    }

    public void loaning(String loaner, String loandate){
        //대출일, 반납일, 대출기간을 어레이에 담는 함수
        //Date date = new Date(loandate);
        String[] temp = new String[4];
        temp[0] = loaner;
        temp[1] = loandate;
        loanInformation.add(temp);
    }
    public void returning(String memberId, String returndate){
        for (String[] temp : loanInformation){
            //정보들 중에서 loaner의 정보를 찾고
            if (temp[0].equals(memberId)){
                Date ldate = new Date(temp[1]);
                Date rdate = new Date(returndate);
                //그놈 기반으로 loandate 얻고 거기서 return데이터 갱신
                temp[2] = returndate;
                temp[3] = ldate.getLoanDate(rdate);
            }
        }
    }

    public void print(){
        int counter = 0;
        for (String[] loaninfo : loanInformation){
            StringBuilder sb = new StringBuilder();
            String loaner = loaninfo[0];
            String loanDate = loaninfo[1];
            String returnDate;
            String loanDue;
            if (loaninfo[2] == null){
                returnDate = " ";
            }else{
                returnDate = loaninfo[2];
            }

            if (loaninfo[3] == null){
                loanDue = " ";
            }else{
                loanDue = loaninfo[3];
            }

            if (counter > 0){
                sb.append("                 ");
                sb.append(loaner+"   ");
                sb.append(loanDate+"   ");
                sb.append(returnDate+"   ");
                sb.append(loanDue+"   ");
                System.out.println(sb);
            }else{
                sb.append(classification+"   ");
                sb.append(bookName+"   ");
                sb.append(loaner+"   ");
                sb.append(loanDate+"   ");
                sb.append(returnDate+"   ");
                sb.append(loanDue+"   ");
                System.out.println(sb);
                counter++;
                //처음 출력되는거라면
            }
            counter++;
        }
    }

}
