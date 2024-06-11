package ustc.pde.scs.sql.base;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ObjectDAO {
    boolean delete(String primaryKey);  //根据id删除数据项
    <T> T getObject(String primaryKey); //根据id获得实体
    <T> ArrayList<T> getAll();  //获取全部元素
    Long getCount();    //获取表项数目
    boolean isExist(String pk);
}
