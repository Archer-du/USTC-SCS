package ustc.pde.scs.sql.testdao.user;

import ustc.pde.scs.entity.major.Major;
import ustc.pde.scs.entity.user.Assistant;
import ustc.pde.scs.entity.user.Student;
import ustc.pde.scs.sql.implementation.user.AssistantDAOImpl;
import ustc.pde.scs.sql.implementation.user.StudentDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.nio.channels.AsynchronousServerSocketChannel;

public class TestAssistant {
    public static void main(String[] args) {
        Assistant assistant = new Assistant();
        assistant.setName("侯甲申");
        assistant.setStuType("本科");
        assistant.setMajor(new Major("123","计算机","sadjas"));
        assistant.setStudyDate("2023-11-05");
        assistant.setCurSemester("2024春季学期");
        assistant.setID("PB21051110");
        assistant.setPassword("hdasjk");
        assistant.setUsername("jdsalkd");
        assistant.setIdCard("dsa");
        AssistantDAOImpl assistantDAO = new AssistantDAOImpl();
        if(assistantDAO.insert(assistant)){
            System.out.println("插入成功");
            System.out.println(assistantDAO.getObject(assistant.getID()));
        }
        System.out.println(new UserDAOImpl().getObject(assistant.getID()));
        assistant.setStuType("研究生");
        if(assistantDAO.update(assistant)){
            System.out.println(assistantDAO.getObject(assistant.getID()));
        }
        if(assistantDAO.delete(assistant.getID())){
            new UserDAOImpl().delete(assistant.getID());
            System.out.println("成！");
        }
    }
}
