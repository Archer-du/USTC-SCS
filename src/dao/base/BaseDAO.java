package dao.base;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * 数据库访问类
 */
public abstract class BaseDAO {
    //数据库驱动
    private static String driver = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static String url = "jdbc:mysql://127.0.0.1:3306/scs?useSSL=False";
    //数据库用户名
    private static String user = "root";
    //数据库密码
    private static String password = "houge.0404";

    //数据库连接
    protected Connection conn = null;
    //statement对象
    protected PreparedStatement ps = null;

    /**
     * 连接数据库
     *
     * @return 数据库连接
     * @throws ClassNotFoundException 未找到驱动类异常
     * @throws SQLException           数据库异常
     */
    public Connection getConn() throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName(driver);
        //获取连接
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 数据库查询方法
     *
     * @param sql    预编译sql语句
     * @param params 预编译参数
     * @return 查询结果集
     * @throws SQLException 数据库异常
     */
    public ResultSet executeQuerySQL(String sql, Object ... params) throws SQLException {
        ResultSet rs = null;
        try {
            conn = getConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ps = conn.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        rs = ps.executeQuery();
        return rs;
    }
    /**返回一条记录*/
    public <T> T getInstance(Class<T> clazz,String sql,Object... args){
        ResultSet rs = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();  //创建对象
                for(int i = 0;i<columnCount;i++){
                    Object columValue = rs.getObject(i+1);
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Field field;
                    try{
                        field= clazz.getDeclaredField(columnLabel);
                    }catch (NoSuchFieldException e){
                        try{
                            field = clazz.getSuperclass().getDeclaredField(columnLabel);
                        }
                        catch (NoSuchFieldException e1){
                            field = clazz.getSuperclass().getSuperclass().getDeclaredField(columnLabel);
                        }
                    }
                    field.setAccessible(true);
                    field.set(t,columValue);
                }
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**返回多条记录
     * @return*/
    public  <T> ArrayList<T> getInstance2( Class<T> clazz, String sql, Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<T>();
            while(rs.next()) {
                T t = clazz.newInstance();  //创建对象
                for(int i = 0;i<columnCount;i++){
                    Object columValue = rs.getObject(i+1);
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Field field;
                    try{
                        field= clazz.getDeclaredField(columnLabel);
                    }catch (NoSuchFieldException e){
                        try{
                            field = clazz.getSuperclass().getDeclaredField(columnLabel);
                        }
                        catch (NoSuchFieldException e1){
                            field = clazz.getSuperclass().getSuperclass().getDeclaredField(columnLabel);
                        }
                    }
                    field.setAccessible(true);
                    field.set(t,columValue);
                }
                list.add(t);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public <E> E getValue(String sql,Object...args){
        try {
            conn = getConn();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0;i<args.length;i++){
                ps.setObject(i + 1,args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return (E) rs.getObject(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 数据库增删改方法
     *
     * @param sql    预编译sql语句
     * @param params 预编译参数
     * @return 数据库影响行数
     * @throws SQLException 数据库异常
     */
    public int executeUpdate(String sql, Object ... params) throws SQLException {
        try {
            conn = getConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int num = 0;
        ps = conn.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
        num = ps.executeUpdate();
        return num;
    }

    /**
     * 关闭数据库连接
     * @param conn 数据库连接
     * @param ps  statement对象
     * @param rs  ResultSet对象
     */
    public void closeALL(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}