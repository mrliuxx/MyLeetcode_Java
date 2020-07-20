package test.lintcode.day2;

/**
 * Created by lee on 18/5/2.
 */
public class CountNumber {

    //计算数字k在0到n中的出现的次数，k可能是0~9的一个值
    public static void main(String[] args){

        System.out.println("结果:"+digitCounts(2, 302));
    }

    public static int digitCounts(int k, int n) {
        //方法1:分别扫描k-n这些数的每一位,与k比较.算法时间复杂度(n*(1至x),x为位数)
//        int count = 0;
//        for(int i=k;i<=n;i++){
//            String str = i+"";
//            for(int j=0;j<str.length();j++){
//                String s = str.charAt(j)+"";
//                int sNum = Integer.valueOf(s);
//                if(sNum == k){
//                    count++;
//                }
//            }
//        }
//
//        return count;

        //方法2:分别对k-n这些数进行/10操作,得到数的每一位,与k比较.算法时间复杂度(n*(1至x),x为位数)
        int count = 0;
        for(int i=k;i<=n;i++){
            int tmpNumber = i;
            if(tmpNumber == 0 && k == 0){
                count += 1;
            }
            while (tmpNumber > 0){
                if(tmpNumber % 10 == k){
                    count++;
                }
                tmpNumber = tmpNumber/10;
            }
        }

        return count;
    }
}
