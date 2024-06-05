package ustc.pde.scs.sql.inter.action;

import ustc.pde.scs.entity.relation.Score;
import ustc.pde.scs.sql.base.ObjectDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Grade extends ObjectDAO {
    boolean insert(Score score) throws SQLException;      //给学生添加成绩
    boolean delete(String primaryKey) throws SQLException;  //根据pk删除
    boolean update(Score score) throws SQLException;  //修改分数
    Score getObject(String primaryKey); //根据pk查询
    ArrayList<Score> getAll();  //获取全部元素
    Long getCount();    //获取表项数目
    boolean isExist(String primaryKey);     //根据id判断是否存在
}
