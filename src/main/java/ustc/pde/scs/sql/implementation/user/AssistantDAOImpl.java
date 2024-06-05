package ustc.pde.scs.sql.implementation.user;

import ustc.pde.scs.entity.user.Assistant;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.entity.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class AssistantDAOImpl extends StudentDAOImpl{
    public boolean insert(Assistant assistant) throws SQLException {
        if(isExist(assistant.getID())){
            return false;   //已存在
        }
        if(!super.isExist(assistant.getID())){
            super.insert(assistant);      //父表中不存在，插入
        }

        String sql = "insert into Assistant values(?)";
        executeUpdate(sql,assistant.getID());
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        if(!isExist(id)){
            return false;   //没有这个id
        }
        String sql = "delete from Assistant where ID = ?";
        executeUpdate(sql,id);
        return true;
    }

    @Override
    public Assistant getObject(String id) {
        String sql = "select student.ID as ID,studyDate,curSemester,stuType,username,password,idCard,stuName,email" +
                "from users,student,assistant where users.id = student.id and student.id = assistant.id" +
                "and assistant.id = ? ";
        return getInstance(Assistant.class,sql);
    }

    public ArrayList<Assistant> getAllAssistant() {
        String sql = "select username,password,idCard,student.id as ID,email, " +
                "stuName,studyDate,curSemester,stuType from users,student,assistant" +
                "where student.id = users.id and assistant.id = student.id";
        return getInstance2(Assistant.class,sql);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from assistant";
        return getValue(sql);
    }

    @Override
    public boolean isExist(String id) {
        if(getObject(id) == null) return false;
        return true;
    }
}
