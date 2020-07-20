package test.lintcode.day7;

/**
 * Created by lee on 18/5/7.
 */
public class BinarySearch {
    //给定一个排序的整数数组（升序）和一个要查找的整数target，
    //用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
    public static void main(String[] args){

        System.out.println(binarySearch(new int[]{1, 2, 2, 3, 3, 5, 10}, 3));
    }

    //在传统的二分查找上改进,因为直接找到的不一定是第一个target(或最后一个target)
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int result = -1;
        //将二分查找的递归改成循环
        while (left < right){

            int middle = (right + left)/2;
            if(nums[middle] < target){
                left = middle+1;
                continue;
            }else if(nums[middle] > target){
                right = middle-1;
                continue;
            }//nums[middle] == target
            else{
                //这种写法是一般的二分查找,当有多个重复的target时,需要进行改进.
//                result = middle;
//                break;

                //若要找第一个(或最后一个)target的下标时,
                //要将middle赋予right,即寻找当前target的前面是否还存在target元素(找最后一个时方法相反).

                //找到一个target元素后,当right和left紧挨着时,
                if(right - left == 1){
                    //判断left是不是target,若是则为第一个target,否则还是上一个找到的target为第一个.
                    if(nums[left] == target){
                        result = left;
                    }
                    break;
                }
                right = middle;
                result = middle;
                continue;
            }
        }

        //while的结束时有left == right,当这最后一个元素也不等于target时,就返回-1表示未找到元素.
        if(nums[left] == target){
            result = left;
        }

        return result;
    }
}
