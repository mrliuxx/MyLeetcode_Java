package test.lintcode.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/2.
 */
public class UglyNumber {

    //设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
    public static void main(String[] args){

        //1692个就会超出int的表示范围了.
        System.out.println("结果:"+nthUglyNumber(1691));
    }

    //丑数应该是另一个丑数乘以2、3或者5的结果（1除外）.
    public static int nthUglyNumber(int n){
        //方法1:一直往后遍历,相较于o(n)超时
//        int count = 0;
//        int result = 0;
//        while(count != n){
//            result ++;
//            int tmpNumber = result;
//            while(tmpNumber % 2 ==0){
//                tmpNumber = tmpNumber/2;
//            }
//            while(tmpNumber % 5 ==0){
//                tmpNumber = tmpNumber/5;
//            }
//            while(tmpNumber % 3 ==0){
//                tmpNumber = tmpNumber/3;
//            }
//
//            if(tmpNumber == 1){
//                count ++;
//            }
//        }
//
//        return result;

        /**方法2分析：排序好存储到列表中.采用三个指针,分别指向下一个应该进行*2/*3/*5操作的元素位置.
         * 假设数组ugly[N]中存放不断产生的丑数，初始只有一个丑数ugly[0]=1;由此出发，下一个丑数由因子2,3,5竞争产生，
         * 得到ugly[0]*2, ugly[0]*3, ugly[0]*5， 显然最小的那个数是新的丑数，所以第2个丑数为ugly[1]=ugly[0]*2=2，开始新一轮的竞争，
         * 由于上一轮竞争中，因子2获胜，这时因子2应该乘以ugly[1]才显得公平，得到ugly[1]*2,ugly[0]*3,ugly[0]*5，
         * 因子3获胜，ugly[2]=3，同理，下次竞争时因子3应该乘以ugly[1]，即：ugly[1]*2, ugly[1]*3, ugly[0]*5,
         * 因子5获胜，得到ugly[3]=5，重复这个过程，直到第n个丑数产生。
         * 总之：每次竞争中有一个（也可能是两个）因子胜出，下一次竞争中 胜出的因子就应该加大惩罚！
         */
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);

        int multiple2 = 0;
        int multiple3 = 0;
        int multiple5 = 0;

        while (result.size() < n){
            //找出三个指针指向的元素乘以它们对应的数(2/3/5)后,最小的那一个.
            int minTmp = result.get(multiple2)*2 < result.get(multiple3)*3 ? result.get(multiple2)*2 : result.get(multiple3)*3;
            int minNum = result.get(multiple5)*5 < minTmp ? result.get(multiple5)*5 : minTmp;

            //哪一个最小,将其指针后移一位,用于下一次的竞争.
            if(minNum == result.get(multiple2)*2){
                multiple2++;
            }
            if(minNum == result.get(multiple3)*3){
                multiple3++;
            }
            if(minNum == result.get(multiple5)*5){
                multiple5++;
            }

            //将最小的那一个加入列表,即为升序添加元素.
            result.add(minNum); //size()+1;
        }

        return result.get(n-1);//返回类别最后一个元素,即为n个丑数列表中最大的丑数.
    }
}
