package ustc.pde.scs.sql.implementation.action.select;

import ustc.pde.scs.entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class CsSelectImpl extends SelectImpl{
    @Override
    public ArrayList<User> getAll(String courseId) {  //获取选课学生信息
        String sql =  "select username,password,idCard,users.id as ID,email,name,date,type,majorId " +
                "from users,selectCourse where users.id = selectCourse.id " +
                "and selectCourse.courseId = ?";
        return getInstance2(User.class,sql,courseId);
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
    public Long getCount(String courseId){    //查询当前选课人数
        String sql = "select count(*) from selectCourse where courseId =?";
        return getValue(sql,courseId);
    }
}
