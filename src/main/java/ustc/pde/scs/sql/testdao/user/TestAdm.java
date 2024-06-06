package ustc.pde.scs.sql.testdao.user;

import ustc.pde.scs.entity.user.Administrator;
import ustc.pde.scs.sql.implementation.user.AdmDAOImpl;

import java.util.ArrayList;

public class TestAdm {
    public static void main(String[] args) {
        Administrator administrator = new Administrator("sad","1231","asdada","sadasda","dsada","asdasd");
        AdmDAOImpl admDAO = new AdmDAOImpl();
        if(admDAO.insert(administrator)){
            System.out.println(admDAO.getObject(administrator.getID()));
        }else {
            System.out.println("插入失败");
        }
        ArrayList<Administrator> administrators = admDAO.getAllAdm();
        for(Administrator adm: administrators){
            System.out.println(adm);
        }
        if(admDAO.delete(administrator.getID())){
            System.out.println("删除成功");
        }
    }
}
