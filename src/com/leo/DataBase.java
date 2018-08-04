package com.leo;

import java.sql.*;

public class DataBase {

    private static final String URL="jdbc:mysql://localhost:3306/address_book?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static final String USER="root";
    private static final String PASSWORD="root";
    private static Connection con=null;

    public static Connection getCon() {
        return con;
    }

    static {
        try {
            //加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获得数据库连接
            con=DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
