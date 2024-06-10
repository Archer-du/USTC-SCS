package ustc.pde.scs.sql.inter.action;

import java.util.ArrayList;

public interface SimpleRelation {
    boolean insert(String id1,String id2) ;      //向关系插入数据
    boolean delete(String id1,String id2) ;  //删除关系表的数据项
    Long getCount();        //获取元素数目
    default <T> ArrayList<T> getAll(String id){return null;}    //获取id的所有另一实体信息
}
