package test.lintcode.day1;

/**
 * Created by lee on 18/5/1.
 */
public class BitAdd {

    //给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
    public static void main(String[] args){

        System.out.println("add的运算结果是:"+aplusb(6, 8));
    }

    public static int aplusb(int a, int b){
        //System.out.println("2进制(a+b)的被加数" + a + ":" + Integer.toBinaryString(a));
        //System.out.println("2进制(a+b)的加数" + b + ":" + Integer.toBinaryString(b));
        //System.out.println();

        int sum = a^b;  //a异或b的值是2进制(a+b)没有进位的结果.
        //System.out.println("2进制(a+b)未进位的和:" + Integer.toBinaryString(sum));

        int carryBitSum = (a&b) << 1;   //a&b的值再向左移一位是2进制(a+b)哪些位需要进位的记录.
        //System.out.println("2进制(a+b)进位的标志:" + Integer.toBinaryString(carryBitSum));
        if(carryBitSum == 0){   //如果进位标志=0,证明a异或b没有进行进位,即a异或b的值就是2进制(a+b)的结果.
            return sum;
        }else{                  //如果有进位,则将相应位需要进位的1加到a异或b结果的相应位上,再次运算,直到没有进位.
          return aplusb(sum, carryBitSum);
        }
    }
}
