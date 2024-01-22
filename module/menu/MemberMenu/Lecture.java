package module.menu.MemberMenu;


class Lecture extends Member{
    private static int id = 0;

    public Lecture(String name, String major){
        super(name,major);
        Lecture.id++;
    }

    public String getId(){
        return "F"+Lecture.id;
    }
}
