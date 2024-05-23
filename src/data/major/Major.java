package data.major;

public class Major {
    private String majorID;
    private String majorName;
    private String majorIntro;

    public Major() {
    }

    public Major(String majorID, String majorName, String majorIntro) {
        this.majorID = majorID;
        this.majorName = majorName;
        this.majorIntro = majorIntro;
    }

    /**
     * 获取
     * @return majorID
     */
    public String getMajorID() {
        return majorID;
    }

    /**
     * 设置
     * @param majorID
     */
    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    /**
     * 获取
     * @return majorName
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 设置
     * @param majorName
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    /**
     * 获取
     * @return majorIntro
     */
    public String getMajorIntro() {
        return majorIntro;
    }

    /**
     * 设置
     * @param majorIntro
     */
    public void setMajorIntro(String majorIntro) {
        this.majorIntro = majorIntro;
    }

    public String toString() {
        return "Major{majorID = " + majorID + ", majorName = " + majorName + ", majorIntro = " + majorIntro + "}";
    }
}
