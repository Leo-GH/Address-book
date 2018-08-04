package com.leo;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

//通讯录_1 sdcard
public class Address_book_1 implements Address_book {

    private   HashMap<String, Person1> p1;
    private   HashMap<String, Person2> p2_Temp;
    Connection con=DataBase.getCon();
    PreparedStatement preparedSta=null;

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
    public void add() throws SQLException {
        String sql="INSERT sdcard(name,phone) VALUES(?,?)";
        preparedSta=con.prepareStatement(sql);
        System.out.println("正在添加联系人 [输入stop结束录入]\n");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入联系人姓名： ");
        String name = in.nextLine();
        if (!name.equals("stop")) {
            System.out.println("请输入联系人手机： ");
            String phone = in.nextLine();
            Person1 temp = new Person1(name, phone);
            p1.put(phone, temp);
            preparedSta.setString(1, name);
            preparedSta.setString(2, phone);
            preparedSta.execute();
            System.out.println("\n" + temp.toString() + "\n#   添加到sdcard表成功   #\n");
            add();
        } else {
            System.out.println("#   录入完成！\n");
        }
    }

    @Override
    public void delete(String x) throws SQLException {
        p1.remove(x);
        String sql="DELETE FROM sdcard WHERE phone=?";
        preparedSta=con.prepareStatement(sql);
        preparedSta.setString(1, x);
        preparedSta.execute();
    }

    @Override
    public void modify(String x) throws SQLException {
        p1.remove(x);
        String sql="UPDATE sdcard SET name=?,phone=? WHERE phone=?";
        preparedSta=con.prepareStatement(sql);
        Scanner in = new Scanner(System.in);
        System.out.println("请输入联系人姓名： ");
        String name_temp=in.nextLine();
        System.out.println("请输入联系人手机： ");
        String phone_temp=in.nextLine();
        Person1 p1_temp = new Person1(name_temp,phone_temp);
        p1.put(phone_temp,p1_temp );
        preparedSta.setString(1, name_temp);
        preparedSta.setString(2, phone_temp);
        preparedSta.setString(3,x );
        preparedSta.execute();
        System.out.println(p1_temp);
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

    @Override//读取数据存入集合
    public void read() throws SQLException {
            String cmd = "SELECT * FROM sdcard";
            preparedSta=con.prepareStatement(cmd);
            ResultSet res=preparedSta.executeQuery();
            while (res.next()){
                String name=res.getString("name");
                String phone=res.getString("phone");
                Person1 temp=new Person1(name,phone);
                p1.put(phone, temp);
            }
    }

    @Override//从集合写入数据库
    public void save() {
        final String URL = "jdbc:mysql://localhost:3306/address_book?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        final String USER = "root";
        final String PASSWORD = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("# 数据库驱动加载成功");

            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("# 数据库连接成功 " + con);

            Statement sta = con.createStatement();
            System.out.println("# 获取statement对象成功 " + sta);

            for (String key : p1.keySet()) {
                String cmd = "INSERT person_1 VALUES("+p1.get(key).getName()+","+p1.get(key).getPhone()+") ";
                sta.execute(cmd);
            }
            sta.close();
            con.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(ResultSet x,boolean flag){
        if(flag){
            DataBase.close(x, preparedSta,con );
        }
        else
            DataBase.close(null, preparedSta,con );
    }
}
