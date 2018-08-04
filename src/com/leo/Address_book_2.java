package com.leo;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//通讯录_2
public class Address_book_2 implements Address_book{
    private HashMap p2;
    Connection con=DataBase.getCon();
    PreparedStatement preparedSta=null;

    Address_book_2() {
        p2=new HashMap<String,Person2>();
    }

    public Address_book_2(HashMap<String, Person2> p2) {
        this.p2 = p2;
    }

    public HashMap getP2() {
        return p2;
    }

    public void setP2(HashMap p2) {
        this.p2 = p2;
    }

    @Override
    public void add() throws SQLException {
        String sql="INSERT sim(name,phone,qq,birthplace) VALUES(?,?,?,?)";
        preparedSta=con.prepareStatement(sql);
        System.out.println("正在添加联系人 [输入stop结束录入]\n");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入联系人姓名： ");
        String name = in.nextLine();
        if (!name.equals("stop")) {
            System.out.println("请输入联系人手机： ");
            String phone = in.nextLine();
            System.out.println("请输入联系人QQ： ");
            String qq = in.nextLine();
            System.out.println("请输入联系人籍贯： ");
            String birthplace = in.nextLine();
            Person2 temp = new Person2(name, phone,qq,birthplace);
            p2.put(phone, temp);
            preparedSta.setString(1, name);
            preparedSta.setString(2, phone);
            preparedSta.setString(3, qq);
            preparedSta.setString(4, birthplace);
            preparedSta.execute();
            System.out.println("\n" + temp.toString() + "\n#   添加到sim卡成功   #\n");
            add();
        } else {
            System.out.println("#   录入完成！\n");
        }
    }

    @Override
    public void delete(String x) throws SQLException {
        p2.remove(x);
        String sql="DELETE FROM sim WHERE phone=?";
        PreparedStatement preparedsta=con.prepareStatement(sql);
        preparedsta.setString(1, x);
        preparedsta.execute();
    }

    @Override
    public void modify(String x) throws SQLException {
        p2.remove(x);
        String sql="UPDATE sim SET name=?,phone=?,qq=?,birthplace=? WHERE phone=?";
        preparedSta=con.prepareStatement(sql);
        Scanner in = new Scanner(System.in);
        System.out.println("请输入联系人姓名： ");
        String name_temp=in.nextLine();
        System.out.println("请输入联系人手机： ");
        String phone_temp=in.nextLine();
        System.out.println("请输入联系人QQ： ");
        String qq_temp=in.nextLine();
        System.out.println("请输入联系人籍贯： ");
        String place_temp=in.nextLine();
        Person2 p2_temp= new Person2(name_temp,phone_temp,qq_temp,place_temp);
        p2.put(phone_temp,p2_temp );
        preparedSta.setString(1, name_temp);
        preparedSta.setString(2, phone_temp);
        preparedSta.setString(3, qq_temp);
        preparedSta.setString(4, place_temp);
        preparedSta.setString(5,x );
        preparedSta.execute();
        System.out.println(p2_temp);
    }

    @Override
    public boolean inquireByname(String x) {
        boolean flag=false;
        Iterator it=p2.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry<String, Person2> entry=(HashMap.Entry<String, Person2>) it.next();
            if (x.equals(entry.getValue().getName())){
                flag=true;
                System.out.println(entry.getValue());
            }
        }
        if(flag){
            return true;
        }
        else{
            System.out.println("#sim  未找到姓名为 " + x + " 的联系人");
            return false;
        }
    }

    @Override
    public boolean inquireByphone(String x) {
        if (p2.containsKey(x)) {
            System.out.println(p2.get(x) + "\n");
            return true;
        } else {
            System.out.println("#sim  未找到号码为 " + x + " 的联系人");
            return false;
        }
    }

    @Override
    public void display() {
        Iterator map1it=p2.entrySet().iterator();
        while(map1it.hasNext())
        {
            HashMap.Entry<String, Person2> entry=(HashMap.Entry<String, Person2>) map1it.next();
            System.out.println(entry.getValue());
        }
    }

    @Override
    public void read() throws SQLException {
        String cmd = "SELECT * FROM sim";
        preparedSta=con.prepareStatement(cmd);
        ResultSet res=preparedSta.executeQuery();
        while (res.next()){
            String name=res.getString("name");
            String phone=res.getString("phone");
            String qq=res.getString("qq");
            String birthplace=res.getString("birthplace");
            Person2 temp=new Person2(name,phone,qq,birthplace);
            p2.put(phone, temp);
        }
    }

    @Override
    public void save() {

    }

    public void close(ResultSet x, boolean flag){
        if(flag){
            DataBase.close(x, preparedSta,con );
        }
        else
            DataBase.close(null, preparedSta,con );
    }
}
