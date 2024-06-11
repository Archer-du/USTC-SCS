package ustc.pde.scs.entity.major;

import ustc.pde.scs.entity.user.User;

import java.util.ArrayList;

public class Major {
    private String majorId;     //专业号
    private String majorName;   //专业名称
    private String majorIntro;  //专业介绍
    private ArrayList<User> stuList; //当前专业学生
    public Major() {
    }

    public Major(String majorId, String majorName, String majorIntro) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.majorIntro = majorIntro;
    }

    /**
     * 获取
     * @return majorId
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * 设置
     * @param majorId
     */
    public void setMajorID(String majorId) {
        this.majorId = majorId;
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
        return "Major{majorId = " + majorId + ", majorName = " + majorName + ", majorIntro = " + majorIntro + "}";
    }
}
