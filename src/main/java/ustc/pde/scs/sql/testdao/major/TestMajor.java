package ustc.pde.scs.sql.testdao.major;

import ustc.pde.scs.entity.major.Major;
import ustc.pde.scs.sql.implementation.major.MajorDAOImpl;
import ustc.pde.scs.sql.inter.major.MajorDAO;

import java.util.ArrayList;

public class TestMajor {
    public static void main(String[] args) {
        Major major = new Major("1111","dadas","askjdakl");
        MajorDAOImpl majorDAO = new MajorDAOImpl();
        if(majorDAO.insert(major)){
            System.out.println(majorDAO.getObject(major.getMajorId()));
        }else {
            System.out.println("插入失败");
        }
        major.setMajorName("奶奶滴");
        if(majorDAO.update(major)){
            System.out.println(majorDAO.getObject(major.getMajorId()));
        }else {
            System.out.println("修改失败");
        }
        ArrayList<Major> majors = majorDAO.getAll();
        for(Major m: majors){
            System.out.println(m);
        }
        System.out.println(majorDAO.getCount().intValue());
        if(majorDAO.delete(major.getMajorId())){
            System.out.println("删除成功!");
        }
    }
}
