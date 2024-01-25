package module.menu.BookMenu;
import module.menu.Menu;
import module.menu.MemberMenu.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookMenu implements Menu{
    /*
     * �� ���� ���� ����: ID (M+2�ڸ� ����), ������, ���ǻ�, ���ǳ⵵(�����), ����(���� ����, ���� ��, ���� �Ұ�), ��/ȣ
        �� ���� ���� ����: ID (B+2�ڸ� ����), ������, ���ǻ�, ���ǳ⵵(�����), ����(���� ����, ���� ��, ���� �Ұ�), ���� ����
     */
    ArrayList<Member> memberList = new ArrayList<Member>();
    Scanner sc = new Scanner(System.in);

    public void add(){
        //�������� �������� Ȯ���ϱ�
        //���� �߰� ���� �Է��ϰ� �ϱ�
        System.out.println("1 (m/f)");
        String identify = sc.nextLine();

        System.out.println("�̸��� �����Դϱ�?");
        String name = sc.nextLine();
        System.out.println("������ �����Դϱ�?");
        String major = sc.nextLine();

        if (identify.equals("s")){ //�л��� ���
            Member student = new Student(name,major);
            memberList.add(student);
            student.getAdditionalInformation();
       }else if (identify.equals("l")){ // ������ ���
            Member lecture = new FieldOfStudy(name,major);
            memberList.add(lecture);
            lecture.getAdditionalInformation();
       }else{
            System.out.println(identify + "<- �߸� �Էµ� ����");
       }
    }

    public void change(){
        //����ڿ��� ������ ID �Է�
        sc = new Scanner(System.in);
        System.out.println("�����Ű�� ���� ID�� �Է��ϼ���");
        String targetId = sc.nextLine();
        //�迭�߿��� ã�Ƽ� �����Ű��
        for (Member member : memberList) {
            if(member.getId().equals(targetId)){
                if(member.state == true){
                    member.state = false;
                }else{
                    member.state = true;
                }
            }
        }
    }

    public void print(Member member, int limit){
        StringBuilder sb = new StringBuilder();
        String[] addtionalInformataion = member.loadAdditionalInformation();
        sb.append(member.getId() + " | ");
        sb.append(member.getName() + " | ");
        sb.append(member.getMajor()+ " | ");
        sb.append(member.getState()+ " | ");

        for (int i = 0; i<limit; i++){
            sb.append(addtionalInformataion[i] + " | ");
        }
        System.out.println(sb);
    }
    public void show(){
        ArrayList<Member> lectureList = new ArrayList<>();
        ArrayList<Member> studentList = new ArrayList<>();
        
        System.out.println("�����ֱ�");
        for (Member member : memberList) {
            //�������� �л����� ���� �� ���� �迭�� �ֱ�
            if(member.getId().charAt(0) == 'F'){
                lectureList.add(member);
            }else{
                studentList.add(member);
            }
            //�̸� �������� ����
            Collections.sort(lectureList);
            Collections.sort(studentList);
        }
        //���� ���
        System.out.println("==================================================");
        System.out.println("ID | ���� | �а� | ���� | ���� | ������ |");
        System.out.println("--------------------------------------------------");
        for (Member lecture : lectureList) {
            print(lecture,2);
        }
        //�л� ���
        System.out.println("==================================================");
        System.out.println("ID | ���� | �а� | ���� | �г� | ���� | ����ó |");
        System.out.println("--------------------------------------------------");
        for (Member student : studentList) {
            print(student,3);
        }
    }
    public void back(){}
}

