package test.lintcode.day7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/7.
 */
public class FullPermute {

    //给定一个数字列表，返回其所有可能的排列。假设没有重复数字。
    public static void main(String[] args){

        System.out.print(permute(new int[]{0,-1,1}).toString());
    }

    //采用递归和非递归两种方法.
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            List<Integer> tmp = new ArrayList<Integer>();
            result.add(tmp);
            return result;
        }

        //递归算法.
        perm(nums, 0, nums.length-1, result);
        return result;

        //非递归算法
//        while(true) {
//            List<Integer> tmpResult = new ArrayList<Integer>();
//            for(int i=0; i<=nums.length-1; i++){
//                tmpResult.add(nums[i]);
//            }
//            result.add(tmpResult);
//
//            if(nums.length >1){
//                int i,j;
//                //找到不符合趋势的元素的下标i
//                for(i=nums.length-2; i>=0; --i) {
//                    if(nums[i] < nums[i+1]){
//                        break;
//                    }else if(i==0){
//                        return result;
//                    }
//                }
//                for(j=nums.length-1; j>i; --j) {
//                    if(nums[j]>nums[i]){
//                        break;
//                    }
//                }
//
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//                int m = nums.length-1;
//                for(int k=i+1; k<m; ++k,--m) {
//                    int tmp2 = nums[k];
//                    nums[k] = nums[m];
//                    nums[m] = tmp2;
//                }
//            }else{
//                return result;
//            }
//        }
    }
    //递归算法
    public static void perm(int[] nums, int k, int m, List<List<Integer>> result){
        if(k == m){
            List<Integer> tmpResult = new ArrayList<Integer>();
            for(int i=0; i<=m; i++){
                tmpResult.add(nums[i]);
            }
            result.add(tmpResult);
        }else{
            for(int i=k; i<=m; i++){
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;

                perm(nums, k+1, m, result);

                tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
