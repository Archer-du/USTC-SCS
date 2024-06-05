package dao.implementation.course;

import data.course.Course;
import data.course.CourseSelect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class CourseSelectImpl extends CourseDAOImpl{
    boolean insert(CourseSelect courseSelect) throws SQLException {
        if(super.insert(courseSelect)){
            String sql = "update Course set maxNum = ? where courseId = ?";
            executeUpdate(sql,courseSelect.getMaxNum(),courseSelect.getCourseId());
            return true;
        }
        return false;
    }
    boolean update(CourseSelect courseSelect) throws SQLException {
        if(super.update(courseSelect)){
            String sql = "update Course set maxNum = ? where courseId = ?";
            executeUpdate(sql,courseSelect.getMaxNum(),courseSelect.getCourseId());
            return true;
        }
        return false;
    }
    @Override
    public CourseSelect getObject(String courseId) {
        String sql = "select courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum from Course " +
                "where courseId = ?";
        return getInstance(CourseSelect.class,sql,courseId);
    }


    public ArrayList<CourseSelect> getAll() {
        String sql = "select courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum from Course";
        return getInstance2(CourseSelect.class,sql);
    }
}
