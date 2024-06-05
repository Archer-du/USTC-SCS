package ustc.pde.scs.sql.testdao.user;

import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.sql.SQLException;

public class TestUser {
    public static void main(String[] args) throws SQLException {
        User user = new User("hjs123","123456","PB21051110","2043539","41148120050126341X");
        UserDAOImpl userDAO = new UserDAOImpl();
        insert(user,userDAO);
        select(user.getID(),userDAO);
        user.setPassword("111111");
        if(!userDAO.insert(user)){
            System.out.println("主键唯一性confirm");
        }
        if(!userDAO.delete("123")){
            System.out.println("不会删除不存在的id");
        }
        update(user,userDAO);
        select(user.getID(),userDAO);
        select(userDAO);
        delete(user.getID(),userDAO);
        select(user.getID(),userDAO);
    }
    public static void insert(User user,UserDAOImpl userDAO) throws SQLException {
        if(userDAO.insert(user)){
            System.out.println("插入成功!");
        }
        else {
            System.out.println("插入失败");
        }
    }
    public static void delete(String id,UserDAOImpl userDAO) throws SQLException {
        if(userDAO.delete(id)){
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }
    public static void update(User user,UserDAOImpl userDAO) throws SQLException {
        if(userDAO.update(user)){
            System.out.println("更新成功");
        }
        else {
            System.out.println("更新失败");
        }
    }
    public static void select(String id,UserDAOImpl userDAO){
        if(userDAO.isExist(id))
        System.out.println(userDAO.getObject(id).toString());
        else System.out.println("查找失败!");
    }
    public static void select(UserDAOImpl userDAO){
        for( User u: userDAO.getAll()){
            System.out.println(u.toString());
        }
    }
}
