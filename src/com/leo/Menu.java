package com.leo;

import java.util.Scanner;

//菜单类_实现字符菜单
public class Menu {
    public Address_book_1 a1 = new Address_book_1();
    public Address_book_2 a2 = new Address_book_2();
    public void welcome(){
        Scanner in = new Scanner(System.in);
        a1.read();
        a2.read();
        System.out.print("        #欢迎使用Leo通讯录#\n");
        System.out.print( "        ┏━━━━━━━━━━━━━━┓ \n");
        System.out.print( "        ┃ [0] 退出系统   \n");
        System.out.print( "        ┣━━━━━━━━━━━━━━┫ \n");
        System.out.print( "        ┃ [1]  增加      \n");
        System.out.print( "        ┣━━━━━━━━━━━━━━┫ \n");
        System.out.print( "        ┃ [2]  删除       \n");
        System.out.print( "        ┣━━━━━━━━━━━━━━┫ \n");
        System.out.print( "        ┃ [3]  修改      \n");
        System.out.print( "        ┣━━━━━━━━━━━━━━┫\n");
        System.out.print( "        ┃ [4]  查询      \n");
        System.out.print( "        ┣━━━━━━━━━━━━━━┫\n");
        System.out.print( "        ┃ [5] 显示所有   \n");
        System.out.print( "        ┗━━━━━━━━━━━━━━┛\n");
        System.out.print( "             By-Leo\n");
        System.out.print( "输入要进行的操作:\n");
        String cm = in.nextLine();
        switch (cm){

            case "0":
                System.out.println("        #     感谢使用     #   \n");
                /*a1.save();
                a2.save();*/
                System.exit(0);
                break;

            case "1":
                System.out.println("  请选择要添加的位置: \n");
                System.out.println("[1] 添加到 sdcard.txt");
                System.out.println("[2] 添加到 sim.txt");
                cm=in.nextLine();
                if(cm.equals("1")){
                    a1.add();
                    welcome();
                }
                else if(cm.equals("2")){
                    //a2.add();
                    welcome();
                }
                else {
                    System.out.println("#   命令输入有误，请重新输入！\n");
                    welcome();
                }
                break;

            case "2":
                System.out.println("  请输入要删除的号码: ");
                cm = in.nextLine();
                boolean is1=a1.inquireByphone(cm);
                boolean is2=a2.inquireByphone(cm);
                if(is1){//如果联系人存在 则删除
                    a1.delete(cm);
                    System.out.println("#   sdcard.txt删除联系人成功！\n");
                }else if (is2){
                    a2.delete(cm);
                    System.out.println("#   sim.txt   删除联系人成功！\n");
                }
                else{//否则 报错
                    System.out.println("#   该号码不存在,请重新输入！\n");
                }
                welcome();
                break;

            case "3":
                System.out.println("  请输入要修改的号码: ");
                cm = in.nextLine();
                welcome();
                break;

            case "4":
                System.out.println("  请选择要查找的姓名: ");
                String name=in.nextLine();
                a1.inquireByname(name);
                a2.inquireByname(name);
                welcome();
                break;

            case "5":
                a1.display();
                //a2.display();
                System.out.println("\n");
                welcome();
                break;

            default:
                System.out.println("#   命令输入有误，请重新输入！\n");
                welcome();
        }
    }
}
