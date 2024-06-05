package ustc.pde.scs.sql.implementation.course;

import ustc.pde.scs.entity.course.CourseSelect;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseSelectImpl extends CourseDAOImpl{
    public boolean insert(CourseSelect courseSelect) {
        super.insert(courseSelect);
        try{
            String sql = "update Course set maxNum = ? where courseId = ?";
            executeUpdate(sql,courseSelect.getMaxNum(),courseSelect.getCourseId());
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    public boolean update(CourseSelect courseSelect)  {
        super.update(courseSelect);
        try {
            String sql = "update Course set maxNum = ? where courseId = ?";
            executeUpdate(sql,courseSelect.getMaxNum(),courseSelect.getCourseId());
            return true;
        }catch (SQLException e){
            return false;
        }

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
