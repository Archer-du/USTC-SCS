package ustc.pde.scs.sql.implementation.action.teach;

import ustc.pde.scs.sql.base.BaseDAO;
import ustc.pde.scs.sql.implementation.course.CourseDAOImpl;
import ustc.pde.scs.sql.implementation.user.TeacherDAOImpl;
import ustc.pde.scs.sql.inter.action.Teach;

import java.sql.SQLException;

public class TeachImpl extends BaseDAO implements Teach {

    @Override
    public boolean insert(String id, String courseId)  {
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        TeacherDAOImpl teacherDAO = new TeacherDAOImpl();
        if(courseDAO.isExist(courseId) && teacherDAO.isExist(id)){
            try{
                String sql = "insert into Teach values(?,?)";
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
            String sql = "delete from Teach where id = ? and courseId = ?";
            executeUpdate(sql,id,courseId);
            return true;
        }catch (SQLException e){
            return false;
        }


    }
    @Override
    public Long getCount(){
        String sql = "select count(*) from Teach";
        return getValue(sql);
    }
}
