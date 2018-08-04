package com.leo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//通讯录具体功能接口
public interface Address_book {
    void add() throws SQLException;
    void delete(String x) throws SQLException;
    void modify(String x) throws SQLException;
    boolean inquireByname(String x);
    boolean inquireByphone(String x);
    void display();
    void read() throws SQLException;
    void save();
    void close(ResultSet x, boolean flag);
}
