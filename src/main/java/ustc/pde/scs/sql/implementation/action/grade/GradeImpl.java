package ustc.pde.scs.sql.implementation.action.grade;

import ustc.pde.scs.entity.relation.Score;
import ustc.pde.scs.sql.base.BaseDAO;
import ustc.pde.scs.sql.implementation.course.CourseSelectImpl;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;
import ustc.pde.scs.sql.inter.action.Grade;

//import java.awt.image.BaseMultiResolutionImage;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeImpl extends BaseDAO implements Grade {
    @Override
    public boolean insert(Score score) {
        CourseSelectImpl courseSelect = new CourseSelectImpl();
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        if(courseSelect.isExist(score.getCourseId()) && studentDAO.isExist(score.getID())){
            try{
                String sql = "insert into selectGrade values(?,?,?)";
                executeUpdate(sql,score.getID(),score.getCourseId(),score.getGrade());
                return true;
            }catch (SQLException e){
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String primaryKey) {

        String [] pk = primaryKey.split(" ");
        String id = pk[0];
        String courseId = pk[1];
        try{
            String sql = "delete from selectGrade where id = ? and courseId = ?";
            executeUpdate(sql,id,courseId);
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean update(Score score){
        try{
            String sql = "update selectGrade set grade = ? where id = ? and courseId = ?";
            executeUpdate(sql,score.getGrade(),score.getID(),score.getCourseId());
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public Score getObject(String primaryKey) {
        String sql = "select * from selectGrade where id = ? and courseId = ?";
        String [] pk = primaryKey.split(" ");
        String id = pk[0];
        String courseId = pk[1];
        return getInstance(Score.class,sql,id,courseId);
    }

    @Override
    public ArrayList<Score> getAll() {
        String sql = "select * from selectGrade";
        return getInstance2(Score.class,sql);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from selectGrade";
        return getValue(sql);
    }

    @Override
    public boolean isExist(String primaryKey) {
        if(getObject(primaryKey)==null) return false;
        return true;
    }
}
