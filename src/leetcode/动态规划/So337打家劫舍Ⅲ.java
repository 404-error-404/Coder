package leetcode.动态规划;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/9/15 18:46
 */
public class So337打家劫舍Ⅲ {
    private int childSum(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            res += root.left.val;
        }
        if (root.right != null) {
            res += root.right.val;
        }
        return res;
    }

    private void postIndex(TreeNode root) {
        if (root == null) {
            return;
        }
        postIndex(root.left);
        postIndex(root.right);
        root.val = Math.max(childSum(root), childSum(root.left) + childSum(root.right) + root.val);
    }

    public int rob(TreeNode root) {
        postIndex(root);
        return root.val;
    }

    @Test
    public void test() {
        Integer[] arr = new Integer[]{3, 2, 3, null, 3, null, 1};
        arr = new Integer[]{3, 4, 5, 1, 3, null, 1};
        TreeNode root = TreeNode.arrToTreeNode(arr);
        System.out.println(rob(root));
    }
}
