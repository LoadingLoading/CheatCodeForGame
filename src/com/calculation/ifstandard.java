package com.calculation;

public class ifstandard {
    public static int[] yansegeshu=new int[7];
    public static int ifstandard(int[][] qipan){
        for(int i = 0;i<7;i++){
            yansegeshu[i]=0;
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(qipan[i][j]!=-1) {
                    yansegeshu[qipan[i][j]] += 1;
                }
            }
        }
        int judge=1;
        for(int i=1;i<7;i++){
            if(yansegeshu[i]!=0&&yansegeshu[i]!=2){
                judge= 0;
            }
        }
        return judge;

    }

}
