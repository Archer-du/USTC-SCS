package ustc.pde.scs.sql.implementation.action.grade;

import ustc.pde.scs.entity.course.CourseGrade;
import ustc.pde.scs.entity.relation.Score;

import java.sql.SQLException;
import java.util.ArrayList;

public class StuGradeImpl extends GradeImpl{
    @Override
    public boolean delete(String id) throws SQLException {  //一键删除该学生所有成绩信息
        if(!isExist(id)) return false;
        String sql = "delete from selectGrade where id = ?";
        executeUpdate(sql,id);
        return true;
    }
    public ArrayList<Score> getAll(String id){      //获取所有课程成绩
        String sql = "select * from selectGrade where id = ?";
        return getInstance2(Score.class,sql,id);
    }
    public ArrayList<CourseGrade> getAllGradeCourse(String id) {        //获取所有出成绩的课程信息
        String sql = "select course.courseId as courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,gradeMeans " +
                "from Course,selectGrade" +
                "where course.courseId = selectGrade.courseId and selectGrade.id = ?";
        return getInstance2(CourseGrade.class,sql,id);
    }
    @Override
    public boolean isExist(String id) {
        if(getAll(id).isEmpty()) return false;
        return true;
    }
}
