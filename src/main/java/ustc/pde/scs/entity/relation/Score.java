package ustc.pde.scs.entity.relation;

public class Score {
    String ID;
    String courseId;
    String grade;

    public Score() {
    }

    public Score(String ID, String courseId, String grade) {
        this.ID = ID;
        this.courseId = courseId;
        this.grade = grade;
    }

    /**
     * 获取
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 设置
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
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
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Score{ID = " + ID + ", courseId = " + courseId + ", grade = " + grade + "}";
    }
}
