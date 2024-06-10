package ustc.pde.scs.sql.testdao.action;

import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.course.CourseGrade;
import ustc.pde.scs.entity.course.CourseSelect;
import ustc.pde.scs.entity.relation.Score;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.sql.implementation.action.grade.CsGradeImpl;
import ustc.pde.scs.sql.implementation.action.grade.GradeImpl;
import ustc.pde.scs.sql.implementation.action.grade.StuGradeImpl;
import ustc.pde.scs.sql.implementation.course.CourseSelectImpl;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;

import java.util.ArrayList;

public class TestGrade {
    public static void main(String[] args) {
//        ArrayList<Student> students = new StudentDAOImpl().getAllStudent();
//        ArrayList<CourseSelect> courses = new CourseSelectImpl().getAll();
//        Student stu = students.getFirst();
//        Course course = courses.getFirst();
//        Score score = new Score(stu.getID(),course.getCourseId(),"99");
//        basicTest(score);
//        advTest(score);
    }
    public static void basicTest(Score score){
        GradeImpl grade = new GradeImpl();
        if(grade.insert(score)){
            System.out.println(grade.getObject(score.getID()+ " "+ score.getCourseId()));
        }else {
            System.out.println("插入失败");
        }
        score.setGrade("A+");
        if(grade.update(score)){
            System.out.println(grade.getObject(score.getID()+" "+score.getCourseId()));
        }
        if(grade.delete(score.getID()+" "+score.getCourseId())){
            System.out.println("删除成功!");
        }
    }
    public static void advTest(Score score){
        CsGradeImpl csGrade = new CsGradeImpl();
        csGrade.insert(score);
        ArrayList<Score> scores = csGrade.getAll(score.getCourseId());      //获取该课程所有学生分数
        for(Score s: scores){
            System.out.println(s);
        }
        StuGradeImpl stuGrade = new StuGradeImpl();
        ArrayList<Score> scores1 = stuGrade.getAll(score.getID());      //获取某学生所有课程分数
        for(Score s: scores1){
            System.out.println(s);
        }
        ArrayList<CourseGrade> courses = stuGrade.getAllGradeCourse(score.getID());      //获取某学生所有出分课程信息
        for(Course course: courses){
            System.out.println(course);
        }
    }
}
