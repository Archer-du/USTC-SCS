package ustc.pde.scs.sql.testdao.user;

import ustc.pde.scs.entity.major.Major;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;


import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Date;

public class TestStudent extends TestUser{
    public static void main(String[] args) throws SQLException {

        Student student = new Student("2023-11-03","本科生","大三春季学期");
        student.setName("侯甲申");
        student.setUsername("hjs");
        student.setPassword("hou13216");
        student.setID("PB210");
        student.setIdCard("123123");
        student.setEmail("12313213");
        student.setMajor(new Major("123","计算机","sjdkal"));
        //System.out.println(student.toString());
        StudentDAOImpl studentDAO = new StudentDAOImpl();

        if(studentDAO.insert(student)){
            System.out.println("插入成功");
        }
        System.out.println(studentDAO.getObject(student.getID()).toString());
        student.setIdCard("4114810000000");
        if(studentDAO.update((User) student)){
            System.out.println(new UserDAOImpl().getObject(student.getID()).toString());
        }
        if(studentDAO.delete(student.getID())){

            System.out.println("删除成功");
        }

    }
}
