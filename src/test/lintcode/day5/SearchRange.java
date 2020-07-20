package test.lintcode.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/5.
 */
public class SearchRange {

    public static void main(String[] args){


    }

    //中根遍历二叉排序树root,即为从小到大的顺序.再判断是否属于k1和k2范围内(k1 <= x <= k2).
    //有中根遍历有递归和非递归两种.
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<Integer>();

//        //先实现非递归遍历方法
//        List<TreeNode> tmpStack = new ArrayList<TreeNode>();
//        //TreeNodeTreeNode
//        TreeNode p = root;
//
//        while(p !=null || !tmpStack.isEmpty()){
//            if(p != null){
//                tmpStack.add(p);
//                p = p.left;
//            }else{
//                p = tmpStack.remove(tmpStack.size()-1);
//                int i = p.val;
//                if(k1 <= i && i <= k2){
//                    result.add(i);
//                }
//                p = p.right;
//            }
//        }
        //递归遍历方法
        inOrder(root, k1, k2, result);

        return result;
    }
    //递归遍历方法
    public static void inOrder(TreeNode p, int k1, int k2, List<Integer> result){
        if(p != null){
            inOrder(p.left, k1, k2, result);

            int i = p.val;
            if(k1 <= i && i <= k2){
                result.add(i);
            }

            inOrder(p.right, k1, k2, result);
        }
    }

    //二叉树类
    public class TreeNode {
        public int val;             //当前节点的数值(也可说成编号)
        public TreeNode left, right;//当前节点的坐子树和右子树.

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
