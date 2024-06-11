package ustc.pde.scs.sql.implementation.course;

import ustc.pde.scs.sql.base.BaseDAO;
import ustc.pde.scs.sql.inter.course.CourseDAO;
import ustc.pde.scs.entity.course.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImpl extends BaseDAO implements CourseDAO {
    @Override
    public boolean insert(Course course) {
        try {
            String sql = "insert into course(courseId,courseName,courseType,theoryHour,labHour," +
                    "credit,book,courseIntro,maxNum,gradeMeans,selectedNum,teacherId) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            executeUpdate(sql,course.getCourseId(),course.getCourseName(),course.getCourseType(),
                    course.getTheoryHour(),course.getLabHour(),course.getCredit(),
                    course.getBook(),course.getCourseIntro(),
                    course.getMaxNum(),course.getGradeMeans(),course.getSelectedNum(),course.getMaxNum()
            );
            return true;    //正确插入
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean delete(String CourseId) {
        try{
            String sql = "delete from Course where courseId = ?";
            executeUpdate(sql,CourseId);
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean update(Course course) {
        try {
            String sql = "update Course set courseName = ?,courseType = ?,theoryHour = ?, " +
                    "labHour = ?, credit = ?, book = ?, courseIntro = ?, " +
                    "maxNum = ?,gradeMeans = ?,selectedNum = ?,teacherId = ?  where courseId = ?";
            executeUpdate(sql,course.getCourseName(),course.getCourseType(),
                    course.getTheoryHour(),course.getLabHour(),course.getCredit(),
                    course.getBook(),course.getCourseIntro(),
                    course.getMaxNum(),course.getGradeMeans(),
                    course.getSelectedNum(),course.getTeacherId(),course.getCourseId());
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public Course getObject(String courseId) {
        String sql = "select * from course where courseId = ?";
        return getInstance(Course.class,sql,courseId);
    }
    public ArrayList<Course> getCoursesByName(String courseName){//根据课程名查询
        String sql = "select * from course where courseName like ?";
        return getInstance2(Course.class,sql,courseName + "%");
    }

    public ArrayList<Course> getCourses(String teacherId){      //获取某老师所教的全部课程
        String sql = "select * from course where teacherId = ?";
        return getInstance2(Course.class,sql,teacherId);
    }

    public ArrayList<Course> getAll() {
        String sql = "select * from course";
        return getInstance2(Course.class, sql);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from Course";
        return getValue(sql);
    }

    @Override
    public boolean isExist(String courseId) {
        if(getObject(courseId) == null){        //查询不到该对象
            return false;
        }
        return true;
    }


}
