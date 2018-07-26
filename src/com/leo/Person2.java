package com.leo;

import java.io.Serializable;

//手机卡联系人 继承erson1 包含name phone qq birthplace
public class Person2 extends Person1 implements Serializable {

    private String qq;
    private String birthplace;

    public Person2() {
        super();
        this.qq=null;
        this.birthplace=null;
    }

    public Person2(String name, String phone, String qq, String birthplace) {
        super(name, phone);
        this.qq = qq;
        this.birthplace = birthplace;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    @Override
    public String toString() {
        return "姓名: " + this.getName() + "  电话: " + this.getPhone()+"   QQ: " + qq + "  籍贯: " + birthplace;
    }
}
