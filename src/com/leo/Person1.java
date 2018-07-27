package com.leo;

import java.io.Serializable;

//手机联系人 只包含name phone
public class Person1 extends Object implements Serializable {

    private String name;
    private String phone;

    public Person1() {
        this.name = null;
        this.phone = null;
    }

    public Person1(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "姓名: " + name + "    电话: " + phone;
    }
}
