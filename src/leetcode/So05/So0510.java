package leetcode.So05;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 *
 * [img](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png)
 *
 * 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
 *
 * 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/10 9:57
 **/
public class So0510 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        tree2List(root1, leaf1);
        tree2List(root2, leaf2);
        if(leaf1.size() != leaf2.size()){
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++){
            if(leaf1.get(i).equals(leaf2.get(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 将树的叶子序列转变到list中
     * @param root 树的根结点
     * @param list 保存结果的list
     */
    public void tree2List(TreeNode root, List<Integer> list){
        if(null != root.left){
            tree2List(root.left, list);
        }
        if(null != root.right){
            tree2List(root.right, list);
        }
        if(null == root.left && null == root.right) {
            list.add(root.val);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,3,2};
        TreeNode root1 = TreeNode.arrToTreeNode(arr1);
        TreeNode root2 = TreeNode.arrToTreeNode(arr2);
        System.out.println(new So0510().leafSimilar(root1, root2));
    }
}
