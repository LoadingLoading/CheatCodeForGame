package com.calculation;

public class cheatcode {
    //RoadForEachColor表示每种颜色的每种路径
    //第一个数0不表示啥，1～6表示6种颜色
    //第二个数是表示当前颜色的路径数，0表示第一条路径，1表示第二条，2第三条，3第四，4五
    //第三个数表示这个路径的节点数，0表示第一个节点，1表示第二个
    //第三个数表示这个节点的位置，0是i，1是j
    static int[][][][] RoadForEachColor=new int[7][][][];

    public static int[][] cheatcode(int[][] qipan){
        //理论上分为4部
        //1 找到有哪几个颜色
        //whichcolors
        //2 为每个颜色找到所有可能的路径
        //3 相互匹配 1长度相加为面积    2没有相同项
        //4 1将匹配到的加入数组并返回 2返回说做不出来，没有匹配项

        //1 找到有哪几个颜色
        //颜色种类[a][b] a是1到6代表不同颜色，b为0的时候的值代表有没有这个数的存在，b是1到4 代表起点到ij和终点到ij
        int[][] yansezhonglei=whichcolors.whichcolors(qipan);

        int lengthofqipan=whichcolors.lengthofqipan(qipan);


        //System.out.println(lengthofqipan);

        //2 为每个颜色找到所有可能的路径
        for(int i=1;i<7;i++){
            //System.out.println(i+"每一种颜色的个数："+yansezhonglei[i][0]);
            if(yansezhonglei[i][0]==2){





                RoadForEachColor[i]=roads.Roads(qipan,yansezhonglei,i);
                if(RoadForEachColor[i][0]==null){
                   // System.out.println(i+"这种颜色的路径有多少条："+RoadForEachColor[i].length);
                    RoadForEachColor[i]=null;
                }else{
                    System.out.println(i+"这种颜色的路径有多少条："+RoadForEachColor[i].length);
                }

            }else{
                RoadForEachColor[i]=null;

            }
        }

        //3 将RoadForEachColor 加入方法，得到一个棋盘或者得到失败
        int[][] zuizhongjieguo=huxiangpipei.huxiangpipei(RoadForEachColor,lengthofqipan);

        return zuizhongjieguo;
    }
}
