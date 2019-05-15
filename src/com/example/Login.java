package com.example;


import com.calculation.cheatcode;
import com.calculation.ifstandard;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//1.创建名为Login的类，在该类中创建一个名为InitUI的方法，图形界面就在此方法中实现
public class Login {
    public JButton[][] buttonlist=new JButton[9][9];//这个是下面表格的button

    public JButton[] buttonofcolor=new JButton [7];
    public static int size;
    public int color;
    public int[][] qipan=new int[9][9];
    public static void main() {
        Login log=new Login();
        log.InitUI();
    }
    public void InitUI()
    {
//1.1创建一个顶级容器，也就是空白窗口，并为此窗口设置属性（窗口名称，大小，显示位置，关闭设置）

// 用JFrame创建一个名为frame的顶级容器，需要添加的包名为javax.swing.JFrame
        JFrame frame=new JFrame();
//设置窗口名称
        frame.setTitle("Login");
//设置窗口大小
        frame.setSize(540,427);
//设置窗口位于屏幕中央
        frame.setLocationRelativeTo(null);
//参数为3时，表示关闭窗口则程序退出
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setBounds(100,100,1000,1000);
        Container  con = frame.getContentPane();

//1.2设置窗体上组件的布局，此处使用流式布局FlowLayout，流式布局类似于word的布局
//用FlowLayout创建一个名为f1的对象,需要添加的包名为java.awt.FlowLayout，其中LEFT表示左对齐，CENTER表示居中对齐，RIGHT表示右对齐
        //FlowLayout f1=new FlowLayout(FlowLayout.LEFT);
//frame窗口设置为f1的流式左对齐
        //frame.setLayout(f1);




//创建一个空的JLabel，它的长度宽度为110,30，因为窗口是流式左对齐，为了将”账号”一栏添加在正中间，所以左侧由空的JLabel填充
        //JLabel name1=new JLabel();
//设置空JLabel长度大小，此处不能使用setSize设置大小，setSize只能设置顶级容器大小，此处用setPreferredSize，Dimension给出大小，需要添加的包名为java.awt.Dimension.
        //name1.setPreferredSize(new Dimension(110,30));
//将空JLabel添加入窗口
        //frame.add(name1);

//同上，此处添加的不是空JLabel，而是内容为“账号”的JLabel
        //JLabel name=new JLabel("账号：");
        //frame.add(name);

//JTextField在窗口上添加一个可输入可见文本的文本框，需要添加的包名为javax.swing.JTextField.
        //JTextField nametext=new JTextField();
//设置文本框大小
        //nametext.setPreferredSize(new Dimension(220, 30));
//添加到窗口上
        //frame.add(nametext);




//同name1
        //JLabel name2=new JLabel();
        //name2.setPreferredSize(new Dimension(110,30));
        //frame.add(name2);

//同name1
        //JLabel name3=new JLabel();
        //name3.setPreferredSize(new Dimension(110,30));
        //frame.add(name3);

//同name
        //JLabel password=new JLabel("密码：");
        //frame.add(password);

//JPasswordField创建一个密码文本框，里面输入的文本是不可见的，其他同nametext
        //JPasswordField passwordtext=new JPasswordField();
        //passwordtext.setPreferredSize(new Dimension(220, 30));
        //frame.add(passwordtext);

//同name1
        //JLabel name4=new JLabel();
        //name4.setPreferredSize(new Dimension(110,30));
        //frame.add(name4);

//同name1
        //JLabel name5=new JLabel();
        //name5.setPreferredSize(new Dimension(220,30));
        //frame.add(name5);

//JButton创建一个可点击的按钮，按钮上可显示文本图片
        JButton b5=new JButton("5X5");
        b5.setBounds(10, 10, 80, 30);
        frame.add(b5);

        JButton b6=new JButton("6X6");
        b6.setBounds(100, 10, 80, 30);
        frame.add(b6);

        JButton b7=new JButton("7X7");
        b7.setBounds(190, 10, 80, 30);
        frame.add(b7);

        JButton b8=new JButton("8X8");
        b8.setBounds(280, 10, 80, 30);
        frame.add(b8);

        JButton b9=new JButton("9X9");
        b9.setBounds(370, 10, 80, 30);
        frame.add(b9);

        JButton b10=new JButton("确认");
        b10.setBounds(460, 10, 80, 30);
        frame.add(b10);


        b5.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色

                size=5;





                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=0;
                    }
                }
                for(int i=size;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
                for(int i=0;i<9;i++){
                    for(int j=size;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
                drawgezi(frame,null);



            }
        });
        b6.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                size=6;
                drawgezi(frame,null);

                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=0;
                    }
                }
                for(int i=size;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
                for(int i=0;i<9;i++){
                    for(int j=size;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
            }
        });
        b7.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                size=7;
                drawgezi(frame,null);


                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=0;
                    }
                }
                for(int i=size;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
                for(int i=0;i<9;i++){
                    for(int j=size;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
            }
        });
        b8.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                size=8;
                drawgezi(frame,null);


                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=0;
                    }
                }
                for(int i=size;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
                for(int i=0;i<9;i++){
                    for(int j=size;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
            }
        });
        b9.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                size=9;
                drawgezi(frame,null);


                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=0;
                    }
                }
                for(int i=size;i<9;i++){
                    for(int j=0;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
                for(int i=0;i<9;i++){
                    for(int j=size;j<9;j++){
                        qipan[i][j]=-1;
                    }
                }
            }
        });





        // 获得容器，设置容器背景颜色




        //这个键是用于确认，并且发送数据到另一个方法去计算的
        b10.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                /*for(int i=0;i<size;i++){
                    System.out.print(i+" ");
                    for(int j=0;j<size;j++){
                        //System.out.print(size);
                        System.out.print(qipan[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
                */

                //p是0表示非标准题目，也就是说出错了

//                System.out.println("最开始的棋盘");
//                for(int i=0;i<9;i++){
//                    for (int j=0;j<9;j++){
//
//                        System.out.print(qipan[i][j]);
//                    }
//                }System.out.println();

                int p= ifstandard.ifstandard(qipan);
                //System.out.println(p);
                if(p==0){
                    JOptionPane.showMessageDialog(null, "你给的不对", "题目是否标准", JOptionPane.ERROR_MESSAGE);
                }else{


                    qipan=cheatcode.cheatcode(qipan);
                }

                if(qipan[0][0]==-1){
                    JOptionPane.showMessageDialog(null, "没有符合条件的结果", "题目未完成", JOptionPane.ERROR_MESSAGE);
                }else{
                    //画出棋盘
                drawgezi(frame,qipan);









                }
            }
        });




        //这里是初始化所有的按钮装进buttonlist中（已在最前面public声明），后来会讲这些根据前面的按钮来打印
        for(int i=0;i<9;i++){//i是横的的
            for(int j=0;j<9;j++){

                JButton gezi=new JButton("");
                String act=i*10+j+"";
                gezi.setBounds(10+80*j, 100+80*i, 80, 80);
                gezi.setActionCommand(act);
                buttonlist[i][j]=gezi;

            }
        }







        JButton c1=new JButton("黄色");

        c1.setBounds(10, 50, 80, 30);
        c1.setForeground(colors.colors(1));
        frame.add(c1);

        JButton c2=new JButton("紫色");
        c2.setBounds(100, 50, 80, 30);
        c2.setForeground(colors.colors(2));
        frame.add(c2);

        JButton c3=new JButton("蓝色");
        c3.setBounds(190, 50, 80, 30);
        c3.setForeground(colors.colors(3));
        frame.add(c3);

        JButton c4=new JButton("绿色");
        c4.setBounds(280, 50, 80, 30);
        c4.setForeground(colors.colors(4));
        frame.add(c4);

        JButton c5=new JButton("红色");
        c5.setBounds(370, 50, 80, 30);
        c5.setForeground(colors.colors(5));
        frame.add(c5);

        JButton c6=new JButton("青色");
        c6.setBounds(460, 50, 80, 30);
        c6.setForeground(colors.colors(6));
        frame.add(c6);

        c1.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色

                color=1;


            }
        });
        c2.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                color=2;

            }
        });
        c3.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                 color=3;
            }
        });
        c4.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                color=4;
            }
        });
        c5.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                color=5;
            }
        });
        c6.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                color=6;
            }
        });









//设置窗口可见，此句一定要在窗口属性设置好了之后才能添加，不然无法正常显示
        frame.setVisible(true);
    }

    public void drawgezi(JFrame frame,int[][] huaqipan){

        for(int i=0;i<9;i++){//i是横的的
            for(int j=0;j<9;j++){

                if(i<size&&j<size){
                    buttonlist[i][j].setVisible(true);
                    final JButton p=buttonlist[i][j];
                    final int pi=i,pj=j;
                    if(huaqipan!=null){
                        p.setText("●");
                        Font f = new Font(null, Font.BOLD, 70);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
                        p.setFont(f);
                        p.setForeground(colors.colors(huaqipan[pi][pj]));
                        //
                        //System.out.print(pi+" "+ pj+qipan[0].length);
                        //qipan[pi][pj] = color;
                    }else {
                        buttonlist[i][j].addActionListener(new ActionListener() {
                            // 事件处理
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // 获得容器，设置容器背景颜色
                                //p.setText(colors.colorsword(color));
                                if (color != 0) {
                                    p.setText("●");
                                    Font f = new Font(null, Font.BOLD, 70);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
                                    p.setFont(f);
                                    p.setForeground(colors.colors(color));
                                    //
                                    //System.out.print(pi+" "+ pj+qipan[0].length);
                                    qipan[pi][pj] = color;
                                }
                            }
                        });
                    }
                    buttonlist[i][j]=p;
                    frame.add(buttonlist[i][j]);
                }
                else {
                    buttonlist[i][j].setVisible(false);
                }

            }
        }
        frame.repaint();
    }




    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // Handle each button.
        if (cmd.equals("up")) { //jb1 clicked

        } else if (cmd.equals("down")) { // jb2 clicked

        } else if (cmd.equals("back")) { // jb3 clicked

        }


    }

    public int returnsize(){
        return size;
    }
}
