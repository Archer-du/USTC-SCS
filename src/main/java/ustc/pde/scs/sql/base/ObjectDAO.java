package ustc.pde.scs.sql.base;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ObjectDAO {
    //boolean insert(Object object);      //向表中插入数据
    boolean delete(String primaryKey) throws SQLException;  //根据id删除数据项
    //boolean update(Object object);  //更改数据表项
    <T> T getObject(String primaryKey); //根据查询id
    <T> ArrayList<T> getAll();  //获取全部元素
    Long getCount();    //获取表项数目
    boolean isExist(String primaryKey);     //根据id判断是否存在
}
