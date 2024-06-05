package ustc.pde.scs.sql.implementation.course;

import ustc.pde.scs.entity.course.CourseGrade;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseGradeImpl extends CourseDAOImpl{
    boolean insert(CourseGrade courseGrade) throws SQLException {
        if(super.insert(courseGrade)){
            String sql = "update Course set maxNum = ? where courseId = ?";
            executeUpdate(sql,courseGrade.getGradeMeans());
            return true;
        }
        return false;
    }
    boolean update(CourseGrade courseGrade) throws SQLException {
        if(super.update(courseGrade)){
            String sql = "update Course set maxNum = ? where courseId = ?";
            executeUpdate(sql,courseGrade.getGradeMeans(),courseGrade.getCourseId());
            return true;
        }
        return false;
    }
    @Override
    public CourseGrade getObject(String courseId) {
        String sql = "select courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum from Course " +
                "where courseId = ?";
        return getInstance(CourseGrade.class,sql,courseId);
    }


    public ArrayList<CourseGrade> getAll() {
        String sql = "select courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum from Course";
        return getInstance2(CourseGrade.class,sql);
    }
}
