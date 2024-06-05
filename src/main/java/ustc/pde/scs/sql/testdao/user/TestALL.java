package ustc.pde.scs.sql.testdao.user;

import ustc.pde.scs.entity.user.Assistant;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.entity.user.Teacher;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.user.AssistantDAOImpl;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;
import ustc.pde.scs.sql.implementation.user.TeacherDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.util.AbstractSequentialList;
import java.util.ArrayList;

public class TestALL {
    public static void main(String[] args) {
        //users
        System.out.println("Users is as follows:");
        ArrayList<User> users = new UserDAOImpl().getAll();
        for(User u: users){
            System.out.println(u);
        }
        //students
        System.out.println("Students is as follows:");
        ArrayList<Student> students = new StudentDAOImpl().getAllStudent();
        for(Student student: students){
            System.out.println(student);
        }
        //teachers
        System.out.println("Teachers is as follows:");
        ArrayList<Teacher> teachers = new TeacherDAOImpl().getAllTeacher();
        for(Teacher teacher: teachers){
            System.out.println(teacher);
        }
        //assistants
        System.out.println("Assistants is as follows:");
        ArrayList<Assistant> assistants = new AssistantDAOImpl().getAllAssistant();
        for(Assistant assistant: assistants){
            System.out.println(assistant);
        }
    }
}
