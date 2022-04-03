import bean.Student;
import dao.StudentDAO;
import daoIMP.StudentDAOIMP;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOIMP();
        System.out.println(studentDAO.findAll());
        Student student = studentDAO.findByID(1L);
        System.out.println(student);
        studentDAO.delete(1L);
        System.out.println(studentDAO.findAll());
        studentDAO.insert(new Student(3 , "wangwu"));
        System.out.println(studentDAO.findAll());
    }
}
