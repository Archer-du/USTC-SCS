package dao.implementation.course;

import dao.base.BaseDAO;
import dao.inter.course.CourseDAO;
import data.course.Course;
import data.course.CourseSelect;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImpl extends BaseDAO implements CourseDAO {
    @Override
    public boolean insert(Course course) throws SQLException {
        if(isExist(course.getCourseId())){
            return false;       //插入id已存在
        }
        String sql = "insert into Course(courseId,courseName,courseType,theoryHour," +
                "labHour,credit,book,courseIntro,openSemester,classTime,firstWeek) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        executeUpdate(sql,course.getCourseId(),course.getCourseName(),course.getCourseType(),
                course.getTheoryHour(),course.getLabHour(),course.getCredit(),
                course.getBook(),course.getCourseIntro(),
                course.getOpenSemester(),course.getClassTime(),course.getFirstWeek()
                );
        return true;    //正确插入
    }

    @Override
    public boolean delete(String CourseId) throws SQLException {
        if(!isExist(CourseId)){
            return false;   //id不存在无法删除
        }
        String sql = "delete from Course where courseId = ?";
        executeUpdate(sql,CourseId);
        //保持外键约束
        sql = "delete from selectCourse where courseId = ?";
        executeUpdate(sql,CourseId);
        sql = "delete from selectGrade where courseId = ?";
        executeUpdate(sql,CourseId);
        return true;
    }

    @Override
    public boolean update(Course course) throws SQLException {
        if(!isExist(course.getCourseId())){
            return false;   //要更改的id不存在
        }
        String sql = "update Course set courseName = ?,courseType = ?,theoryHour = ?, " +
                "labHour = ?, credit = ?, book = ?, courseIntro = ?, " +
                "openSemester = ?,classTime = ?,firstWeek = ?, where courseID = ?";
        executeUpdate(sql,course.getCourseName(),course.getCourseType(),
                course.getTheoryHour(),course.getLabHour(),course.getCredit(),
                course.getBook(),course.getCourseIntro(),
                course.getOpenSemester(),course.getClassTime(),course.getFirstWeek());
        return true;
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
