package test.lintcode.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/5.
 */
public class FizzBuzz {
    /*  给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

        如果这个数被3整除，打印fizz.
        如果这个数被5整除，打印buzz.
        如果这个数能同时被3和5整除，打印fizz buzz. */
    public static void main(String[] args){

        System.out.println(fizzBuzz(15));
    }

    //只用一层for和多个if(或加上else)
    public static List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<String>();

        for(int i=1; i<=n; i++){
//            if(i%3 == 0){
//                if(i%5 ==0){
//                    result.add("fizz buzz");
//                }else{
//                    result.add("fizz");
//                }
//            }else if(i%5 ==0){
//                result.add("buzz");
//            }else{
//                result.add(""+i);
//            }
            if(i%3 == 0 && i%5 ==0){
                result.add("fizz buzz");
                continue;
            }
            if(i%3 == 0){
                result.add("fizz");
                continue;
            }
            if(i%5 ==0){
                result.add("buzz");
                continue;
            }
            result.add(""+i);
        }

        return result;
    }

}
