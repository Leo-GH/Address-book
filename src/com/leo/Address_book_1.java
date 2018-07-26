package com.leo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//通讯录_1 sdcard
public class Address_book_1  implements Address_book {

    private Map<String,Person1> p1;

    public Address_book_1() {
        p1 = new HashMap<String, Person1>();
    }

    public Address_book_1(Map<String, Person1> p1) {
        this.p1 = p1;
    }

    public HashMap<String, Person1> getP1() {
        return (HashMap<String, Person1>) p1;
    }

    public void setP1(HashMap<String, Person1> p1) {
        this.p1 = p1;
    }


    @Override
    public void add() {
        System.out.println("正在添加联系人 [输入stop结束录入]\n");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入联系人姓名： ");
        String name = in.nextLine();
        if (!name.equals("stop")){
            System.out.println("请输入联系人手机： ");
            String phone = in.nextLine();
            Person1 temp=new Person1(name,phone);
            p1.put(name,temp);
            System.out.println("\n"+temp.toString()+"\n#   添加到sdcard卡成功   #\n");
            add();
        }
        else {
            System.out.println("#   录入完成！\n");
            save();
        }
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
        if(p1.containsKey(x)){
            System.out.println(p1.get(x)+"\n");
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean inquireByphone(String x) {
        return true;
    }

    @Override
    public void display() {
        for (String key : p1.keySet()) {
            System.out.println(p1.get(key));
        }
    }

    @Override
    public void cut() {
        save();
    }

    @Override
    public void copy() {
        save();
    }

    @Override//对象反序列化
    public void read() {
        try {
            p1.clear();
            FileInputStream filein = new FileInputStream("E:\\sdcard.txt");
            ObjectInputStream in = new ObjectInputStream(filein);
            Person1 temp = null;
            while (filein.available()>0) {
                temp = (Person1) in.readObject();
                p1.put(temp.getName(), temp);
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
            FileOutputStream fileout=new FileOutputStream("E:\\sdcard.txt");
            ObjectOutputStream out=new ObjectOutputStream(fileout);
            for (String key : p1.keySet()) {
                out.writeObject(p1.get(key));
            }
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
