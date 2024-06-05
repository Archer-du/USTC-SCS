package ustc.pde.scs.entity.course;

import ustc.pde.scs.entity.user.Assistant;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.entity.user.Teacher;

import java.util.ArrayList;

public class Course {
    private String courseId;    //课程号
    private String courseName;  //课程名称
    private String courseType;  //课程类型
    private int theoryHour;     //理论课学时
    private int labHour;    //实验课学时
    private double credit;  //学分
    private String book;    //参考教材
    private String courseIntro; //课程简介
    private String openSemester;    //开课学期
    private String classTime;     //上课时间
    private int firstWeek;       //上课首周

    private ArrayList<Student> studentList;  //选择该课程的学生
    private ArrayList<Teacher> teacherList;  //授课老师
    private ArrayList<Assistant> assistantList;  //助教天团
    public Course() {
    }
    public Course(String courseId, String courseName, String courseType, int theoryHour, int labHour, double credit, String openSemester, String classTime, int firstWeek) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.theoryHour = theoryHour;
        this.labHour = labHour;
        this.credit = credit;
        this.openSemester = openSemester;
        this.classTime = classTime;
        this.firstWeek = firstWeek;
    }
    public Course(String courseId, String courseName, String courseType, int theoryHour, int labHour, double credit, String book, String courseIntro, String openSemester, String classTime, int firstWeek) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.theoryHour = theoryHour;
        this.labHour = labHour;
        this.credit = credit;
        this.book = book;
        this.courseIntro = courseIntro;
        this.openSemester = openSemester;
        this.classTime = classTime;
        this.firstWeek = firstWeek;
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
     * @return courseType
     */
    public String getCourseType() {
        return courseType;
    }

    /**
     * 设置
     * @param courseType
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    /**
     * 获取
     * @return theoryHour
     */
    public int getTheoryHour() {
        return theoryHour;
    }

    /**
     * 设置
     * @param theoryHour
     */
    public void setTheoryHour(int theoryHour) {
        this.theoryHour = theoryHour;
    }

    /**
     * 获取
     * @return labHour
     */
    public int getLabHour() {
        return labHour;
    }

    /**
     * 设置
     * @param labHour
     */
    public void setLabHour(int labHour) {
        this.labHour = labHour;
    }

    /**
     * 获取
     * @return credit
     */
    public double getCredit() {
        return credit;
    }

    /**
     * 设置
     * @param credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     * 获取
     * @return book
     */
    public String getBook() {
        return book;
    }

    /**
     * 设置
     * @param book
     */
    public void setBook(String book) {
        this.book = book;
    }

    /**
     * 获取
     * @return courseIntro
     */
    public String getCourseIntro() {
        return courseIntro;
    }

    /**
     * 设置
     * @param courseIntro
     */
    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
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
        return "Course{courseId = " + courseId + ", courseName = " + courseName + ", courseType = " + courseType + ", theoryHour = " + theoryHour + ", labHour = " + labHour + ", credit = " + credit + ", book = " + book + ", courseIntro = " + courseIntro + ", openSemester = " + openSemester + ", classTime = " + classTime + ", firstWeek = " + firstWeek + "}";
    }


}
