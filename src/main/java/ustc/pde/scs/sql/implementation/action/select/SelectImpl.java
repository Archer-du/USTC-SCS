package ustc.pde.scs.sql.implementation.action.select;

import ustc.pde.scs.sql.base.BaseDAO;
import ustc.pde.scs.sql.implementation.course.CourseSelectImpl;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;
import ustc.pde.scs.sql.inter.action.Select;

import java.sql.SQLException;

public class SelectImpl extends BaseDAO implements Select {

    @Override
    public boolean insert(String id, String courseId)  {
        CourseSelectImpl courseSelect = new CourseSelectImpl();
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        if(courseSelect.isExist(courseId) && studentDAO.isExist(id)){
            try{
                String sql = "insert into selectCourse values(?,?)";
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
            String sql = "delete from selectCourse where id = ? and courseId = ?";
            executeUpdate(sql,id,courseId);
            return true;
        }catch (SQLException e){
            return false;
        }


    }
    @Override
    public Long getCount(){
        String sql = "select count(*) from selectCourse";
        return getValue(sql);
    }

}
