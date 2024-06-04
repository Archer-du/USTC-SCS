package data.user;

import data.course.Course;

import java.util.ArrayList;

public class Teacher extends User{
    private String workDate;    //入职日期
    private String teaName;     //老师姓名
    private ArrayList<Course> TeachList;    //所教课程
    public Teacher() {
    }

    public Teacher(String workDate, String teaName) {
        this.workDate = workDate;
        this.teaName = teaName;
    }

    /**
     * 获取
     * @return workDate
     */
    public String getWorkDate() {
        return workDate;
    }

    /**
     * 设置
     * @param workDate
     */
    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    /**
     * 获取
     * @return teaName
     */
    public String getTeaName() {
        return teaName;
    }

    /**
     * 设置
     * @param teaName
     */
    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String toString() {
        return "Teacher{workDate = " + workDate + ", teaName = " + teaName + "}";
    }



}
