package ustc.pde.scs.sql.implementation.action.teach;

import ustc.pde.scs.entity.user.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;

public class CsTeachImpl extends TeachImpl{
    @Override
    public ArrayList<Teacher> getAll(String courseId) {  //获取所有授课老师信息
        String sql = "select Teacher.ID as ID,workDate,username,password,idCard,name,email" +
                "from users,teacher,Teach where users.id = teacher.id and teacher.id = teach.id" +
                "and teach.courseId = ?";
        return getInstance2(Teacher.class,sql,courseId);
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
    public Long getCount(String id){    //查询当前授课老师人数
        String sql = "select count(*) from selectCourse where id =?";
        return getValue(sql,id);
    }
}
