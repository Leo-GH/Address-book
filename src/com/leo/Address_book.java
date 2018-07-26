package com.leo;
//通讯录具体功能接口
public interface Address_book {
    public void add();
    public void delete(String x);
    public void modify();
    public boolean inquireByname(String x);
    public boolean inquireByphone(String x);
    public void display();
    public void cut();
    public void copy();
    public void read();
    public void save();
}
