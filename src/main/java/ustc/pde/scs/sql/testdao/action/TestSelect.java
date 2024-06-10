package ustc.pde.scs.sql.testdao.action;

import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.course.CourseGrade;
import ustc.pde.scs.entity.course.CourseSelect;
import ustc.pde.scs.entity.relation.Score;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.sql.implementation.action.grade.CsGradeImpl;
import ustc.pde.scs.sql.implementation.action.grade.GradeImpl;
import ustc.pde.scs.sql.implementation.action.grade.StuGradeImpl;
import ustc.pde.scs.sql.implementation.action.select.CsSelectImpl;
import ustc.pde.scs.sql.implementation.action.select.SelectImpl;
import ustc.pde.scs.sql.implementation.action.select.StuSelectImpl;
import ustc.pde.scs.sql.implementation.course.CourseSelectImpl;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;

import java.util.ArrayList;

public class TestSelect {
    public static void main(String[] args) {
//        ArrayList<Student> students = new StudentDAOImpl().getAllStudent();
//        ArrayList<CourseSelect> courses = new CourseSelectImpl().getAll();
//        Student stu = students.getFirst();
//        Course course = courses.getFirst();
//        basicTest(stu.getID(),course.getCourseId());
//        advTest(stu.getID(),course.getCourseId());
    }
    public static void basicTest(String id, String courseId){
        SelectImpl select = new SelectImpl();
        if(select.insert(id,courseId)){
            System.out.println(select.getCount().intValue());
        }else {
            System.out.println("插入失败");
        }

        if(select.delete(id,courseId)){
            System.out.println("删除成功!");
        }
    }
    public static void advTest(String id, String courseId){
        CsSelectImpl csSelect = new CsSelectImpl();
        csSelect.insert(id,courseId);
        ArrayList<Student> students = csSelect.getAll(courseId);      //获取该课程所有学生信息
        for(Student s: students){
            System.out.println(s);
        }
        StuSelectImpl stuSelect = new StuSelectImpl();
        ArrayList<CourseSelect> courseSelects = stuSelect.getAll(id);      //获取某学生所有已选课程信息

        for(Course course: courseSelects){
            System.out.println(course);
        }

        csSelect.delete(id,courseId);
    }
}
