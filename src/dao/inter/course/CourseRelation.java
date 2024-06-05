package dao.inter.course;

import data.user.Assistant;
import data.user.Student;
import data.user.Teacher;

import java.util.ArrayList;

public interface CourseRelation {
    ArrayList<Student> getAllStudent(String courseId);  //获取某课程的所有学生
    ArrayList<Assistant> getAllAssistant(String courseId);  //获取某课程的所有助教
    ArrayList<Teacher> getAllTeacher(String courseId);  //获取某课程的所有老师
}
