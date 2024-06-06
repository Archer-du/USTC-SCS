package ustc.pde.scs.sql.implementation.action.teach;

import ustc.pde.scs.entity.course.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeaTeachImpl extends TeachImpl{
    @Override
    public ArrayList<Course> getAll(String id){
        String sql = "select teach.courseId as courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek from Course,teach " +
                "where teach.courseId = course.courseId and teach.id = ?";
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
