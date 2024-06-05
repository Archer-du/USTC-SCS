package dao.inter.course;

import dao.base.ObjectDAO;
import data.course.Course;
import data.course.CourseSelect;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseDAO extends ObjectDAO {
    //将course对象添加到数据库中
    boolean insert(Course course) throws SQLException;
    //针对指定id，删除表中记录
    boolean delete(String courseId) throws SQLException;
    //针对course对象修改记录
    boolean update(Course course) throws SQLException;
    //针对指定课程id查询
    Course getObject(String courseId);
    //查询表所有记录
    //ArrayList<Object> getAll();
    //返回数据表的条目数
    Long getCount();

}
