package com.calculation;

public class roads {
    static int[] shimoweizhi;

    static int[][] road;
    static int jishuqi;
    static int time=0;
    static int[][][] roads=new int[1][][];
    static int[][][] huitoulu=new int[9][9][4];//前两个表示棋盘的ij，第三个表示该点的上右下左有没有被走过，如果是1表示被走过，如果是0表示没被走过
    static int qipanchangdu;

    static int[][] shimoofevery=new int[7][5];
    static int yanseofevery;

    static int[][] qipanofeverytime=new int[9][9];
    public static int[][][] Roads(int[][] qipan,int[][] shimoweizhifrom,int yanse){

        shimoofevery=shimoweizhifrom;
        yanseofevery=yanse;

        qipanchangdu=0;
        for(int i=0;i<9;i++){
            if(qipan[0][i]==-1){
                qipanchangdu=i;
                break;
            }
        }
        if(qipanchangdu==0){
            qipanchangdu=9;
        }

        //初始化roads
        int [][][] chushihuaroads=new int[1][][];
        roads=chushihuaroads;

        //好像qipandaiti是一个全局变量，无论在哪都会改变
        int[][] qipandaiti=new int[9][9];
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                qipandaiti[i][j]=qipan[i][j];
                //System.out.print(qipan[i][j]);
            }//System.out.println();
        }







        //shimoweizhi[b] b为0的时候的值代表有没有这个数的存在，b是1到4 代表起点到ij和终点到ij
        //下面初始化起点
        int[][] lastnode=new int[1][2];

        //下面初始化当前位置
        int[] dangqiandeweizhi=new int[2];
        shimoweizhi=shimoweizhifrom[yanse];//全局变量，可以在其他方法中使用


        dangqiandeweizhi[0]=shimoweizhi[1];
        dangqiandeweizhi[1]=shimoweizhi[2];

        //起点就是现在到当前位置
        //lastnode[0]=dangqianweizhi;
        //刚刚这行代码会使得所有到lastnode全部变成当前位置，真的出鬼了，我都搞不懂为什么
        lastnode[0][0]=shimoweizhifrom[yanse][1];
        lastnode[0][1]=shimoweizhifrom[yanse][2];

        //下面初始化棋盘的回头路
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                for(int a=0;a<4;a++){
                    if(qipandaiti[i][j]==-1){
                        huitoulu[i][j][a]=-1;
                    }else {
                        huitoulu[i][j][a] =0;
                    }
                }
            }
        }

        //通过函数获得roadss的结果
        //int[][][] roadss=
        time=0;
        oneroad(qipandaiti,dangqiandeweizhi,yanse,lastnode,0);
        System.out.println(yanse+"运行了多少次："+time);
        //检验结果，会分行打印出每一条路径
        System.out.println();
        System.out.println("最终的结果是：");
        if(roads[0]==null){
            System.out.println("没有找到一条符合条件的路径");
        }else {
            System.out.println(roads.length);
            System.out.println(roads[0].length);
            for (int i = 0; i < roads.length; i++) {

                for (int j = 0; j < roads[i].length; j++) {
                    System.out.print(roads[i][j][0] + "," + roads[i][j][1] + "  ");
                }
                System.out.println();
            }
        }
        return roads;
    }

    public static /*int[][][]*/void oneroad(int[][] qipandaiti,int[] dangqianweizhi,int yanse,int[][] lastnode,int tuihuishibutianjia){
        time+=1;
        //System.out.println("第几次运行："+time);

//        System.out.println("lastword :");
//        for(int i=0;i<lastnode.length;i++){
//            System.out.print(lastnode[i][0]+", "+lastnode[i][1]+"  ;  ");
//        }


        //打印棋盘
//            for(int i=0;i<9;i++){
//                for(int j=0;j<9;j++){
//                    System.out.print(qipandaiti[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();



//        int[] aviable=new int[5];
//        aviable[0]=-1;
//        aviable[1]=0;
//        aviable[2]=0;
//        aviable[3]=0;
//        aviable[4]=0;
        int[] aviable;

//        int[] tryr=new int[2];
//        tryr[0]=2;
//        tryr[1]=2;
        aviable=judgeaviable(qipandaiti,dangqianweizhi,yanse);
        //这里会得到一个长度为5的list 前面4个分别代表 上右下左 0表示不行，1 代表可以
        //第五个用于表示结束点，-1表示没有，0～3表示 在 上右下左中的哪个
        if(aviable[4]!=-1){//表示有结束点 添加
            int[] jieshudian=new int[2];
            jieshudian[0]=shimoweizhi[3];
            jieshudian[1]=shimoweizhi[4];
            //添加结束点到road里
            //lastnode其实就是road
            if(aviable[4]==0){
                //qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=yanse;//把当前位置添加到棋盘里
                //dangqianweizhi[0]-=1;//把当前位置移到上面一格
                lastnode=extended(lastnode,jieshudian);;//刷新节点位置

            }
            if(aviable[4]==1){

               // qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=yanse;//把当前位置添加到棋盘里
                //dangqianweizhi[1]+=1;//把当前位置移到右面一格
                lastnode=extended(lastnode,jieshudian);//刷新节点位置

            }
            if(aviable[4]==2){
                //qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=yanse;//把当前位置添加到棋盘里
                //dangqianweizhi[0]+=1;//把当前位置移到下面一格
                lastnode=extended(lastnode,jieshudian);//刷新节点位置

            }
            if(aviable[4]==3){
               // qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=yanse;//把当前位置添加到棋盘里
                //dangqianweizhi[1]-=1;//把当前位置移到左面一格
                lastnode=extended(lastnode,jieshudian);//刷新节点位置

            }
        //这里有个去重问题
            //利用方法将lastnode 扩充到roads的最后一个
            //roads = extendedroads(roads, lastnode);
            //System.out.println("退回时不加的值为："+tuihuishibutianjia);
            if(tuihuishibutianjia==0) {
               // System.out.println("符合条件，储存,刚刚将lastnode储存完毕");
                roads = extendedroads(roads, lastnode);
            }


            //System.out.print("lastnode changdu :"+extend.length);

//            jishuqi+=1;
//            System.out.print(jishuqi+" "+aviable[4]+"  ,  ");

            //打印棋盘
//            for(int i=0;i<9;i++){
//                for(int j=0;j<9;j++){
//                    System.out.print(qipandaiti[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            //打印路径
            //for(int i=0;i<roads.length;i++){
//                for(int j=0;j<roads[roads.length-1].length;j++){
//                    System.out.print(roads[roads.length-1][j][0]+","+roads[roads.length-1][j][1]+"  ");
//                }
//                System.out.println();
            //}
            //System.out.println();
//            System.out.println();


            //dangqianweizhi=lastnode[lastnode.length-1];//把当前位置移到前面一格
            lastnode=pop(lastnode);//去掉最后一个节点


            //添加road到roads里
        }
        //上面这个括号是个大的if，用于在终点旁边时自动添加
        if(time>=2300){
            System.out.println("可能性太多，该种颜色并未计算完全，但大部分已经计算完成");
        }
        else if(aviable[0]==1){
           //System.out.print(dangqianweizhi[0]+dangqianweizhi[1]);
//           qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=yanse;//把当前位置添加到棋盘里
//            //qipandaiti[0][1]=yanse;
//            dangqianweizhi[0]-=1;//把当前位置移到上面一格
//            int[][] exchange = lastnode;
//            lastnode=extended(exchange,dangqianweizhi);//刷新节点位置
//            System.out.print("0");
//            oneroad(qipandaiti,dangqianweizhi,yanse,lastnode);


            //System.out.println("往上走一格："+(dangqianweizhi[0]-1)+" ,"+dangqianweizhi[1]);
            int[] exchangedangqianweizhi=new int[2];
            exchangedangqianweizhi[0]=dangqianweizhi[0]-1;
            exchangedangqianweizhi[1]=dangqianweizhi[1];

            qipandaiti[dangqianweizhi[0]-1][dangqianweizhi[1]]=yanse;
            lastnode=extended(lastnode,exchangedangqianweizhi);


            oneroad(qipandaiti,exchangedangqianweizhi,yanse,lastnode,0);
        }
        else if(aviable[1]==1){

            //int p=dangqianweizhi[1];
            //System.out.println("之前lastword caocaocaocao:");

            //System.out.println("往右走一格");
            int[] exchangedangqianweizhi=new int[2];
            exchangedangqianweizhi[0]=dangqianweizhi[0];
            exchangedangqianweizhi[1]=1+dangqianweizhi[1];
//            int[][] exchangelastnode=new int[lastnode.length][];
//            exchangelastnode=copy(exchangelastnode,lastnode);
//            for(int i=0;i<exchangelastnode.length;i++){
//                System.out.print(exchangelastnode[i][0]+", "+exchangelastnode[i][1]+"  ;  ");
//            }


            //dangqianweizhi[1]=p+1;//把当前位置移到右面一格



//            lastnode=exchangelastnode;
//            System.out.println("之后lastwordcaocaocaocao :");
//            for(int i=0;i<exchangelastnode.length;i++){
//                System.out.print(exchangelastnode[i][0]+" , "+exchangelastnode[i][1]+"  ;  ");
//            }

            qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]+1]=yanse;//把当前位置添加到棋盘里

            //System.out.print(dangqianweizhi[1]);

            //int[][] exchange = lastnode;


            lastnode=extended(lastnode,exchangedangqianweizhi);
            //lastnode[lastnode.length+1]=dangqianweizhi;//刷新节点位置
            //System.out.print("1");

//            System.out.println("之后lastword :");
//            for(int i=0;i<lastnode.length;i++){
//                System.out.print(lastnode[i][0]+", "+lastnode[i][1]+"  ;  ");
//            }


            oneroad(qipandaiti,exchangedangqianweizhi,yanse,lastnode,0);
        }
        else if(aviable[2]==1){

//            qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=yanse;//把当前位置添加到棋盘里
//            dangqianweizhi[0]+=1;//把当前位置移到下面一格
//            lastnode=extended(lastnode,dangqianweizhi);//刷新节点位置
            //System.out.print(dangqianweizhi[0]+" "+dangqianweizhi[1]+",  ");

            //System.out.println("往下走一格");
            int[] exchangedangqianweizhi=new int[2];
            exchangedangqianweizhi[0]=1+dangqianweizhi[0];
            exchangedangqianweizhi[1]=dangqianweizhi[1];

            qipandaiti[dangqianweizhi[0]+1][dangqianweizhi[1]]=yanse;
            lastnode=extended(lastnode,exchangedangqianweizhi);


            oneroad(qipandaiti,exchangedangqianweizhi,yanse,lastnode,0);
        }
        else if(aviable[3]==1){
//            qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=yanse;//把当前位置添加到棋盘里
//            dangqianweizhi[1]-=1;//把当前位置移到左面一格
//            lastnode=extended(lastnode,dangqianweizhi);//刷新节点位置
//            System.out.print("3");


            //System.out.println("往左走一格");
            int[] exchangedangqianweizhi=new int[2];
            exchangedangqianweizhi[0]=dangqianweizhi[0];
            exchangedangqianweizhi[1]=dangqianweizhi[1]-1;

            qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]-1]=yanse;
            lastnode=extended(lastnode,exchangedangqianweizhi);


            oneroad(qipandaiti,exchangedangqianweizhi,yanse,lastnode,0);
        }

        else if(aviable[0]==0&&aviable[1]==0&&aviable[2]==0&&aviable[3]==0&&lastnode.length!=1){//失败路径,并且没有回到原点
            qipandaiti[dangqianweizhi[0]][dangqianweizhi[1]]=0;//把当前位置清除
            //System.out.println("清除了："+dangqianweizhi[0]+" ,"+dangqianweizhi[1]);

            //下面四个表示哪一条路已经走过了，会在judgeaviable里面用到，让走过的路不能再被走
//            System.out.println(yanse);
//            for(int i=0;i<9;i++){
//                for (int j=0;j<9;j++){
//                    System.out.print(qipandaiti[i][j]);
//                }System.out.println();
//            }


            if(dangqianweizhi[0]==lastnode[lastnode.length-2][0]-1){//上
                //System.out.println(dangqianweizhi[0]+","+dangqianweizhi[1]+ " 在 "+ lastnode[lastnode.length-2][0]+" , "+lastnode[lastnode.length-2][1]+"的上面，不会再走了");
                huitoulu[lastnode[lastnode.length-2][0]][lastnode[lastnode.length-2][1]][0]=1;
            }
            if(dangqianweizhi[1]==lastnode[lastnode.length-2][1]+1){//右
                //System.out.println(dangqianweizhi[0]+","+dangqianweizhi[1]+ " 在 "+ lastnode[lastnode.length-2][0]+" , "+lastnode[lastnode.length-2][1]+"的右面，不会再走了");
                huitoulu[lastnode[lastnode.length-2][0]][lastnode[lastnode.length-2][1]][1]=1;
            }
            if(dangqianweizhi[0]==lastnode[lastnode.length-2][0]+1){//下
               //System.out.println(dangqianweizhi[0]+","+dangqianweizhi[1]+ " 在 "+ lastnode[lastnode.length-2][0]+" , "+lastnode[lastnode.length-2][1]+"的下面，不会再走了");
                huitoulu[lastnode[lastnode.length-2][0]][lastnode[lastnode.length-2][1]][2]=1;
            }
            if(dangqianweizhi[1]==lastnode[lastnode.length-2][1]-1){//左
                //System.out.println(dangqianweizhi[0]+","+dangqianweizhi[1]+ " 在 "+ lastnode[lastnode.length-2][0]+" , "+lastnode[lastnode.length-2][1]+"的左面，不会再走了");
                huitoulu[lastnode[lastnode.length-2][0]][lastnode[lastnode.length-2][1]][3]=1;
            }

            for(int i=0;i<4;i++) {
                huitoulu[dangqianweizhi[0]][dangqianweizhi[1]][i]=0;
            }

            dangqianweizhi=lastnode[lastnode.length-2];//把当前位置移到前面一格
            lastnode=pop(lastnode);//去掉最后一个节点

            //System.out.println("去掉最后一个，回到前一格");
            //tuihuishibutianjia=1;
            oneroad(qipandaiti,dangqianweizhi,yanse,lastnode,1);
        }

        if(aviable[0]==0&&aviable[1]==0&&aviable[2]==0&&aviable[3]==0&&lastnode.length==1) {//失败路径,并且回到原点
            //return roads;
        }
        //return roads;
    }



    //这个方法会返回一个一维数组，0～3表示上右下左到可行性，值为0为不可以，值为1为可以；4表示周围有无终点，值为0～3表示上右下左，值为-1表示没有
    public static int[] judgeaviable(int[][] qipandaiti,int[] dangqianweizhi,int yanse){
        //初始化aviable的值，默认是都不可以且没有终点
        int[] aviable=new int[5];
        for(int i=0;i<4;i++){
            aviable[i]=0;
        }
        aviable[4]=-1;


//        System.out.println("变化之前钱钱钱");
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                System.out.print(qipandaiti[i][j]+" ");
//            }
//            System.out.println();
//        }System.out.println();

        //System.out.println("当前位置是："+dangqianweizhi[0]+" , "+dangqianweizhi[1]+"    ,棋盘长度是："+qipanchangdu);

        if(dangqianweizhi[0]!=0) {//第一个条件是不在上边界，只有这样才能查看向上位置的情况
            if (qipandaiti[dangqianweizhi[0] - 1][dangqianweizhi[1]] == 0&&huitoulu[dangqianweizhi[0]][dangqianweizhi[1]][0]==0) {//上为空，且上非走过的
                aviable[0] = 1;
            }
            if (dangqianweizhi[0] - 1 ==shimoweizhi[3]  &&  dangqianweizhi[1] ==shimoweizhi[4]) {//上为终点
                aviable[4] = 0;
                //System.out.print(qipandaiti[dangqianweizhi[0]-1][dangqianweizhi[1] ]+ ","+(dangqianweizhi[0]-1)+","+(dangqianweizhi[1]  )+"   ;   ");
            }
        }

        if(dangqianweizhi[1]!=qipanchangdu-1) {
            if (qipandaiti[dangqianweizhi[0]][dangqianweizhi[1] + 1] == 0&&huitoulu[dangqianweizhi[0]][dangqianweizhi[1]][1]==0) {//右为空
                aviable[1] = 1;
            }
            if (dangqianweizhi[0] ==shimoweizhi[3]  &&  dangqianweizhi[1] +1==shimoweizhi[4]) {//右为终点
                aviable[4] = 1;
            }
        }

        if(dangqianweizhi[0]!=qipanchangdu-1) {
            if (qipandaiti[dangqianweizhi[0] + 1][dangqianweizhi[1]] == 0&&huitoulu[dangqianweizhi[0]][dangqianweizhi[1]][2]==0) {//下为空
                //System.out.println((dangqianweizhi[0] + 1)+" "+(dangqianweizhi[1])+"这个点为空，在当前点的下面");
                aviable[2] = 1;
            }
            if (dangqianweizhi[0] + 1 ==shimoweizhi[3]  &&  dangqianweizhi[1] ==shimoweizhi[4]) {//下为终点
                aviable[4] = 2;
            }
        }

        if(dangqianweizhi[1]!=0) {
            if (qipandaiti[dangqianweizhi[0]][dangqianweizhi[1] - 1] == 0&&huitoulu[dangqianweizhi[0]][dangqianweizhi[1]][3]==0) {//左为空
                aviable[3] = 1;
            }
            if (dangqianweizhi[0] ==shimoweizhi[3]  &&  dangqianweizhi[1] - 1 ==shimoweizhi[4]) {//左为终点
                aviable[4] = 3;
//                System.out.print(qipandaiti[dangqianweizhi[0]][dangqianweizhi[1] - 1]+ " "+dangqianweizhi[0]+" "+(dangqianweizhi[1] - 1)+"   ,   ");
            }
        }

//        System.out.println("变化之前钱钱钱");
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                System.out.print(qipandaiti[i][j]+" ");
//            }
//            System.out.println();
//        }System.out.println();

        int[][] gaibiandea=new int[9][9];
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                gaibiandea[i][j]=qipandaiti[i][j];
                qipanofeverytime[i][j]=qipandaiti[i][j];
            }
        }


        for(int j=1;j<7;j++) {//对每一种颜色进行判断
            //System.out.println("此时将要判断是否交叉");
            if(shimoofevery[j][0]==2&&j!=yanseofevery) {
                //System.out.println("此时将要判断是否交叉");
                int[] dangqianofevery=new int[2];
                dangqianofevery[0]=shimoofevery[j][1];
                dangqianofevery[1]=shimoofevery[j][2];
                int[] zhongdian=new int[2];
                zhongdian[0]=shimoofevery[j][3];
                zhongdian[1]=shimoofevery[j][4];
                if (isContact( dangqianofevery,zhongdian) == 0) {
                    //System.out.println("此时交叉，不满足条件 退回");
                    for (int i = 0; i < 4; i++) {
                        aviable[i] = 0;
                    }
                    aviable[4] = -1;
                }
            }
            if(j==yanseofevery){//对当前颜色进行判断
                int[] zhongdian=new int[2];
                zhongdian[0]=shimoweizhi[3];
                zhongdian[1]=shimoweizhi[4];
                if (isContact( dangqianweizhi,zhongdian) == 0) {
                    //System.out.println("不满足条件 退回");
                    for (int i = 0; i < 4; i++) {
                        aviable[i] = 0;
                    }
                    aviable[4] = -1;
                }
            }
        }
        return aviable;
    }

    public static int isContact(int[] dangqianweizhi,int[] zhongdian){
        int isContact=0;
//        System.out.println("变化之前");
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                System.out.print(gaibiande[i][j]+" ");
//            }
//            System.out.println();
//        }System.out.println();

        int[][] bianhuade;

        bianhuade=bianhua(zhongdian);
        if(dangqianweizhi[0]!=0) {//第一个条件是不在上边界，只有这样才能查看向上位置的情况
            if (bianhuade[dangqianweizhi[0] - 1][dangqianweizhi[1]] == 10) {//上为空，且上非走过的
                isContact = 1;
                //System.out.println(dangqianweizhi[0]+" "+dangqianweizhi[1]+" 上面接触空");
            }

        }

        if(dangqianweizhi[1]!=qipanchangdu-1) {
            if (bianhuade[dangqianweizhi[0]][dangqianweizhi[1] + 1] == 10) {//右为空
                isContact = 1;
                //System.out.println(dangqianweizhi[0]+" "+dangqianweizhi[1]+" 右边接触空");
            }

        }

        if(dangqianweizhi[0]!=qipanchangdu-1) {
            if (bianhuade[dangqianweizhi[0] + 1][dangqianweizhi[1]] == 10) {//下为空
                isContact = 1;
                //System.out.println(dangqianweizhi[0]+" "+dangqianweizhi[1]+" 下面接触空");
            }

        }

        if(dangqianweizhi[1]!=0) {
            if (bianhuade[dangqianweizhi[0]][dangqianweizhi[1] - 1] == 10) {//左为空
                isContact = 1;
                //System.out.println(dangqianweizhi[0]+" "+dangqianweizhi[1]+" 左边接触空");
            }

        }
//        System.out.println();
//        System.out.println(" isContact 为"+isContact);
        return isContact;
    }

    public static int[][] bianhua(int[] zhongdian){
        //原理就是终点设为11，所有11旁边的0都会变成12，所有12都会变成11，所有11都会变成10，这样可以将只要没有11，这样就可以找出所有的可以接触的点了


        int[][] bianhuade=new int[9][9];
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                bianhuade[i][j]=qipanofeverytime[i][j];

            }
        }


        int p=1;
        bianhuade[zhongdian[0]][zhongdian[1]]=13;

//        System.out.println("变化之前");
//        for(int i=0;i<5;i++){
//            for(int j=0;j<5;j++){
//                System.out.print(bianhuade[i][j]+" ");
//            }
//            System.out.println();
//        }System.out.println();

        do{
            int jieshu=0;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    int[] dangqianweizhi=new int[2];
                    dangqianweizhi[0]=i;
                    dangqianweizhi[1]=j;
                    if(bianhuade[dangqianweizhi[0]][dangqianweizhi[1]] == 11||bianhuade[dangqianweizhi[0]][dangqianweizhi[1]] == 13) {
                        if (dangqianweizhi[0] != 0) {//第一个条件是不在上边界，只有这样才能查看向上位置的情况
                            if (bianhuade[dangqianweizhi[0] - 1][dangqianweizhi[1]] == 0) {//上为空，且上非走过的
                                bianhuade[dangqianweizhi[0] - 1][dangqianweizhi[1]] =12;
                            }

                        }

                        if (dangqianweizhi[1] != qipanchangdu-1) {
                            if (bianhuade[dangqianweizhi[0]][dangqianweizhi[1] + 1] == 0 ) {//右为空
                                bianhuade[dangqianweizhi[0]][dangqianweizhi[1] + 1] =12;
                            }

                        }

                        if (dangqianweizhi[0] != qipanchangdu-1) {
                            if (bianhuade[dangqianweizhi[0] + 1][dangqianweizhi[1]] == 0 ) {//下为空
                                bianhuade[dangqianweizhi[0] + 1][dangqianweizhi[1]] =12;
                            }

                        }
//System.out.println(qipanchangdu);
                        if (dangqianweizhi[1] != 0) {
                            if (bianhuade[dangqianweizhi[0]][dangqianweizhi[1] - 1] == 0 ) {//左为空
                                bianhuade[dangqianweizhi[0]][dangqianweizhi[1] - 1] =12;
                            }

                        }
                    }
                }
            }

            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){


                    if(bianhuade[i][j] == 11||bianhuade[i][j] == 13){
                        bianhuade[i][j]  =10;
                    }

                    if(bianhuade[i][j] == 12){
                        bianhuade[i][j] =11;
                    }
                    if(bianhuade[i][j] == 11){
                        jieshu+=1;
                    }




                }
            }

//            for(int i=0;i<5;i++){
//                for(int j=0;j<5;j++){
//                    System.out.print(bianhuade[i][j]+" ");
//                }
//                System.out.println();
//
//            }System.out.println(" jieshuwei:"+jieshu);

//            for(int i=0;i<5;i++){
//                for(int j=0;j<5;j++){
//
//
//
//                    if(bianhuade[i][j] == 11){
//                        jieshu+=1;
//                    }
//
//                }
//            }

            p=jieshu;
        }while(p!=0);

//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                System.out.print(bianhuade[i][j]+" ");
//            }
//            System.out.println();
//        }
        return bianhuade;

    }






    public static int[][] pop(int[][] lastnode){
        int[][] lastnodepop=new int[lastnode.length-1][2];
        for(int i=0;i<lastnode.length-1;i++){
            lastnodepop[i]=lastnode[i];
        }
        //下面检测pop函数正确性
        //System.out.println("pop:"+lastnode.length+" ,"+lastnodepop.length+"    ;  ");
        return lastnodepop;
    }

    public static int[][] extended(int[][] lastnode,int[] dangqianweizhi){
//        System.out.print("本来到lastnode是："+lastnode.length+"长度");
//        for(int i=0;i<lastnode.length;i++){
//            System.out.print(lastnode[i][0]+ ",,"+ lastnode[i][1]+"      ");
//        }System.out.println();
//        System.out.println("要增加到位置是："+ dangqianweizhi[0]+","+dangqianweizhi[1]);

        int[][] extend=new int[lastnode.length+1][2];
        extend[lastnode.length] = dangqianweizhi;
        System.arraycopy(lastnode, 0, extend, 0, lastnode.length);
        //System.out.print("lastnode changdu :"+extend.length);

//        System.out.print("已经增加完毕到lastnode 是 :");
//        for(int i=0;i<extend.length;i++){
//            System.out.print(extend[i][0]+ ",,"+ extend[i][1]+"      ");
//        }System.out.println();
        return extend;
    }

    public static int[][][] extendedroads(int[][][] roads,int[][] lastnode){
        //System.out.println("添加到roads里面的lastnode  :");
//        for(int i=0;i<lastnode.length;i++){
//            System.out.print(lastnode[i][0]+ " "+ lastnode[i][1]);
//        }System.out.println();
        if(roads[0]==null){
            int[][][] extendroad = new int[1][][];
            extendroad[0]=lastnode;
            return extendroad;
        }else {
            int[][][] extendroad = new int[roads.length + 1][][];

            extendroad[roads.length] = lastnode;
            System.arraycopy(roads, 0, extendroad, 0, roads.length);
            return extendroad;
        }
    }

}
