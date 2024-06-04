package data.relation;

public class Score {
    String id;
    String courseId;
    String gradeMeans;
    String grade;

    public Score() {
    }

    public Score(String id, String courseId, String gradeMeans, String grade) {
        this.id = id;
        this.courseId = courseId;
        this.gradeMeans = gradeMeans;
        this.grade = grade;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
        return "Score{id = " + id + ", courseId = " + courseId + ", gradeMeans = " + gradeMeans + ", grade = " + grade + "}";
    }
}
