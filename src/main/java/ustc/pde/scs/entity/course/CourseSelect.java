package ustc.pde.scs.entity.course;

public class CourseSelect extends Course{
    private int maxNum;     //选课人数上限

    public CourseSelect() {
    }

    public CourseSelect(int maxNum) {
        this.maxNum = maxNum;
    }
    public CourseSelect(String courseId, String courseName, String courseType, int theoryHour, int labHour, double credit, String openSemester, String classTime, int firstWeek,int maxNum) {
        super(courseId,courseName,courseType,theoryHour,labHour,credit,openSemester,classTime,firstWeek);
        this.setMaxNum(maxNum);
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
        return "CourseSelect{" + super.toString() + ", maxNum = " + maxNum + "}";
    }
}
