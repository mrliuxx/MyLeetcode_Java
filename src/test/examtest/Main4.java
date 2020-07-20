package test.examtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by lee on 18/5/12.
 *
 * 笔试编程:输入面试者的个数n(0~n-1自动编号为1~n),再输入一组m个筛选数字A1~Am(一般无序).
 *要求:拿到A1,根据A1的值从0号(编号为1)同学开始数A1个数,将轮到的同学淘汰(下次数的时候不再参与),
 * 然后拿到A2(按下标顺序拿取),再从被淘汰同学的下一位开始数A2个数,将轮到的同学淘汰......
 * 循环n-1次,直到只剩下一个同学位置,将最后这个同学的下标(或编号)输出.
 *
 */
public class Main4 {

    //面试者编号列表循环数数,筛选数字列表循环顺序拿取.所以考虑都采用循环列表操作.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //填充面试者编号列表,里面数据为原始列表下标.
        int n = scanner.nextInt();
        List<Integer> nNumber = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            nNumber.add(i);
        }

        //填充筛选数字列表,里面数据为用户输入
        int m = scanner.nextInt();
        int[] mParam = new int[m];
        for(int i=0; i<mParam.length; i++){
            mParam[i]  = scanner.nextInt();
        }

        int numberIndex = 0;    //指向数数的第一个人,即起始位置.
        int paramIndex = 0;     //指向当前拿取的数字的位置.
        int tmpParam;           //存储当前拿取的数字
        while(nNumber.size() > 1){
            //将筛选数字下标进行模运算,代表循环拿取数字.
            tmpParam = mParam[paramIndex % mParam.length];

            //计算从起始位置(numberIndex)数tmpParam个数之后,到达的位置即应该移除的位置.(进行模运算代表循环数编号列表)
            numberIndex = (numberIndex + tmpParam-1) % nNumber.size();
            nNumber.remove(numberIndex);        //移除找到的那个元素.现在指针指向的是被删元素的下一个元素,即下一次数数的起始位置.
            //但是若被删的是最后一个元素,应该将下一次数数的起始位置变为0.
            if(numberIndex == nNumber.size()+1){
                numberIndex = 0;
            }

            paramIndex++;
        }

        //将仅存的一个元素输出,输出的值为原始编号列表的下标位置.
        System.out.print(nNumber.get(0));
    }
}
