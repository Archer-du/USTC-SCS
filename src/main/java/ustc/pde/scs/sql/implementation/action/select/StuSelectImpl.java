package ustc.pde.scs.sql.implementation.action.select;

import ustc.pde.scs.entity.course.CourseGrade;
import ustc.pde.scs.entity.course.CourseSelect;

import java.sql.SQLException;
import java.util.ArrayList;

public class StuSelectImpl extends SelectImpl{
    @Override
    public ArrayList<CourseSelect> getAll(String id) {  //获取所有已选课程
        String sql = "select course.courseId as courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum " +
                "from Course,selectCourse" +
                "where course.courseId = selectCourse.courseId and selectCourse.id = ?";
        return getInstance2(CourseSelect.class,sql,id);
    }

    public boolean delete(String id) {      //一键退课
        try {
            String sql = "delete from selectCourse where id = ?";
            executeUpdate(sql, id);
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    public Long getCount(String id){    //查询已选课程数
        String sql = "select count(*) from selectCourse where id =?";
        return getValue(sql,id);
    }
}
