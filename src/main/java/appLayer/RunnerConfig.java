package appLayer;

import DatabaseLayer.daoLayer.StudentDao;
import EntityLayer.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RunnerConfig {

    public static void runnerMethod() {
        System.out.println("******Student Database App***********");
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        StudentDao studentDao = new StudentDao();
        Boolean exit = false;
        while (true) {
            System.out.println("************************");
            System.out.println("Select any of the below options :");
            System.out.println("Enter 1 to Add Student data");
            System.out.println("Enter 2 to Update Student data");
            System.out.println("Enter 3 to View Student data");
            System.out.println("Enter 4 to Delete Student data");
            System.out.println("Enter 5 to Exit from the app");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Enter id");
                    int id = sc.nextInt();
                    student.setSid(id);
                    sc.nextLine();
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    student.setSname(name);
                    studentDao.addStudentData(student);
                    break;
                case 2:
                    System.out.println("Enter Student ID :");
                    id = sc.nextInt();
                    student.setSid(id);
                    sc.nextLine();
                    System.out.println("Enter updated name :");
                    name = sc.nextLine();
                    student.setSname(name);
                    studentDao.updateStudentData(student);
                    break;
                case 3:
                    System.out.println("Retrive data");
                    List studentList = studentDao.retriveStudentData();
                    for (Object studentMap : studentList){
                        System.out.println(studentMap);
                    }
                    break;
                case 4:
                    System.out.println("Enter Student ID to delete student data >>>>");
                    studentDao.deleteStudentData(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Exiting");
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid input");

            }
            if (exit==true){
                break;
            }
        }
    }

}
