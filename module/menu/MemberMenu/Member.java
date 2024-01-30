package module.menu.MemberMenu;

public class Member implements Comparable<Member>{
    private String name;
    private String major;
    protected boolean state = true;

    public void loadNameAndMajor(String name, String major){
        this.name = name;
        this.major = major;
    }

    public String getName(){
        return this.name;
    }

    public String getMajor(){
        return this.major;
    }
    public String getId(){return "id";}

    public String getState(){return "state";}

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