package data.course;

public class Class {
    private String className;   //课程名称
    private String classType;   //课程类型
    private int theoryHour;     //理论课学时
    private int labHour;    //实验课学时
    private double credit;  //学分
    private String book;    //教材
    private String classIntro;  //课程简介

    public Class() {
    }

    public Class(String className, String classType, int theoryHour, int labHour, double credit, String book, String classIntro) {
        this.className = className;
        this.classType = classType;
        this.theoryHour = theoryHour;
        this.labHour = labHour;
        this.credit = credit;
        this.book = book;
        this.classIntro = classIntro;
    }

    /**
     * 获取
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取
     * @return classType
     */
    public String getClassType() {
        return classType;
    }

    /**
     * 设置
     * @param classType
     */
    public void setClassType(String classType) {
        this.classType = classType;
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
     * @return classIntro
     */
    public String getClassIntro() {
        return classIntro;
    }

    /**
     * 设置
     * @param classIntro
     */
    public void setClassIntro(String classIntro) {
        this.classIntro = classIntro;
    }

    public String toString() {
        return "Class{className = " + className + ", classType = " + classType + ", theoryHour = " + theoryHour + ", labHour = " + labHour + ", credit = " + credit + ", book = " + book + ", classIntro = " + classIntro + "}";
    }
}
