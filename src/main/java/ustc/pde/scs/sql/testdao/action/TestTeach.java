package ustc.pde.scs.sql.testdao.action;

import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.course.CourseSelect;
import ustc.pde.scs.entity.user.Teacher;
import ustc.pde.scs.sql.implementation.action.teach.CsTeachImpl;
import ustc.pde.scs.sql.implementation.action.teach.TeaTeachImpl;
import ustc.pde.scs.sql.implementation.action.teach.TeachImpl;
import ustc.pde.scs.sql.implementation.course.CourseSelectImpl;
import ustc.pde.scs.sql.implementation.user.TeacherDAOImpl;

import java.util.ArrayList;

public class TestTeach {
    public static void main(String[] args) {
        Teacher teacher = new TeacherDAOImpl().getAllTeacher().getFirst();
        Course course = new CourseSelectImpl().getAll().getFirst();
        TeachImpl teach = new TeachImpl();
        if(teach.insert(teacher.getID(), course.getCourseId())){
            System.out.println("插入成功");
            System.out.println(teach.getCount().intValue());
        }else{
            System.out.println("插入失败");
        }
        ArrayList<Teacher> teachers = new CsTeachImpl().getAll(course.getCourseId());
        ArrayList<Course> courses = new TeaTeachImpl().getAll(teacher.getID());
        for(Teacher t: teachers){
            System.out.println(t);
        }
        for(Course cs: courses){
            System.out.println(cs);
        }
        if(teach.delete(teacher.getID(),course.getCourseId())){
            System.out.println("删除成功");
        }

    }
}
