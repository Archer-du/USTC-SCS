package ustc.pde.scs.entity.user;

import ustc.pde.scs.entity.course.CourseGrade;
import ustc.pde.scs.entity.course.CourseSelect;
import ustc.pde.scs.entity.major.Major;
import ustc.pde.scs.entity.relation.Score;

import java.sql.Date;
import java.util.ArrayList;

public class Student extends User{
    private String studyDate;   //入学日期
    private String stuType;     //学生类型
    private String curSemester; //当前学期

    public Student() {
    }

    public Student(String studyDate, String stuType, String curSemester) {
        this.studyDate = studyDate;
        this.stuType = stuType;
        this.curSemester = curSemester;
    }
    private Major major;    //专业
    private ArrayList<CourseSelect> courseSelectList;   //当前学期选择课程
    private ArrayList<CourseGrade> courseGradeList; //出成绩的课程
    private ArrayList<Score> scoreList;     //所有课程的分数




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

    public String toString() {
        return "Student{studyDate = " + studyDate + ", stuType = " + stuType + ", curSemester = " + curSemester + "}";
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
