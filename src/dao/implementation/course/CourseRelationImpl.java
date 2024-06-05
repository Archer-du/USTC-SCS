package dao.implementation.course;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dao.inter.course.CourseRelation;
import data.user.Assistant;
import data.user.Student;
import data.user.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseRelationImpl extends CourseDAOImpl implements CourseRelation {
    @Override
    public ArrayList<Student> getAllStudent(String courseId) {
        String sql = "select student.ID as ID,studyDate,curSemester,stuType,username,password,idCard,stuName,email" +
                "from users,student,selectCourse where users.id = student.id and student.id = selectCourse.id" +
                "and selectCourse.courseId = ?";

        return getInstance2(Student.class,sql,courseId);
    }

    @Override
    public ArrayList<Assistant> getAllAssistant(String courseId) {
        String sql = "select student.ID as ID,studyDate,curSemester,stuType,username,password,idCard,stuName,email" +
                "from users,student,assistant,assist where users.id = student.id and student.id = assistant.id" +
                "and assistant.id = assist.id and assist.courseId = ?";

        return getInstance2(Assistant.class,sql,courseId);
    }

    @Override
    public ArrayList<Teacher> getAllTeacher(String courseId) {
        String sql = "select Teacher.ID as ID,workDate,username,password,idCard,TeaName,email" +
                "from users,teacher,Teach where users.id = teacher.id and teacher.id = teach.id" +
                "and teach.courseId = ?";
        return getInstance2(Teacher.class,sql,courseId);
    }
/*    @Override
    public boolean delete(String courseId) throws SQLException {     //退课
        if(!isExist(courseId)){
            return false;
        }
        String sql = "delete from selectCourse where courseId = ?";
        executeUpdate(sql,courseId);
        return true;
    }*/
}
