package ustc.pde.scs.entity.user;

public class Administrator extends User{

    public Administrator() {
    }

    public Administrator(String id,String username,String password,String idCard,String name,String email) {
        super(username,password,id,name,email,idCard);
    }

    public String toString() {
        return super.toString();
    }
}
