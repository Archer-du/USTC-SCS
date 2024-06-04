package data.course;

import data.relation.Score;

import java.util.ArrayList;

public class CourseGrade extends Course{
    private String gradeMeans;
    private ArrayList<Score> scoreList;
    public CourseGrade() {
    }

    public CourseGrade(String courseId, String courseName, String courseType, int theoryHour, int labHour, double credit, String openSemester, String classTime, int firstWeek,String gradeMeans) {
        super(courseId,courseName,courseType,theoryHour,labHour,credit,openSemester,classTime,firstWeek);
        this.setGradeMeans(gradeMeans);
    }

    public CourseGrade(String gradeMeans) {
        this.gradeMeans = gradeMeans;
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



}
