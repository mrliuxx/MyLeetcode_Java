package test.lintcode.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 18/5/4.
 */
public class BinaryTree {

    //设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
    //如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。
    public static void main(String[] args){

    }

    //二叉树转为字符串,", "号分割.
    public String serialize(TreeNode root) {
        if(root == null){
            return "{}";
        }

        String strData = "";
        //遍历二叉树节点的顺序.
        List<TreeNode> tmpNodeList = new ArrayList<TreeNode>();
        tmpNodeList.add(root);
        while(!tmpNodeList.isEmpty()){
            TreeNode tmpNode = tmpNodeList.remove(0);

            //将当前节点的值(编号)追加存储.
            if(tmpNode != null){

                strData += tmpNode.val + ",";

                //添加子节点用于下一次的判断.
                tmpNodeList.add(tmpNode.left);
                tmpNodeList.add(tmpNode.right);
            }else{
                strData += "#" + ",";
            }
        }

        strData = strData.substring(0, strData.length()-1);
        System.out.print("结果1:"+strData);
        return "{" + strData + "}";
    }

    //如果满二叉树（或完全二叉树）的父节点下标是 i，那么其左右孩子的下标分别为 2*i+1 和 2*i+2.但这里并不一定是完全二叉树.
//如:          5
//            / \
//           4   7
//          /   /
//         3   2
//        /   /
//       -1  9
//上面序列化的结果为:{5,4,7,3,null,2,null,-1,null,9,null,null,null,null,null}
//  节点 2 的下标是 5，可它的左孩子 9 的下标为 9，并不是 2*i+1=11，
//  原因在于 2 的前面有个 null 节点，这个 null 节点没有左右孩子，所以下一层子节点的下标都提前了2。
//  所以我们只需要记录每个节点前(包括当前节点)有多少个 null 节点，就可以找出该节点的孩子在哪里了，
//  其左右孩子分别为 2*(i-num)+1 和 2*(i-num)+2（num为当前节点之前 null 节点的个数）.

    //根据字符串创建二叉树.
    public TreeNode deserialize(String data) {
        if(data.length() == 2){// "{}"
            return null;
        }

        String[] strData = data.substring(1, data.length()-1).split(",");
        int[] emptyCount = new int[strData.length];//记录每个节点前面的null节点个数.
        TreeNode[] nodes = new TreeNode[strData.length];//存储序列化结果对应的节点.用来反序列化为树

        //统计节点前null节点个数
       for(int i=0; i<strData.length; i++){
           //从第二个节点开始,将前一个节点统计的个数附加上.
           if(i>0){
               emptyCount[i] += emptyCount[i-1];
           }

           //当前节点为空时,存为Null；且在节点计数的数组中当前节点位置+1操作.是为了支持下一个非空节点的计数累加.
           if("#".equals(strData[i])){
               nodes[i] = null;
               emptyCount[i] ++;
           }else{
               nodes[i] = new TreeNode(Integer.valueOf(strData[i]));
           }
       }

        //根据节点构造二叉树.
        for(int i=0; i<strData.length; i++){
            //遇到空节点跳过,因为其没有子节点,只作为别人的子节点
            if (nodes[i] == null) {
                continue;
            }
            nodes[i].left = nodes[2 * (i - emptyCount[i]) + 1];
            nodes[i].right = nodes[2 * (i - emptyCount[i]) + 2];
        }

        return nodes[0];
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
