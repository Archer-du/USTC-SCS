package dao.implementation.user;

import dao.base.BaseDAO;
import dao.inter.user.UserDAO;
import data.course.CourseSelect;
import data.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public boolean insert(User user) throws SQLException {
        if(isExist(user.getID())){
            return false;   //已存在
        }
        String sql = "insert into users values(?,?,?,?,?)";
        executeUpdate(sql,user.getUsername(),user.getPassword(),user.getIdCard(),user.getID(),user.getEmail());
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        if(!isExist(id)){
            return false;   //没有这个id
        }
        String sql = "delete from users where id = ?";
        executeUpdate(sql,id);
        return true;
    }

    @Override
    public boolean update(User user) throws SQLException {
        if(!isExist(user.getID())){
            return  false;
        }
        String sql = "update users set username = ?,password =?,idCard = ?,email = ? where id =?";
        executeUpdate(sql,user.getUsername(),user.getPassword(),user.getIdCard(),user.getEmail(),user.getID());
        return true;
    }

    @Override
    public User getObject(String id) {
        String sql = "select * from users where id = ?";
        return getInstance(User.class,sql,id);
    }

    @Override
    public ArrayList<User> getAll() {
        String sql = "select * from users";
        return getInstance2(User.class,sql);
    }

    @Override
    public Long getCount() {
        String sql = "select * from users";
        return getValue(sql);
    }

    @Override
    public boolean isExist(String id) {
        if(getObject(id) == null) return false;
        return true;
    }
}
