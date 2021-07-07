package com.sxrekord.emis.jdbcutil;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 此类是封装JDBC连接的工具类
 * @author Rekord
 */
public class JdbcUtils {

    static String user;
    static String password;
    static String driver;
    static String url;

    static {
        Properties info = new Properties();
        try {
            // don't support absolute path
            info.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user=info.getProperty("user");
        password=info.getProperty("password");
        driver=info.getProperty("driver");
        url=info.getProperty("url");

        // 1.加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        // 2.获取连接
        Connection connection = null;
        try {
            connection=DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            return connection;
        }

    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try {
        if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }} catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static int update(String sql,Object... params) {
        int update=0;
        try {
            Connection connection = JdbcUtils.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            update = statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            return update;
        }
    }
}
