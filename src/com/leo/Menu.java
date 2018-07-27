package com.leo;

import java.util.Scanner;

//菜单类_实现字符菜单
public class Menu {
    private Address_book a1=new Address_book_1();
    private Address_book a2=new Address_book_2();
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
        System.out.print( "        ┃ [5]  转存*      \n");
        System.out.print( "        ┣━━━━━━━━━━━━━━┫\n");
        System.out.print( "        ┃ [6] 显示所有   \n");
        System.out.print( "        ┗━━━━━━━━━━━━━━┛\n");
        System.out.print( "             By-Leo\n");
        System.out.print( "输入要进行的操作:\n");
        String cm = in.nextLine();
        switch (cm){

            case "0":
                System.out.println("        #     感谢使用     #   \n");
                a1.save();
                a2.save();
                System.exit(0);
                break;

            case "1":
                System.out.println("  请选择要添加的位置: \n");
                System.out.println("[1] 添加到 sdcard.txt");
                System.out.println("[2] 添加到 sim.txt");
                String place=in.nextLine();
                if(place.equals("1")){
                    a1.add();
                    welcome();
                }
                else if(place.equals("2")){
                    a2.add();
                    welcome();
                }
                else {
                    System.out.println("#   命令输入有误，请重新输入！\n");
                    welcome();
                }
                break;

            case "2":
                System.out.println("  请输入要删除的号码: ");
                String delphone = in.nextLine();
                boolean is1=a1.inquireByphone(delphone);
                boolean is2=a2.inquireByphone(delphone);
                if(is1){//如果联系人存在 则删除
                    a1.delete(delphone);
                    System.out.println("#   sdcard.txt删除联系人成功！\n");
                }else if (is2){
                    a2.delete(delphone);
                    System.out.println("#   sim.txt   删除联系人成功！\n");
                }
                else{//否则 报错
                    System.out.println("#   该号码不存在,请重新输入！\n");
                }
                welcome();
                break;

            case "3":
                System.out.println("  请输入要修改的号码: ");
                String modphone = in.nextLine();
                boolean isa1=a1.inquireByphone(modphone);
                boolean isa2=a2.inquireByphone(modphone);
                if(isa1){
                    a1.modify(modphone);
                    System.out.println("#   sdcard 修改联系人成功！\n");
                }else if (isa2){
                    a2.modify(modphone);
                    System.out.println("#   sim   修改联系人成功！\n");
                }
                else{
                    System.out.println("#   该号码不存在,请重新输入！\n");
                }
                welcome();
                break;

            case "4":
                System.out.println("  请选择查询方式: ");
                System.out.println("[1] 姓名查询");
                System.out.println("[2] 号码查询");
                cm=in.nextLine();
                if(cm.equals("1")){
                    System.out.println("  请输入要查询的姓名: ");
                    String name=in.nextLine();
                    a1.inquireByname(name);
                    a2.inquireByname(name);
                }
                else if(cm.equals("2")){
                    System.out.println("  请输入要查询的号码: ");
                    String phone=in.nextLine();
                    a1.inquireByphone(phone);
                    a2.inquireByphone(phone);
                }
                else System.out.println("#   命令输入有误，请重新输入！\n");
                welcome();
                break;

            case "5":
                System.out.println("  请选择转存方式: ");
                System.out.println("[1] sdcard->sim");
                System.out.println("[2] sim->sdcard");
                cm=in.nextLine();
                if (cm.equals("1")){
                    System.out.println("#   sdcard->sim 转存成功！\n");
                }
                else if (cm.equals("2")){
                    System.out.println("#   sim->sdcard 转存成功！\n");
                }
                else System.out.println("#   命令输入有误，请重新输入！\n");
                welcome();
                break;

            case "6":
                a1.display();
                a2.display();
                System.out.println();
                welcome();
                break;

            default:
                System.out.println("#   命令输入有误，请重新输入！\n");
                welcome();
        }
    }
}
