package leetcode.二叉树;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/2 20:16
 **/
public class So110平衡二叉树 {
    public int updateHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = 0, right = 0;
        left = updateHeight(root.left);
        if (left == -1) {
            return -1;
        }
        right = updateHeight(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        // 获取左右子树高度
        return updateHeight(root) != -1;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1, 2, 2, 3, 3, -1, -1, 4, 4});
        System.out.println(isBalanced(root));
    }
}
