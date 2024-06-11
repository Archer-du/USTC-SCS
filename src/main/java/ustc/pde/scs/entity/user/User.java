package ustc.pde.scs.entity.user;

import ustc.pde.scs.controller.StartViewController;

public class User {
    private String username;     //用户名
    private String password;    //密码
    private String ID;  //学号、工号
    private String name;    //姓名
    private String email = "";   //电子邮箱
    private String idCard = "";  //身份证号

    private String majorId;     //专业号
    private String date;    //入学日期/工作日期
    private String type;       //用户类型

    public User() {
    }

    public User(String username, String password, String ID, String name, String email, String idCard, String majorId, String date, String type) {
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.idCard = idCard;
        this.majorId = majorId;
        this.date = date;
        this.type = type;
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

    /**
     * 获取
     * @return majorId
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * 设置
     * @param majorId
     */
    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    /**
     * 获取
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + ", ID = " + ID + ", name = " + name + ", email = " + email + ", idCard = " + idCard + ", majorId = " + majorId + ", date = " + date + ", type = " + type + "}";
    }
}
