package leetcode.二叉树.二叉树的遍历.层序遍历;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给定一棵二叉树的根节点root，请找出该二叉树中每一层的最大值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 17:46
 */
public class So515在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmp = queue.remove();
                max = Math.max(max, tmp.val);
                if (null != tmp.left) {
                    queue.add(tmp.left);
                }
                if (null != tmp.right) {
                    queue.add(tmp.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1, 3, 2, 5, 3, -1, 9});
        System.out.println(largestValues(root));
    }
}
