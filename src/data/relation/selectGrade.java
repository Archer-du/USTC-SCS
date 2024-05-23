package data.relation;

public class selectGrade {
    private String gradeMeans;      //评分标准
    private String grade;   //得分

    public selectGrade() {
    }

    public selectGrade(String gradeMeans, String grade) {
        this.gradeMeans = gradeMeans;
        this.grade = grade;
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
        return "selectGrade{gradeMeans = " + gradeMeans + ", grade = " + grade + "}";
    }
}
