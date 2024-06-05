package ustc.pde.scs.sql.implementation.action.grade;

import ustc.pde.scs.entity.relation.Score;

import java.sql.SQLException;
import java.util.ArrayList;

public class CsGradeImpl extends GradeImpl{
    @Override
    public boolean delete(String courseId) {        //一键删除该课程所有成绩
        try{
            String sql = "delete from selectGrade where courseId = ?";
            executeUpdate(sql,courseId);
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    public ArrayList<Score> getAll(String courseId){        //获取该课程所有学生的分数
        String sql = "select * from selectGrade where courseId = ?";
        return getInstance2(Score.class,sql,courseId);
    }

    @Override
    public boolean isExist(String courseId) {
        if(getAll(courseId).isEmpty()) return false;
        return true;
    }
}
