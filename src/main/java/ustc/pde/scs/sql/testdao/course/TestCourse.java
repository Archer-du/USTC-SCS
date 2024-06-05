package ustc.pde.scs.sql.testdao.course;

import ustc.pde.scs.entity.course.CourseSelect;
import ustc.pde.scs.sql.implementation.course.CourseDAOImpl;
import ustc.pde.scs.sql.implementation.course.CourseSelectImpl;

public class TestCourse {
    public static void main(String[] args) {
        CourseSelectImpl courseSelect = new  CourseSelectImpl();
        CourseSelect select = new CourseSelect("123","数学分析","必修",3,5,2.5,"春季学期","一三五第三四节课",1,120);
        if(courseSelect.insert(select)){
            System.out.println(courseSelect.getObject(select.getCourseId()));
        }
        select.setMaxNum(90);
        if(courseSelect.update(select)){
            System.out.println(courseSelect.getObject(select.getCourseId()));
        }
        if(courseSelect.delete(select.getCourseId())){
            System.out.println("删除成功");
            new CourseDAOImpl().delete(select.getCourseId());
        }
    }
}
