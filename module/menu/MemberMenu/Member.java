package module.menu.MemberMenu;

import java.io.Serializable;

public class Member implements Comparable<Member>, Serializable {
    private String name;
    private String major;
    protected boolean state = true;

    public void loadNameAndMajor(String name, String major){
        this.name = name;
        this.major = major;
    }
    public int getRawId(){
        return -1;
    }

    public String getName(){
        return this.name;
    }

    public String getMajor(){
        return this.major;
    }
    public String getId(){return "id";}

    public String getState(){return "state";}

    public void getAdditionalInformation(){}
    public String[] loadAdditionalInformation(){
        String[] informations = new String[0];
        return informations;
    }

    @Override
    public int compareTo(Member o) {
        int compareResult = this.name.compareTo(o.name);
        if (compareResult < 0) {
            return -1;
        } else if (compareResult > 0) {
            return 1;
        }
        return 0;
    }

}