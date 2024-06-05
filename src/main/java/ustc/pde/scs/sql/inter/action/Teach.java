package ustc.pde.scs.sql.inter.action;

public interface Teach extends SimpleRelation{
    boolean insert(String id,String courseId) ;      //教师授课
    boolean delete(String id,String courseId) ;  //教师退课
    Long getCount();        //获取元素数目
}
