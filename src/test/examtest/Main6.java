package test.examtest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lee on 18/5/12.
 */
public class Main6 {

    //有n个数，两两组成二元组，差最小的有多少对呢？差最大的呢？
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNext("#EOF")){
            int countNum = scanner.nextInt();
            int[] numbers = new int[countNum];
            for(int i=0; i<numbers.length; i++){
                numbers[i] = scanner.nextInt();
            }

            Arrays.sort(numbers);
            int countLittle = 0;
            int countMax;

            int littleIndexHead = 0;
            int littleStep = 1;//默认排序好的数组中,相邻两个元素的差才是最小的.
            int tmpLittle = numbers[littleIndexHead + littleStep]-numbers[littleIndexHead];
            //////还有缺陷,还应该处理超过两个的数相等的情况.n个数相等有C-n-2中情况.
            for(; littleIndexHead<numbers.length-1; littleIndexHead++){
                if(tmpLittle == numbers[littleIndexHead + littleStep]-numbers[littleIndexHead]){
                    countLittle ++;
                }else{
                    if(tmpLittle > numbers[littleIndexHead + littleStep]-numbers[littleIndexHead]){

                        tmpLittle = numbers[littleIndexHead + littleStep]-numbers[littleIndexHead];
                        countLittle = 0;
                    }
                }
            }

            //默认排序好的数组中,只有队头和队尾两个元素的差才是最大的.
            int maxIndexHead = 0;
            int maxIndexEnd = numbers.length-1;
            int countHead = 1;  //记录开头最小元素相同个数
            int countEnd = 1;   //记录结尾最大元素相同个数
            while(true){
                if(numbers[maxIndexHead] == numbers[++maxIndexHead]){
                    countHead ++;
                }else if(numbers[maxIndexEnd] == numbers[--maxIndexEnd]){
                    countEnd ++;
                }else{
                    countMax = countHead * countEnd;
                    break;
                }
            }

            //////还有缺陷,还应该处理所有数都一样的情况.
            System.out.println(countLittle + " " + countMax);
        }

    }
}
