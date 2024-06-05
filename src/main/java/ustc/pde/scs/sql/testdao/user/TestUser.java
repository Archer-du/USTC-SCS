package ustc.pde.scs.sql.testdao.user;

import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.sql.SQLException;

public class TestUser {
    public static void main(String[] args) throws SQLException {
        User user = new User("hjs123","123456","PB21051110","2043539","41148120050126341X","拉我吧");
        UserDAOImpl userDAO = new UserDAOImpl();
        if(userDAO.insert(user)){
            System.out.println(userDAO.getObject(user.getID()));
        }
        else{
            System.out.println("插入失败");
        }
        user.setPassword("111111");
        if(userDAO.update(user)){
            System.out.println(userDAO.getObject(user.getID()));
        }
        else{
            System.out.println("修改失败!");
        }
        if(!userDAO.insert(user)){
            System.out.println("主键唯一性confirm");
        }
        if(!userDAO.delete("123")){
            System.out.println("不会删除不存在的id");
        }
        if(userDAO.delete(user.getID())){
            System.out.println("删除成功!");
        }

    }

}
