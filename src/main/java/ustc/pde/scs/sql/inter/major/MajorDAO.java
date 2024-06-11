package ustc.pde.scs.sql.inter.major;

import ustc.pde.scs.entity.major.Major;
import ustc.pde.scs.sql.base.ObjectDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MajorDAO extends ObjectDAO {
    boolean insert(Major major) ;    //向表中插入数据
    boolean delete(String majorId) ; //根据id删除数据项
    boolean update(Major major);  //更改数据表项
    Major getObject(String majorId); //根据id查询
    ArrayList<Major> getAll();  //获取全部元素
    Long getCount();    //获取表项数目
    boolean isExist(String majorId);     //根据id判断是否存在
}
