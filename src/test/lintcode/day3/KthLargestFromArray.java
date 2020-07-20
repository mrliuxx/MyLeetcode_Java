package test.lintcode.day3;

/**
 * Created by lee on 18/5/3.
 */
public class KthLargestFromArray {

    //在数组中找到第k大的元素
    public static void main(String[] args){

        System.out.println("结果:"+kthLargestElement(4, new int[]{9, 3, 2, 4, 8}));
    }

    public static int kthLargestElement(int k, int[] nums){
        //方法一:o(nlogn),最坏o(n^2).
        // 快速排序算法
//        quickSort(nums, 0, nums.length-1);
//
//        //找到第k大的元素位置:nums.length-k.
//        return nums[nums.length-k];

        //方法二:在方法一的基础上少了几次递归的排序.
        // 当vot下标等于k时,这一次排序之后,说明vot的前面k个元素,就是整个数组的前k个最小(或最大)的数(可能未排序好).
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (k <= 0) {
            return 0;
        }

        //方法三:最坏复杂度为o(n).
        // BFPRT算法,在方法二的基础上再改进.不同于快速排序的随机选取vot元素,而是有目的的选取vot下标,然后比较vot下标和k的值.
        //（1）：选取主元；
        //  （1.1）：将n个元素划分为⌊n5⌋⌊n5⌋个组，每组5个元素，若有剩余，舍去；
        //  （1.2）：使用插入排序找到⌊n5⌋⌊n5⌋个组中每一组的中位数；
        //  （1.3）：对于（1.2）中找到的所有中位数，调用BFPRT算法求出它们的中位数，作为主元；
        //（2）：以（1.3）选取的主元为分界点，把小于主元的放在左边，大于主元的放在右边；
        //（3）：判断主元的位置与k的大小，有选择的对左边或右边递归。
        //
        // <附加:堆排序也是同样的效率.>

        return helper(nums, 0, nums.length - 1, k);
    }

      //方法一:
//    //完整的快速排序算法.
//    public static void quickSort(int[] nums, int left, int right){
//        if(left < right){
//            int i = left;
//            int j = right;
//            int tmpVot = nums[i];
//
//            while(i != j){
//                while(i < j && tmpVot <= nums[j]){  //从后向前找较小值.
//                    j--;
//                }
//                if(i < j){                          //找到较小元素时,根据i的值将其向前移动.
//                    nums[i] = nums[j];
//                    i++;
//                }
//
//                while(i < j && tmpVot >= nums[i]){  //从前向后找较大值.
//                    i++;
//                }
//                if(i < j){                          //找到较大元素时,根据j的值将其向后移动.
//                    nums[j] = nums[i];
//                    j--;
//                }
//            }
//
//            //这里i==j.
//            nums[i] = tmpVot;
//            quickSort(nums, left, i-1);
//            quickSort(nums, j+1, right);
//        }
//    }

    //方法二:
    //还有一种思想,在快速排序一次排序之后,判断tmpVot的下标位置i,
    //当i==nums.length-k时,说明i号位的元素就是位于整个数组的倒数第k个元素.
    public static int helper(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        //循环切分,直到找到第k大的数,不满足就递归
        int i = quickSort(nums, left, right);

        if (i == nums.length-k) {
            return nums[i];
        } else if (i < nums.length-k) {
            return helper(nums, i + 1, right, k);
        } else {
            return helper(nums, left, i - 1, k);
        }
    }
    public static int quickSort(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int tmpVot = nums[i];

        while(i != j){
            while(i < j && tmpVot <= nums[j]){  //从后向前找较小值.
                j--;
            }
            if(i < j){                          //找到较小元素时,根据i的值将其向前移动.
                nums[i] = nums[j];
                i++;
            }

            while(i < j && tmpVot >= nums[i]){  //从前向后找较大值.
                i++;
            }
            if(i < j){                          //找到较大元素时,根据j的值将其向后移动.
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = tmpVot;
        return i;
    }


}
