package ustc.pde.scs.entity.user;

import ustc.pde.scs.entity.course.Course;

import java.util.ArrayList;

public class Teacher extends User{
    private String workDate;    //入职日期

    public Teacher() {
    }

    public Teacher(String workDate) {
        this.workDate = workDate;
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

    public String toString() {
        return "Teacher{workDate = " + workDate + "}";
    }
    //private ArrayList<Course> TeachList;    //所教课程



}
