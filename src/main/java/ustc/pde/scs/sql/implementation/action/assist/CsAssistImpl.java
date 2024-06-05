package ustc.pde.scs.sql.implementation.action.assist;

import ustc.pde.scs.entity.user.Assistant;

import java.util.ArrayList;

public class CsAssistImpl extends AssistImpl{
    @Override
    public ArrayList<Assistant> getAll(String courseId) {
        String sql = "select student.ID as ID,studyDate,curSemester,stuType,username,password,idCard,name,email " +
                "from users,student,assistant,assist where users.id = student.id and student.id = assistant.id " +
                "and assistant.id = assist.id and assist.courseId = ?";

        return getInstance2(Assistant.class,sql,courseId);
    }
}
