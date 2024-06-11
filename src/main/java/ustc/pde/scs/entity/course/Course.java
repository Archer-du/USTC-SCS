package ustc.pde.scs.entity.course;

public class Course {
    private String courseId;    //课程号
    private String courseName;  //课程名称
    private String courseType;  //课程类型
    private int theoryHour;     //理论课学时
    private int labHour;    //实验课学时
    private double credit;  //学分
    private String book;    //参考教材
    private String courseIntro; //课程简介
    private String teacherId;       //老师id
    private String gradeMeans;  //评分方式
    private int selectedNum;    //已选人数
    private int maxNum;         //最大人数


    public Course() {
    }

    public Course(String courseId, String courseName, String courseType, int theoryHour, int labHour, double credit, String book, String courseIntro, String teacherId, String gradeMeans, int selectedNum, int maxNum) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.theoryHour = theoryHour;
        this.labHour = labHour;
        this.credit = credit;
        this.book = book;
        this.courseIntro = courseIntro;
        this.teacherId = teacherId;
        this.gradeMeans = gradeMeans;
        this.selectedNum = selectedNum;
        this.maxNum = maxNum;
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
     * @return teacherId
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 设置
     * @param teacherId
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取
     * @return gradeMeans
     */
    public String getGradeMeans() {
        return gradeMeans;
    }

    /**
     * 设置
     * @param gradeMeans
     */
    public void setGradeMeans(String gradeMeans) {
        this.gradeMeans = gradeMeans;
    }

    /**
     * 获取
     * @return selectedNum
     */
    public int getSelectedNum() {
        return selectedNum;
    }

    /**
     * 设置
     * @param selectedNum
     */
    public void setSelectedNum(int selectedNum) {
        this.selectedNum = selectedNum;
    }

    /**
     * 获取
     * @return maxNum
     */
    public int getMaxNum() {
        return maxNum;
    }

    /**
     * 设置
     * @param maxNum
     */
    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String toString() {
        return "Course{courseId = " + courseId + ", courseName = " + courseName + ", courseType = " + courseType + ", theoryHour = " + theoryHour + ", labHour = " + labHour + ", credit = " + credit + ", book = " + book + ", courseIntro = " + courseIntro + ", teacherId = " + teacherId + ", gradeMeans = " + gradeMeans + ", selectedNum = " + selectedNum + ", maxNum = " + maxNum + "}";
    }
}
