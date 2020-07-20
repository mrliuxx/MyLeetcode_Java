package test.lintcode.day1;

/**
 * Created by lee on 18/5/1.
 */
public class EndZero {

    //设计一个算法，计算出n阶乘中尾部零的个数
    public static void main(String[] args){

        System.out.println("结果:"+trailingZeros(25));
    }

    //易分析得阶乘结果的尾部0都是由5以及5的倍数,与2以及2的倍数相乘得到的,且5的前面已经含有2和4,所以只需要以5为步长进行分析.
    public static long trailingZeros(long n){
        long count = 0;

        while (n > 4){
            count += n / 5; //得到5的以及5的倍数,分别为尾部提供一个0;
            n = n/5;        //然后将数值除以5,进入循环再求25(5^2)以及其倍数,分别提供两个0且第一个0已经在5的倍数的计算中累加过了;
        }                   //以此类推,求5^x以及其倍数,分别提供x个0且前x-1个0已经在之前(x-1)次的计算中累加过了.

        return count;
    }
    //如果是101，则101之前应该是5,10,15,20,...,95,100共101/5=20个数字满足要求;
    //
    //将这些数字化成5*(1、2、3、4、5、...)的形式，内部的1、2、3、4、5、...又满足上面的分析：每5个数字有一个是5的倍数;
    //...、25、...、50、...、75、...、100、...、125、...
    //它们都满足相乘后产生至少两个0，且在第一次5*k分析中已经统计过一次。
    //
    //.................


}