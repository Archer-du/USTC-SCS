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
            String sql = "insert into Course(courseId,courseName,courseType,theoryHour," +
                    "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?)";
            executeUpdate(sql,course.getCourseId(),course.getCourseName(),course.getCourseType(),
                    course.getTheoryHour(),course.getLabHour(),course.getCredit(),
                    course.getBook(),course.getCourseIntro(),
                    course.getOpenSemester(),course.getClassTime(),course.getFirstWeek()
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
        /*//保持外键约束
        sql = "delete from selectCourse where courseId = ?";
        executeUpdate(sql,CourseId);
        sql = "delete from selectGrade where courseId = ?";
        executeUpdate(sql,CourseId);*/
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
                    "openSemester = ?,classTime = ?,firstWeek = ?, where courseID = ?";
            executeUpdate(sql,course.getCourseName(),course.getCourseType(),
                    course.getTheoryHour(),course.getLabHour(),course.getCredit(),
                    course.getBook(),course.getCourseIntro(),
                    course.getOpenSemester(),course.getClassTime(),
                    course.getFirstWeek(),course.getCourseId());
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public Course getObject(String courseId) {
        String sql = "select courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek from Course " +
                "where courseId = ?";
        return getInstance(Course.class,sql,courseId);
    }


    public <T> ArrayList<T>  getAll() {
        return null;
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
