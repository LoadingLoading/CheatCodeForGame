package com.calculation;

public class huxiangpipei {
    private static int[][] lujing=new int[9][9];
    private static int[] yansechangdu=new int[13];
    public static int[][] huxiangpipei(int[][][][] roadheji,int lengthofqipan){
        int mianjiofqipan=lengthofqipan*lengthofqipan;

        int lujingchangdu=1 ;
        //lujingchangdu就是把每一条点路径长度相乘，得到所有可能性的个数
        for(int i=1;i<7;i++) {
            if (roadheji[i] != null) {
                lujingchangdu=lujingchangdu*roadheji[i].length;

                System.out.println("路径"+i+" "+roadheji[i].length);
                System.out.println("路径相乘以后"+i+" "+lujingchangdu);

            }
        }
        //System.out.println("一共有多少条路"+lujingchangdu);

        int[][][] chucunlujing ;
        //int[][][] daiti1=new int[350000000][7][2];
        if(lujingchangdu<=350000000){
            //System.out.println("1长度是"+lujingchangdu);
            int[][][] daiti=new int[lujingchangdu][7][2];
            chucunlujing=daiti;
            System.out.println("长度是"+lujingchangdu+"， 已经列举完所有的可能性");
        }else{
            System.out.println("长度是"+"3 5000 0000，未列举完所有可能性");
            int[][][] daiti=new int[350000000][7][2];
            chucunlujing=daiti;
            //System.out.println("2长度是"+"35。。。");
        }

        //知道颜色的长度
        yansechangdu[0]=0;
        for(int i=1;i<7;i++){
            if (roadheji[i] != null) {
                yansechangdu[i]=roadheji[i].length;
                //System.out.println("颜色"+i+"有多少条路径： "+roadheji[i].length);
            }else{
                yansechangdu[i]=1;

            }
        }

        //得到 一个三元数组 chucunshuju[i][j][k] i代表第几个，j代表1～7的颜色，k为0时表示第几条路径，k为1时表示该路径的长度
//        int n=0;
//        int[] yongyuxunhuan;
//        for(int a1=0;a1<yansechangdu[1];a1++){
//            for(int a2=0;a2<yansechangdu[2];a2++){
//                for(int a3=0;a3<yansechangdu[3];a3++){
//                    for(int a4=0;a4<yansechangdu[4];a4++){
//                        for(int a5=0;a5<yansechangdu[5];a5++){
//                            for(int a6=0;a6<yansechangdu[6];a6++){
//
//                                chucunlujing[n][1][0]=a1;
//                                chucunlujing[n][1][1]=roadheji[1][a1].length;
//
//                                chucunlujing[n][2][0]=a2;
//                                chucunlujing[n][2][1]=roadheji[2][a2].length;
//
//                                chucunlujing[n][3][0]=a3;
//                                chucunlujing[n][3][1]=roadheji[2][a3].length;
//
//                                chucunlujing[n][4][0]=a4;
//                                chucunlujing[n][4][1]=roadheji[2][a4].length;
//
//                                chucunlujing[n][5][0]=a5;
//                                chucunlujing[n][5][1]=roadheji[2][a5].length;
//
//                                chucunlujing[n][6][0]=a6;
//                                chucunlujing[n][6][1]=roadheji[2][a6].length;
//
//
//
//
//
//
//                                for(int m=1;m<7;m++) {
//                                    chucunlujing[n][0][0]+=chucunlujing[n][m][1];
//                                }
//
//                                //System.out.println("酸楚这一套路径的点数为："+chucunlujing[n][0][0]);
//                                n++;
//
//                            }
//                        }
//                    }
//                }
//            }
//        }


        int n=0;
        int[] yongyuxunhuan=new int[7];
        for(int i=0;i<7;i++){
            yongyuxunhuan[i]=0;
            //System.out.println("路径"+i+" "+yansechangdu[i]);
        }
        for(yongyuxunhuan[1]=0;yongyuxunhuan[1]<yansechangdu[1];yongyuxunhuan[1]++){
            for(yongyuxunhuan[2]=0;yongyuxunhuan[2]<yansechangdu[2];yongyuxunhuan[2]++){
                for(yongyuxunhuan[3]=0;yongyuxunhuan[3]<yansechangdu[3];yongyuxunhuan[3]++){
                    for(yongyuxunhuan[4]=0;yongyuxunhuan[4]<yansechangdu[4];yongyuxunhuan[4]++){
                        for(yongyuxunhuan[5]=0;yongyuxunhuan[5]<yansechangdu[5];yongyuxunhuan[5]++){
                            for(yongyuxunhuan[6]=0;yongyuxunhuan[6]<yansechangdu[6];yongyuxunhuan[6]++){


                                for(int i=1;i<7;i++){
                                    if (roadheji[i] != null&&n<350000000&&n<chucunlujing.length) {
                                        //System.out.println(n+"路径"+i+" "+chucunlujing.length);
                                        //n是chucunlujing里的第几条，i是颜色，0是i颜色的第几条路径
                                        chucunlujing[n][i][0]=yongyuxunhuan[i];
                                        chucunlujing[n][i][1]= roadheji[i][yongyuxunhuan[i]].length;

                                    }
                                }
//                                chucunlujing[n][1][0]=a1;
//                                chucunlujing[n][1][1]=roadheji[1][a1].length;







                                for(int m=1;m<7;m++) {
                                    if (roadheji[m] != null&&n<350000000) {
                                        //System.out.println("在加面积，颜色"+m+"的面积是"+chucunlujing[n][m][1]);
                                        chucunlujing[n][0][0]+=chucunlujing[n][m][1];
                                    }

                                }

                                //System.out.println("酸楚这一套路径的点数为："+chucunlujing[n][0][0]);
                                n++;

                            }
                        }
                    }
                }
            }
        }


        //将所有面积符合的留下来
        int[][][] fuhelujing=new int[1][7][2];
        fuhelujing[0]=null;
        for(int i=0;i<chucunlujing.length;i++){
            //System.out.println("在查面积，第多少条："+i+"的面积是多少："+chucunlujing[i][0][0]+"需要多少："+mianjiofqipan);
            //System.out.println("dan路径长度："+chucunlujing[i][0][0]);
            if(chucunlujing[i][0][0]==mianjiofqipan){

                fuhelujing=roads.extendedroads(fuhelujing,chucunlujing[i]);
                //System.out.println("11路径长度："+fuhelujing[fuhelujing.length-1][0][0]);
                //将该数组添加到路径结果
            }
        }


//        for(int i=0;i<fuhelujing.length;i++){
//            System.out.println("路径长度："+fuhelujing[i][0][0]);
//        }

        //验证有无相同，一旦没有相同，将结果加入棋盘，并且返回。       如果始终有相同到格子，返回其他00=-1
        if(fuhelujing[0]==null){//如果面积不符合，则不进行重合路径判定
            lujing[0][0]=-1;
            System.out.println("面积符合条件的都没有");
        }else {//判定有无重合路径
            lujing = chachong(fuhelujing, roadheji, lengthofqipan);
            System.out.println();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(lujing[i][j]);
                }
                System.out.println();
            }
        }


        return lujing;
    }

    public static int[][] chachong(int[][][] fuhelujing,int[][][][] roadheji,int lengthofqipan){
        int yigeqipan[][]=new int[9][9];



        int shifoutiaochu=0;
        for(int n=0;n<fuhelujing.length;n++){


            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    yigeqipan[i][j]=0;
                }
            }
            for(int i=lengthofqipan;i<9;i++){
                for(int j=0;j<9;j++){
                    yigeqipan[i][j]=-1;
                }
            }
            for(int i=0;i<9;i++){
                for(int j=lengthofqipan;j<9;j++){
                    yigeqipan[i][j]=-1;
                }
            }





            int shifoucunzai=0;
            for(int j=1;j<7;j++){
                if(fuhelujing[n][j]==null){
                    break;
                }else {
                    for (int m = 0; m < fuhelujing[n][j][1]; m++) {
                        //System.out.println("重复，第多少条："+m);
                        //int[] zhegeweizhi = new int[2];

                        int wzi = roadheji[j][fuhelujing[n][j][0]][m][0];
                        int wzj = roadheji[j][fuhelujing[n][j][0]][m][1];
                        if (yigeqipan[wzi][wzj] == 0) {
                            yigeqipan[wzi][wzj] = j;
                        } else {
                            shifoucunzai = 1;
                        }
                    }
                }
            }
            if(shifoucunzai==0){
                System.out.println("有一种符合条件");
                shifoutiaochu=1;
                break;
            }


        }
        if(shifoutiaochu==0){
            System.out.println("一种符合条件的都没有");
            yigeqipan[0][0]=-1;
        }



        return yigeqipan;
    }





}
