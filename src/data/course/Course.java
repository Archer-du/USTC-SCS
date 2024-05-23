package data.course;

import data.user.Assistant;
import data.user.Student;
import data.user.Teacher;

import java.util.ArrayList;

public class Course {
    private String courseName;      //课程名称
    private String courseId;    //课程号

    private String openSemester;    //开课学期
    private String classTime;     //上课时间
    private int firstWeek;       //上课首周


    public Course() {
    }

    public Course(String courseName, String courseId, String openSemester, String classTime, int firstWeek) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.openSemester = openSemester;
        this.classTime = classTime;
        this.firstWeek = firstWeek;
    }

    /**
     * 获取
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 获取
     * @return courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 设置
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取
     * @return openSemester
     */
    public String getOpenSemester() {
        return openSemester;
    }

    /**
     * 设置
     * @param openSemester
     */
    public void setOpenSemester(String openSemester) {
        this.openSemester = openSemester;
    }

    /**
     * 获取
     * @return classTime
     */
    public String getClassTime() {
        return classTime;
    }

    /**
     * 设置
     * @param classTime
     */
    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    /**
     * 获取
     * @return firstWeek
     */
    public int getFirstWeek() {
        return firstWeek;
    }

    /**
     * 设置
     * @param firstWeek
     */
    public void setFirstWeek(int firstWeek) {
        this.firstWeek = firstWeek;
    }

    public String toString() {
        return "Course{courseName = " + courseName + ", courseId = " + courseId + ", openSemester = " + openSemester + ", classTime = " + classTime + ", firstWeek = " + firstWeek + "}";
    }
}
