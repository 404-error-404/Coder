package leetcode.二叉树;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Queue;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 0:17
 **/
public class So400左叶子之和 {
    int res = 0;
    public void sumOfLeaves(TreeNode root, boolean isLeft) {
        if (isLeft && null == root.left && null == root.right) {
            this.res += root.val;
        }
        if (null != root.left) {
            sumOfLeaves(root.left, true);
        }
        if (null != root.right) {
            sumOfLeaves(root.right, false);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        this.res = 0;
        if (null == root) {
            return 0;
        }
        sumOfLeaves(root, false);
        return this.res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{3, 9, 20, -1, -1, 15, 7});
        System.out.println(sumOfLeftLeaves(root));
    }
}
