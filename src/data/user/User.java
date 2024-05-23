package data.user;

public class User {
    private String account;     //用户名
    private String password;    //密码
    private String name;    //姓名
    private String id;  //学号、工号
    private String email;   //电子邮箱
    private String idCard;  //身份证号

    public User() {
    }

    public User(String account, String password, String name, String id, String phone, String idCard) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.id = id;
        this.phone = phone;
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
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
        return "User{account = " + account + ", password = " + password + ", name = " + name + ", id = " + id + ", phone = " + phone + ", idCard = " + idCard + "}";
    }
}
