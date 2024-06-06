package ustc.pde.scs.sql.implementation.action.assist;

import ustc.pde.scs.entity.course.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class AssAssistImpl extends AssistImpl{
    @Override
    public ArrayList<Course> getAll(String id) {      //获取助教所有的授课信息
        String sql = "select assist.courseId as courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek from Course,assist " +
                "where assist.courseId = course.courseId and assist.id = ?";
        return getInstance2(Course.class,sql,id);
    }
    public boolean delete(String id) {      //一键退课
        try {
            String sql = "delete from Teach where id = ?";
            executeUpdate(sql, id);
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    public Long getCount(String id){    //查询已教课程数
        String sql = "select count(*) from Teach where id =?";
        return getValue(sql,id);
    }
}
