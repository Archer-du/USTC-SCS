package ustc.pde.scs.sql.inter.user;

import ustc.pde.scs.sql.base.ObjectDAO;
import ustc.pde.scs.entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO extends ObjectDAO {
    boolean insert(User user) throws SQLException;      //向表中插入数据
    boolean update(User user) ; //更改数据表项
    User getObject(String id); //根据id查询

}
