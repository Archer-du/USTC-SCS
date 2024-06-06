package ustc.pde.scs.sql.testdao.action;

import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.course.CourseSelect;
import ustc.pde.scs.entity.user.Assistant;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.sql.implementation.action.assist.AssAssistImpl;
import ustc.pde.scs.sql.implementation.action.assist.AssistImpl;
import ustc.pde.scs.sql.implementation.action.assist.CsAssistImpl;
import ustc.pde.scs.sql.implementation.action.select.CsSelectImpl;
import ustc.pde.scs.sql.implementation.action.select.SelectImpl;
import ustc.pde.scs.sql.implementation.action.select.StuSelectImpl;
import ustc.pde.scs.sql.implementation.course.CourseSelectImpl;
import ustc.pde.scs.sql.implementation.user.AssistantDAOImpl;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;

import java.util.ArrayList;

public class TestAssist {
    public static void main(String[] args) {
        ArrayList<Assistant> assistants = new AssistantDAOImpl().getAllAssistant();
        ArrayList<CourseSelect> courses = new CourseSelectImpl().getAll();
        Assistant stu = assistants.getFirst();
        Course course = courses.getFirst();
        basicTest(stu.getID(),course.getCourseId());
        advTest(stu.getID(),course.getCourseId());
    }
    public static void basicTest(String id, String courseId){
        AssistImpl assist = new AssistImpl();
        if(assist.insert(id,courseId)){
            System.out.println(assist.getCount().intValue());
        }else {
            System.out.println("插入失败");
        }

        if(assist.delete(id,courseId)){
            System.out.println("删除成功!");
        }
    }
    public static void advTest(String id, String courseId){
        CsAssistImpl csAssist = new CsAssistImpl();
        csAssist.insert(id,courseId);
        ArrayList<Assistant> students = csAssist.getAll(courseId);      //获取该课程所有助教信息
        for(Assistant s: students){
            System.out.println(s);
        }
        ArrayList<Course> courses = new AssAssistImpl().getAll(id);      //获取某学生所有助教课程信息

        for(Course course: courses){
            System.out.println(course);
        }
        csAssist.delete(id,courseId);
    }
}
