package daoIMP;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import connection.DataBaseConnection;
import dao.StudentDAO;

import java.sql.PreparedStatement;

public class StudentDAOIMP implements StudentDAO {
    // ��Ӳ���
    public void insert(Student s) {
        String sql = "INSERT INTO student (id, name) values (?,?)";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2, s.getName());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }


    public void update(Student s) {
        String sql = "update student set id = ? and name = ? where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2, s.getName());
            pstmt.setLong(3, s.getID());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }


    public void delete(Long iD) {
        String sql = "delete from student where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, iD);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public List findAll() {
        String sql = "select * from student";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        ArrayList<Student> students = new ArrayList<>();
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                students.add(new Student(id, name));
            }
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return students;
    }

    public Student findByID(long iD) {
        String sql = "select * from student where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        Student student = new Student();
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, iD);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                student.setID(id);
                student.setName(name);
            }
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return student;
    }

}

