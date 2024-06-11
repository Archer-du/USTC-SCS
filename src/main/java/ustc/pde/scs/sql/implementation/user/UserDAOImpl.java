package ustc.pde.scs.sql.implementation.user;

import ustc.pde.scs.sql.base.BaseDAO;
import ustc.pde.scs.sql.inter.user.UserDAO;
import ustc.pde.scs.entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public boolean insert(User user) {
        try{
            String sql = "insert into users values(?,?,?,?,?,?,?,?,?)";
            executeUpdate(sql,user.getUsername(),user.getPassword(),user.getIdCard(),user.getID(),user.getEmail(),user.getName(), null, user.getType(), user.getMajorId());
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean delete(String id) {
        try{
            String sql = "delete from users where id = ?";
            executeUpdate(sql,id);
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean update(User user) {
        try{
            String sql = "update users set username = ?,password =?,idCard = ?,email = ?, name = ? ,date = ?, type = ?,majorId = ? where id =?";
            executeUpdate(sql,user.getUsername(),user.getPassword(),user.getIdCard(),user.getEmail(),user.getName(),user.getDate(),user.getType(),user.getMajorId(),user.getID());
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public User getObject(String id) {
        String sql = "select * from users where id = ?";
        return getInstance(User.class,sql,id);
    }
    public ArrayList<User> getUsers(String name){       //查询所有名字为name的用户
        String sql = "select * from users where name = ?";
        return getInstance2(User.class,sql,name);
    }
    public User getTeacher(String courseId){        //获取某课程的老师
        String sql = "select username,password,idCard,ID,email,name,date,type,majorId from users,course where course.teacherId = users.id and course.courseId = ?";
        return getInstance(User.class,sql,courseId);
    }

    @Override
    public ArrayList<User> getAll() {
        String sql = "select * from users";
        return getInstance2(User.class,sql);
    }

    @Override
    public Long getCount() {
        String sql = "select (*) from users";
        return getValue(sql);
    }

    @Override
    public boolean isExist(String id) {
        if(getObject(id) == null) return false;
        return true;
    }
}
