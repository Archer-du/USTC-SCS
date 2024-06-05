package ustc.pde.scs.sql.implementation.user;

import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.entity.user.Teacher;
import ustc.pde.scs.entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAOImpl extends UserDAOImpl{
    public boolean insert(Teacher teacher) {
        super.insert(teacher);
        try{
            String sql = "insert into teacher(id,teaName,workDate) values(?,?,?)";
            executeUpdate(sql,teacher.getID(),teacher.getTeaName(),teacher.getWorkDate());
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean delete(String id) throws SQLException {
        try{
            String sql = "delete from teacher where id = ?";
            executeUpdate(sql,id);
            return true;
        }catch (SQLException e){
            return false;
        }

    }


    public boolean update(Teacher teacher) throws SQLException {
        try{
            String sql = "update teacher set teaName =?,workDate = ? where id = ?";
            executeUpdate(sql,teacher.getTeaName(),teacher.getWorkDate(),teacher.getID());
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public Teacher getObject(String id) {
        String sql = "select teacher.id as ID,teaName,workDate,username,password,idCard,email from " +
                "users,teacher where teacher.id = users.id and teacher.id = ID";
        return getInstance(Teacher.class,sql,id);
    }

    public ArrayList<Teacher> getAllTeacher() {
        String sql = "select username,password,idCard,teacher.id as ID,email, " +
                "teaName,workDate from users,teacher" +
                "where teacher.id = users.id";
        return getInstance2(Teacher.class,sql);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from teacher";
        return getValue(sql);
    }

    @Override
    public boolean isExist(String id) {
        if(getObject(id) == null) return false;
        return true;
    }
}
