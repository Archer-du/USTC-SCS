package ustc.pde.scs.sql.implementation.major;

import ustc.pde.scs.entity.major.Major;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.base.BaseDAO;
import ustc.pde.scs.sql.inter.major.MajorDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class MajorDAOImpl extends BaseDAO implements MajorDAO {
    @Override
    public boolean insert(Major major) {
        try{
            String sql = "insert into major(majorId,majorName,majorIntro) values (?,?,?) ";
            executeUpdate(sql,major.getMajorId(),major.getMajorName(),major.getMajorIntro());
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean delete(String majorId) {
        try {
            String sql = "delete from major where majorId = ?";
            executeUpdate(sql,majorId);
            return true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public boolean update(Major major) {
        try {
            String sql = "update major set majorName = ?,majorIntro = ? where majorId= ?";
            executeUpdate(sql,major.getMajorName(),major.getMajorIntro(),major.getMajorId());
            return  true;
        }catch (SQLException e){
            return false;
        }

    }

    @Override
    public Major getObject(String majorId) {
        String sql = "select * from major where majorId= ?";
        return getInstance(Major.class,sql,majorId);
    }

    @Override
    public ArrayList<Major> getAll() {
        String sql = "select * from major";
        return getInstance2(Major.class,sql);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from major";
        return getValue(sql);
    }

    @Override
    public boolean isExist(String id) {
        if(getObject(id) == null){
            return false;
        }
        return true;
    }
}
