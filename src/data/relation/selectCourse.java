package data.relation;

public class selectCourse {
    private int selectLimits;       //选课人数上限
    private int selectNum;    //已选人数

    public selectCourse() {
    }

    public selectCourse(int selectLimits, int selectNum) {
        this.selectLimits = selectLimits;
        this.selectNum = selectNum;
    }

    /**
     * 获取
     * @return selectLimits
     */
    public int getSelectLimits() {
        return selectLimits;
    }

    /**
     * 设置
     * @param selectLimits
     */
    public void setSelectLimits(int selectLimits) {
        this.selectLimits = selectLimits;
    }

    /**
     * 获取
     * @return selectNum
     */
    public int getSelectNum() {
        return selectNum;
    }

    /**
     * 设置
     * @param selectNum
     */
    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }

    public String toString() {
        return "selectCourse{selectLimits = " + selectLimits + ", selectNum = " + selectNum + "}";
    }
}
