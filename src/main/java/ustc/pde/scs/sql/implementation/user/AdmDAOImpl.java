package ustc.pde.scs.sql.implementation.user;

import ustc.pde.scs.entity.user.Administrator;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdmDAOImpl extends UserDAOImpl{
    public boolean insert(Administrator administrator){
        super.insert(administrator);
        try {
            String sql = "insert into administrator values(?)";
            executeUpdate(sql,administrator.getID());
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    public boolean delete(String id){
        try{
            String sql = "delete from administrator where id = ?";
            executeUpdate(sql,id);
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    public Administrator getObject(String id){
        String sql = "select users.id as ID,username,password,name,idCard,email " +
                "from users,administrator where users.id = administrator.id and administrator.id = ?";
        return getInstance(Administrator.class,sql,id);
    }
    public ArrayList<Administrator> getAllAdm(){
        String sql = "select users.id as ID,username,password,name,idCard,email " +
                "from users,administrator where users.id = administrator.id";
        return getInstance2(Administrator.class,sql);
    }
    public Long getCount(){
        String sql = "select count(*) from administrator";
        return getValue(sql);
    }
    public boolean isExist(String ID){
        if(getObject(ID) == null) return false;
        return true;
    }
}
