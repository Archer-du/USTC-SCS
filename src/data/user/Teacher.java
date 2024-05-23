package data.user;

public class Teacher extends User{
    private String workDate;    //入职日期


    public Teacher() {
    }

    public Teacher(String workDate) {
        this.workDate = workDate;
    }

    /**
     * 获取
     * @return workDate
     */
    public String getWorkDate() {
        return workDate;
    }

    /**
     * 设置
     * @param workDate
     */
    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String toString() {
        return "Teacher{workDate = " + workDate + "}";
    }
}
