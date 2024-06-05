package ustc.pde.scs.entity.user;

public class User {
    private String username;     //用户名
    private String password;    //密码
    private String ID;  //学号、工号
    private String email = "";   //电子邮箱
    private String idCard = "";  //身份证号

    public User() {
    }

    public User(String username, String password, String ID, String email, String idCard) {
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.email = email;
        this.idCard = idCard;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 设置
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + ", ID = " + ID + ", email = " + email + ", idCard = " + idCard + "}";
    }
}
