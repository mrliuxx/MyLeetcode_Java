package test.examtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/11.
 *
 * 笔试编程:n个客服分成n/2组,然后输入每个客服与其他组客服存在的冲突冲突关系.
 * 要求每天需要每组出一个客服值班,求是否存在可行方案.
 * (用标准输入输出)
 *
 */
public class Main1 {

//    //System.in.read()一次只读入一个字节数据，而我们通常要取得一个字符串或一组数字
//    //System.in.read()返回一个整数
//    //必须初始化
//    //int read = 0;
//    char read = '0';
//    System.out.println("输入数据：");
//    try {
//        //read = System.in.read();
//        read = (char) System.in.read();
//    }catch(Exception e){
//        e.printStackTrace();
//    }
//    System.out.println("输入数据："+read);
    public static void main(String[] args){
        try{
            char countGroupStr = (char)System.in.read();
            int[] group = new int[Integer.valueOf(countGroupStr+"")*2];
            group[0] = 1;
            for(int i=1; i<group.length; i++){
                group[i] = group[i-1]+1;
            }

            System.in.read();
            char countRelationStr = (char)System.in.read();
            String[] relation = new String[Integer.valueOf(countRelationStr+"")];

            System.in.read();
            for(int i=0; i<relation.length; i++){
                byte[] b=new byte[3];
                System.in.read(b);
                relation[i] = new String(b);

                //System.out.println("str="+relation[i]+"=");
                System.in.read();
            }

            //标识是否存在合理方案
            boolean result1 = true;
            boolean result2 = true;
            for(int i=0; i<group.length; i=i+2){
                int tmpNum1 = group[i];
                int tmpNum2 = group[i+1];

                //将客服i和客服i+1(一个组的两个成员)对应的所有冲突关系找出来,并将与其冲突的客服编号存入列表.
                List<Integer> conflict1 = new ArrayList<Integer>();
                List<Integer> conflict2 = new ArrayList<Integer>();
                for(int j=0; j<relation.length; j++) {
                    String[] tmpRel = relation[j].split(",");
                    int tmpRelNum1 = Integer.valueOf(tmpRel[0]);
                    int tmpRelNum2 = Integer.valueOf(tmpRel[1]);

                    if (tmpNum1 == tmpRelNum1) {
                        conflict1.add(tmpRelNum2);
                    } else if ((tmpNum1 == tmpRelNum2)) {
                        conflict1.add(tmpRelNum1);
                    }

                    if (tmpNum2 == tmpRelNum1) {
                        conflict2.add(tmpRelNum2);
                    } else if ((tmpNum2 == tmpRelNum2)) {
                        conflict2.add(tmpRelNum1);
                    }
                }

                //遍历客服编号数组,判断某组的两个成员是否都存在于客服i的冲突列表中,若都存在,则一定找不到客服i的合理方案.
                for(int k=0; k<group.length-1; k=k+2) {
                    if(conflict1.contains(group[k]) && conflict1.contains(group[k+1])) {
                        result1 = false;
                    }

                    //接下来应该判断客服i的另一个伙伴的冲突情况,若两人都有与某个小组全部冲突的情况,则一定找不到两人所在小组分配的合理方案.
                    if(conflict2.contains(group[k]) && conflict2.contains(group[k+1])) {
                        result2 = false;
                    }
                }

                if(!result1 && !result2) {
                    break;
                }
            }

            if(result1 || result2){
                System.out.print("yes");
            }else{
                System.out.print("no");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
