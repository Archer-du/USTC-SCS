package data.course;

public class Class {
    private String courseName;   //课程名称
    private String courseType;   //课程类型
    private int theoryHour;     //理论课学时
    private int labHour;    //实验课学时
    private double credit;  //学分
    private String book;    //教材
    private String courseIntro;  //课程简介

    public Class() {
    }

    public Class(String courseName, String courseType, int theoryHour, int labHour, double credit, String book, String courseIntro) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.theoryHour = theoryHour;
        this.labHour = labHour;
        this.credit = credit;
        this.book = book;
        this.courseIntro = courseIntro;
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

    public String toString() {
        return "Class{courseName = " + courseName + ", courseType = " + courseType + ", theoryHour = " + theoryHour + ", labHour = " + labHour + ", credit = " + credit + ", book = " + book + ", courseIntro = " + courseIntro + "}";
    }
}
