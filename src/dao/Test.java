package dao;

import dao.course.CourseDAOImpl;
import data.course.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws SQLException {
        //Course cs = new Course("数学分析b2","MATH1000.01","2024春季学期","每周一三五的第三四节课",1);
        CourseDAOImpl csdi = new CourseDAOImpl();
        //csdi.insert(cs);
        ArrayList<Course> csList = csdi.getCoursesTeachById("PB21051110");
        for (int i = 0; i < csList.size(); i++) {
            System.out.println(csList.get(i).toString());
        }
    }
}
