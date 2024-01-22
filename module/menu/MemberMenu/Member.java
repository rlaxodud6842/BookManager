package module.menu.MemberMenu;

class Member{
    private String name;
    private String major;
    private boolean state;

    public Member(String name, String major){
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
}


// class Student extends Member{
//     String grade;
//     float grades;
//     String phoneNumber;
//     public Student(String name,String department,String state,String grade,float grades, String phoneNumber){
//         super();
//         this.id++;
//         this.name = name;
//         this.department =department;
//         this.state = state;
//         this.grade = grade;
//         this.grades = grades;
//         this.phoneNumber = phoneNumber;
//     }
// }

/*
 * ● 교수 정보: ID (F+2자리 숫자), 성명, 학과, 상태(재직 또는 퇴사), 전공, 연구실
● 학생 정보: ID (U+2자리 숫자), 성명, 학과, 상태(재학 또는 졸업), 학년, 학점, 연락처
 * 
 */