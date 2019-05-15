package com.example;

import java.awt.*;

class colors {
    public static Color colors(int a){
        //黄紫蓝绿红青
        if(a==1){
            return new Color(0xFDFF44);
        }
        if(a==2){
            return new Color(0xE04CFF);
        }
        if(a==3){
            return new Color(0x168BFF);
        }
        if(a==4){
            return new Color(0x79FF53);
        }
        if(a==5){
            return new Color(0xFF3648);
        }
        else{
            return new Color(0x12FFFC);
        }

    }

    public static String colorsword(int a){
        if(a==1){
            return "黄色";
        }
        if(a==2){
            return "紫色";
        }
        if(a==3){
            return "蓝色";
        }
        if(a==4){
            return "绿色";
        }
        if(a==5){
            return "红色";
        }
        else{
            return "青色";
        }
    }
}
