package data.user;

import data.course.CourseGrade;
import data.course.CourseSelect;
import data.major.Major;

import java.util.ArrayList;

public class Student extends User{
    private String studyDate;   //入学日期
    private String stuType;     //学生类型
    private String curSemester; //当前学期
    private String stuName;     //学生姓名
    private Major major;    //专业
    private ArrayList<CourseSelect> courseSelectList;   //当前学期选择课程
    private ArrayList<CourseGrade> courseGradeList; //出成绩的课程
    public Student() {
    }

    public Student(String studyDate, String stuType, String curSemester, String stuName) {
        this.studyDate = studyDate;
        this.stuType = stuType;
        this.curSemester = curSemester;
        this.stuName = stuName;
    }

    /**
     * 获取
     * @return studyDate
     */
    public String getStudyDate() {
        return studyDate;
    }

    /**
     * 设置
     * @param studyDate
     */
    public void setStudyDate(String studyDate) {
        this.studyDate = studyDate;
    }

    /**
     * 获取
     * @return stuType
     */
    public String getStuType() {
        return stuType;
    }

    /**
     * 设置
     * @param stuType
     */
    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    /**
     * 获取
     * @return curSemester
     */
    public String getCurSemester() {
        return curSemester;
    }

    /**
     * 设置
     * @param curSemester
     */
    public void setCurSemester(String curSemester) {
        this.curSemester = curSemester;
    }

    /**
     * 获取
     * @return stuName
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * 设置
     * @param stuName
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String toString() {
        return "Student{studyDate = " + studyDate + ", stuType = " + stuType + ", curSemester = " + curSemester + ", stuName = " + stuName + "}";
    }


}
