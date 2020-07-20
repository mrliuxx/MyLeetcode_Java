package test.lintcode.day3;

/**
 * Created by lee on 18/5/3.
 */
public class MergeSortedArray {

    //合并两个排序的整数数组A和B变成一个新的数组。
    public static void main(String[] args){
        int[] result = mergeSortedArray(new int[]{3, 4, 6, 9}, new int[]{1, 4, 8, 10, 20});
        for(int a:result){
            System.out.print(a+" ");
        }
    }

    //两个排序好的数组合并成一个时,只需要一次归并即可
    public static int[] mergeSortedArray(int[] A, int[] B){
        int lengthA = A.length;
        int lengthB = B.length;

        int[] result = new int[lengthA + lengthB];
        int AIndex = 0, BIndex = 0, resultIndex = 0;
        //将A/B共有的下标进行排序归并
        while(AIndex < lengthA && BIndex < lengthB){
            if(A[AIndex] < B[BIndex]){
                result[resultIndex] = A[AIndex];
                resultIndex++;
                AIndex++;
            }else{
                result[resultIndex] = B[BIndex];
                resultIndex++;
                BIndex++;
            }
        }
        //A和B最多只能有一个剩余,执行下面的一个或零个.

        //若上述操作后A还有剩余,将A剩余的依次插入.
        while(AIndex < lengthA){
            result[resultIndex] = A[AIndex];
            resultIndex++;
            AIndex++;
        }
        //若上述操作后B还有剩余,将B剩余的依次插入.
        while(BIndex < lengthB){
            result[resultIndex] = B[BIndex];
            resultIndex++;
            BIndex++;
        }

        return result;
    }
}
