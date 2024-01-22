package module.menu.MemberMenu;

public class Student extends Member{
    private static int id = 0;

    public Student(String name, String major){
        super(name,major);
        Student.id++;
    }

    public String getId(){
        return "U"+Student.id;
    }
}
