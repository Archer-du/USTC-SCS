package data.user;

public class User {
    private String account;     //用户名
    private String password;    //密码
    private String name;    //姓名
    private String ID;  //学号、工号
    private String email;   //电子邮箱
    private String idCard;  //身份证号

    public User() {
    }

    public User(String account, String password, String name, String ID, String email, String idCard) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.idCard = idCard;
    }

    /**
     * 获取
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
        return "User{account = " + account + ", password = " + password + ", name = " + name + ", ID = " + ID + ", email = " + email + ", idCard = " + idCard + "}";
    }
}
