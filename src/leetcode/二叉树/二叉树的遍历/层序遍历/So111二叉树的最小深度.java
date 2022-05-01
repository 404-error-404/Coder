package leetcode.二叉树.二叉树的遍历.层序遍历;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 21:53
 */
public class So111二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        if (null == root.left) {
            return minDepth(root.right) + 1;
        }
        if (null == root.right) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        TreeNode tmp = root;
        for (int i = 3; i < 7; i++) {
            tmp.right = new TreeNode(i);
        }
        System.out.println(minDepth(root));

    }
}
