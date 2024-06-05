package ustc.pde.scs.sql.inter.user;

import ustc.pde.scs.sql.base.ObjectDAO;
import ustc.pde.scs.entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO extends ObjectDAO {
    boolean insert(User user) throws SQLException;      //向表中插入数据
    boolean delete(String id) throws SQLException;  //根据id删除数据项
    boolean update(User user) throws SQLException;  //更改数据表项
    User getObject(String id); //根据id查询
    <T> ArrayList<T> getAll();  //获取全部元素
    Long getCount();    //获取表项数目
    boolean isExist(String id);     //根据id判断是否存在
}
