package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 11:05
 */
public class So513找树左下角的值 {
    int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res = queue.peek().val;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmp = queue.remove();
                if (null != tmp.left) {
                    queue.add(tmp.left);
                }
                if (null != tmp.right) {
                    queue.add(tmp.right);
                }
            }
        }
        return res;
    }
}
