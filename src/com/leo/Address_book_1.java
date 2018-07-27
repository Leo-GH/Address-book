package com.leo;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

//通讯录_1 sdcard
public class Address_book_1 implements Address_book {

    private   HashMap<String, Person1> p1;
    private   HashMap<String, Person2> p2_Temp;

    Address_book_1() {
        p1 = new HashMap<String, Person1>();
        p2_Temp = new HashMap<String, Person2>();
    }

    public Address_book_1(HashMap<String, Person1> p1) {
        this.p1 = p1;
    }

    public HashMap<String, Person1> getP1() {
        return (HashMap<String, Person1>) p1;
    }
    public HashMap<String, Person2> getp2_Temp() { return (HashMap<String, Person2>)p2_Temp; }

    public void setp2_Temp(HashMap<String, Person2> p2_Temp) { this.p2_Temp = p2_Temp; }
    public void setP1(HashMap<String, Person1> p1) {
        this.p1 = p1;
    }


    @Override
    public void add() {
        System.out.println("正在添加联系人 [输入stop结束录入]\n");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入联系人姓名： ");
        String name = in.nextLine();
        if (!name.equals("stop")) {
            System.out.println("请输入联系人手机： ");
            String phone = in.nextLine();
            Person1 temp = new Person1(name, phone);
            p1.put(phone, temp);
            System.out.println("\n" + temp.toString() + "\n#   添加到sdcard卡成功   #\n");
            add();
        } else {
            System.out.println("#   录入完成！\n");
            save();
        }
    }

    @Override
    public void delete(String x) {
        p1.remove(x);
        save();
    }

    @Override
    public void modify(String x) {
        p1.remove(x);
        Scanner in = new Scanner(System.in);
        System.out.println("请输入联系人姓名： ");
        String name_temp=in.nextLine();
        System.out.println("请输入联系人手机： ");
        String phone_temp=in.nextLine();
        Person1 p1_temp = new Person1(name_temp,phone_temp);
        p1.put(phone_temp,p1_temp );
        System.out.println(p1_temp);
        save();
    }

    @Override
    public boolean inquireByname(String x) {
        boolean flag=false;
        for (String key :p1.keySet()) {
            if(x.equals(p1.get(key).getName())){
                flag = true;
                System.out.println();
                System.out.println(p1.get(key));
            }
        }
        if(flag) return true;
        else {
            System.out.println("#sdcard  未找到姓名为 " + x + " 的联系人");
            return false;
        }
    }

    @Override
    public boolean inquireByphone(String x) {
        if (p1.containsKey(x)) {
            System.out.println();
            System.out.println(p1.get(x) + "\n");
            return true;
        } else {
            System.out.println("#sdcard  未找到号码为 " + x + " 的联系人");
            return false;
        }
    }

    @Override
    public void display() {
        for (String key : p1.keySet()) {
            System.out.println(p1.get(key));
        }
    }

    @Override//对象反序列化
    public void read() {
        try {
            p1.clear();
            FileInputStream filein = new FileInputStream("resources\\sdcard.txt");
            ObjectInputStream in = new ObjectInputStream(filein);
            Person1 temp;
            while (filein.available() > 0) {
                temp = (Person1) in.readObject();
                p1.put(temp.getPhone(), temp);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override//对象序列化
    public void save() {
        try {
            FileOutputStream fileout = new FileOutputStream("resources\\sdcard.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            for (String key : p1.keySet()) {
                out.writeObject(p1.get(key));
            }
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
