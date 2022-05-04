package leetcode.二叉树;

import leetcode.TreeNode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/4 13:25
 **/
public class So530二叉搜索树的最小绝对差 {
    int maxVal = 100000;
    int minDiff = maxVal;
    int cur = -maxVal;
    public void inorder(TreeNode root) {
        if (null == root) {
            return;
        }
        inorder(root.left);
        minDiff = Math.min(minDiff, root.val - cur);
        cur = root.val;
        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        minDiff = maxVal;
        cur = -maxVal;
        inorder(root);
        return minDiff;
    }
}
