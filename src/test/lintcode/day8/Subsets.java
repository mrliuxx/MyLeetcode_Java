package test.lintcode.day8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/8.
 */
public class Subsets {

    public static void main(String[] args){

        System.out.print(subsets(new int[]{1,2,3,4}).toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //添加空集,如果集合为空,则直接返回,否则开始遍历集合的元素
        List<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp);
        if(nums.length == 0){
            return result;
        }

        int index[] = new int[nums.length];
        while(index[0] < nums.length){
            List<Integer> tmp2 = new ArrayList<Integer>();
            tmp2.add(nums[index[0]]);
            result.add(tmp2);

            for(int i=1; i<index.length; i++){
                index[i] = index[i-1]+1;
            }

            index[0] ++;
        }

        return result;
    }
}
