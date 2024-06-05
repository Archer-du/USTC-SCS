package ustc.pde.scs.sql.testdao.user;

import ustc.pde.scs.entity.user.Teacher;
import ustc.pde.scs.sql.implementation.user.TeacherDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

public class TestTeacher {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("2023-01-05");
        teacher.setName("邵鑫");
        TeacherDAOImpl teacherDAO = new TeacherDAOImpl();
        teacher.setID("123456");
        teacher.setUsername("hdsakjdh");
        teacher.setPassword("dsah");
        if(teacherDAO.insert(teacher)){
            System.out.println(teacherDAO.getObject(teacher.getID()).toString());
        }else{
            System.out.println("插入失败!");
        }
        teacher.setName("牛逼");
        if(teacherDAO.update(teacher)){
            System.out.println("修改成功!");
            System.out.println(teacherDAO.getObject(teacher.getID()));
        }
        if(new UserDAOImpl().delete(teacher.getID())){
            System.out.println("删除成功!");
        }
    }
}
