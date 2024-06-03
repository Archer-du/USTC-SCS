package dao.course;

import data.course.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseDAO {
    //将course对象添加到数据库中
    void insert(Course course) throws SQLException;
    //针对指定id，删除表中记录
    void deleteById(int courseId) throws SQLException;
    //针对course对象修改记录
    void update(Course course) throws SQLException;
    //针对指定课程id查询
    Course getCourseById(String courseId);
    //针对指定教师id查询
    ArrayList<Course> getCoursesTeachById(String ID);
    //查询表所有记录
    ArrayList<Course> getAll();
    //返回数据表的条目数
    Long getCount();
}
