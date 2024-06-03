package dao.course;

import dao.BaseDAO;
import data.course.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImpl extends BaseDAO implements CourseDAO {
    @Override
    public void insert(Course course) throws SQLException {
        String sql = "insert into Course(courseID,openSemester,classTime,firstWeek)values(?,?,?,?)";
        executeUpdate(sql,course.getCourseId(),course.getOpenSemester(),course.getClassTime(),course.getFirstWeek());
    }

    @Override
    public void deleteById(int CourseID) throws SQLException {
        String sql = "delete from Course where courseID = ?";
        executeUpdate(sql,CourseID);
    }

    @Override
    public void update(Course course) throws SQLException {
        String sql = "update Course set openSemester = ?,classTime = ?,firstWeek = ? where courseID = ?";
        executeUpdate(sql,course.getOpenSemester(),course.getClassTime(),course.getFirstWeek(),course.getCourseId());
    }

    @Override
    public Course getCourseById(String courseId) {
        String sql = "select * from Course where courseID = ?";
        return getInstance(Course.class,sql,courseId);
    }

    @Override
    public ArrayList<Course> getCoursesTeachById(String ID) {
        String sql = "select Course.courseId as courseId,openSemester,classTime,firstWeek from Teach,Course " +
                "where Teach.ID = ? and Teach.courseId = Course.courseId";
        return getInstance2(Course.class,sql,ID);
    }

    @Override
    public ArrayList<Course> getAll() {
        String sql = "select * from Course";
        return getInstance2(Course.class,sql);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from Course";
        return getValue(sql);
    }
}
