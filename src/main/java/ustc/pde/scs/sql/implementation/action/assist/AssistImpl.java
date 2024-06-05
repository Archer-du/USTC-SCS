package ustc.pde.scs.sql.implementation.action.assist;

import ustc.pde.scs.sql.base.BaseDAO;
import ustc.pde.scs.sql.implementation.course.CourseDAOImpl;
import ustc.pde.scs.sql.implementation.user.AssistantDAOImpl;
import ustc.pde.scs.sql.implementation.user.TeacherDAOImpl;
import ustc.pde.scs.sql.inter.action.Assist;

import java.sql.SQLException;

public class AssistImpl extends BaseDAO implements Assist {
    @Override
    public boolean insert(String id, String courseId)  {
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        AssistantDAOImpl assistantDAO = new AssistantDAOImpl();
        if(courseDAO.isExist(courseId) && assistantDAO.isExist(id)){
            try{
                String sql = "insert into Assist values(?,?)";
                executeUpdate(sql,id,courseId);
                return true;
            }catch (SQLException e){
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id, String courseId) {
        try{
            String sql = "delete from Assist where id = ? and courseId = ?";
            executeUpdate(sql,id,courseId);
            return true;
        }catch (SQLException e){
            return false;
        }


    }
    @Override
    public Long getCount(){
        String sql = "select count(*) from Assist";
        return getValue(sql);
    }
}
