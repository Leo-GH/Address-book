package com.leo;
//通讯录_2
public class Address_book_2 implements Address_book{
    @Override
    public void add() {
        save();
    }

    @Override
    public void delete(String x) {
        save();
    }

    @Override
    public void modify() {
        save();
    }

    @Override
    public boolean inquireByname(String x) {
        return true;
    }

    @Override
    public boolean inquireByphone(String x) {

        return true;
    }

    @Override
    public void display() {
        System.out.println("显示所有联系人");
    }

    @Override
    public void cut() {
        save();
    }

    @Override
    public void copy() {
        save();
    }

    @Override
    public void read() {

    }

    @Override
    public void save() {

    }
}
