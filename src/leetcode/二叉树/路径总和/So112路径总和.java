package leetcode.二叉树.路径总和;

import leetcode.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 11:14
 */
public class So112路径总和 {
    public boolean solution(TreeNode root, int curSum, int targetSum) {
        curSum += root.val;
        if (null == root.left && null == root.right) {
            return curSum == targetSum;
        }
        boolean left = false, right = false;
        if (null != root.left) {
            left = solution(root.left, curSum, targetSum);
        }
        if (left) {
            return true;
        }
        if (null != root.right) {
            right = solution(root.right, curSum, targetSum);
        }
        return right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        return solution(root, 0, targetSum);
    }
}
