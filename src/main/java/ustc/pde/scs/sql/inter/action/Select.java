package ustc.pde.scs.sql.inter.action;

public interface Select extends SimpleRelation{
    boolean insert(String id,String courseId) ;      //学生选课
    boolean delete(String id,String courseId) ;  //退课
    Long getCount();        //获取元素数目

}
