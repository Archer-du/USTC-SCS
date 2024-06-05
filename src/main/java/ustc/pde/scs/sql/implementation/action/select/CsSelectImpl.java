package ustc.pde.scs.sql.implementation.action.select;

import ustc.pde.scs.entity.user.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class CsSelectImpl extends SelectImpl{
    @Override
    public ArrayList<Student> getAll(String courseId) {  //获取选课学生信息
        String sql = "select student.ID as ID,studyDate,curSemester,stuType,username,password,idCard,name,email " +
                "from users,student,selectCourse where users.id = student.id and student.id = selectCourse.id " +
                "and selectCourse.courseId = ?";
        return getInstance2(Student.class,sql,courseId);
    }
    public boolean delete(String courseId) {      //一键清空
        try {
            String sql = "delete from selectCourse where courseId = ?";
            executeUpdate(sql, courseId);
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    public Long getCount(String id){    //查询当前选课人数
        String sql = "select count(*) from selectCourse where id =?";
        return getValue(sql,id);
    }
}
