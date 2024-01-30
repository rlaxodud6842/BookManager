package module.menu.LoanMenu;
import java.util.ArrayList;
import java.util.Collections;

public class Loan {
    final private String classification;
    final private String bookName;
    final private String bookId;
    private static ArrayList<String[]> loanInformation = new ArrayList<>();

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
    public void returning(String bookId, String returndate){
        for (String[] temp : loanInformation){
            //정보들 중에서 loaner의 정보를 찾고
            if (temp[0].equals(bookId)){
                Date ldate = new Date(temp[1]);
                Date rdate = new Date(returndate);
                //그놈 기반으로 loandate 얻고 거기서 return데이터 갱신
                temp[2] = returndate;
                temp[3] = ldate.getLoanDate(rdate);
                loanInformation.add(temp);
            }
        }
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(classification);
        sb.append(bookName);
        int counter = 0;

        ArrayList<String[]> tempLoanInformation = loanInformation;

        if (tempLoanInformation.size() > 1){
            while(tempLoanInformation.size() != 0){
                Date min = new Date("0000.00.00");
                for(String[] loaninfo : tempLoanInformation){
                    //어레이 리스트를 순회하면서 (제일 작을때) 멈춰서 그녀석을 sb append함
                    //돌때마다 제일 작은걸 저장
                    Date loandate = new Date(loaninfo[1]);
                    if(loandate.isSmallerThanArgument(min)){min = loandate;}
                    //한번더 돌아서 작은놈 sb에 넣고 삭제
                }

                for(String[] loaninfo : tempLoanInformation){
                    Date loandate = new Date(loaninfo[1]);
                    if(loandate.isSameValue(min)){
                        if(counter > 1){
                            System.out.printf("            %s %s %s %s",loaninfo[0],loaninfo[1],loaninfo[2],loaninfo[3]);
                        }
                        sb.append(loaninfo[0]);
                        sb.append(loaninfo[1]);
                        sb.append(loaninfo[2]);
                        sb.append(loaninfo[3]);
                        System.out.println(sb);
                        //처음이면 sb어펜드 시켜서 출력
                        //2회 이상이면 그냥 프린트 시켜
                    }
                    tempLoanInformation.remove(loaninfo);
                    //한번더 돌아서 작은놈 sb에 넣고 삭제
                }
            }
        }else{
            //그냥 일반 경우
        }
    }
}

    //{""}
    //입력 : 구성원 ID와 도서 ID, 대출일
    //결국 구성원, 도서의 정보를 받아와서 그중에서 찾아야함.
    //대출 상태가 된다는것.

//    ==================================================
//    구분   도서명      대출자  대출일       반납일       대출기간
//--------------------------------------------------
//    잡지   자연       강감찬  2017.05.03.  2017.05.05.  3
//                     이순신  2018.05.13.  2018.05.25.  13
//                     이순신  2018.05.15.  2018.05.25.  13
//                     이순신  2017.03.15.  2018.05.25.  13
//    전공   동물 다큐   이순신  2017.06.12.  2017.06.20.  9
//          네트워크    이순신  2019.05.01.  (현재 대출중인 경우 반납일과 대출기간 정보 없음)
//            ==================================================

