package com.leo;

import java.util.HashMap;

//通讯录具体功能接口
public interface Address_book {
    void add();
    void delete(String x);
    void modify(String x);
    boolean inquireByname(String x);
    boolean inquireByphone(String x);
    void display();
    void read();
    void save();
}
