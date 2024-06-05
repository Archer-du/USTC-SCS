package ustc.pde.scs.sql.inter.action;

import ustc.pde.scs.entity.relation.Score;
import ustc.pde.scs.sql.base.ObjectDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Select extends SimpleRelation{
    boolean insert(String id,String courseId) ;      //学生选课
    boolean delete(String id,String courseId) ;  //退课
    Long getCount();        //获取元素数目

}
