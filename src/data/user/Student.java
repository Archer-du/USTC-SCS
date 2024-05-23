package data.user;

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
}
