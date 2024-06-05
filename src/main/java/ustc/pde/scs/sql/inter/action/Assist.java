package ustc.pde.scs.sql.inter.action;

public interface Assist extends SimpleRelation{
    boolean insert(String id,String courseId) ;      //助教授课
    boolean delete(String id,String courseId) ;  //助教卸任
    Long getCount();        //获取元素数目
}
