package com.calculation;

public class whichcolors {
    public static int[][] yansezhonglei=new int[7][5];

    //这个方法会返回一个二维数组，第一个数表示颜色（0是没有，1～6是颜色），第二个是表示有这个颜色到两个位置（0～3是表示起点ij， 终点ij）
    public static int[][] whichcolors(int[][] qipan){
        for(int i = 0;i<7;i++){
            yansezhonglei[i][0]=0;

        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(qipan[i][j]!=0&&qipan[i][j]!=-1) {
                    //起点的位置
                    if(yansezhonglei[qipan[i][j]][0]==0){
                        yansezhonglei[qipan[i][j]][1]=i;
                        yansezhonglei[qipan[i][j]][2]=j;
                    }
                    //终点的位置
                    if(yansezhonglei[qipan[i][j]][0]==1){
                        yansezhonglei[qipan[i][j]][3]=i;
                        yansezhonglei[qipan[i][j]][4]=j;
                    }
                    yansezhonglei[qipan[i][j]][0] += 1;
                }
            }
        }
        yansezhonglei[0][0]=0;

        //检测，理应y[0]的都是0，然后就是有的颜色[0]都是2，后面四个是位置
//        for(int i=0;i<7;i++){
//            for(int j=0;j<5;j++){
//                System.out.print(yansezhonglei[i][j]);
//            }
//            System.out.println();
//        }

        return yansezhonglei;

    }


    public static int lengthofqipan(int[][] qipan){
        int changdu=0;
        for(int i=0;i<9;i++){
            if(qipan[0][i]==-1){
                changdu+=1;
            }
        }
        changdu=9-changdu;
        return changdu;
    }
}
