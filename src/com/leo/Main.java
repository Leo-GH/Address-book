package com.leo;

import java.sql.SQLException;

/**
 * @Author:Leo-GH
 * @Date:  2018/8/4 21:07
 * 运用MySQL重写Address-book
 **/

public class Main {
    public static void main(String[] args){
        Menu menu=new Menu();
        try {
            menu.welcome();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}