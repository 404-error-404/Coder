package leetcode.二叉树.二叉树的遍历.层序遍历;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 14:20
 */
public class So107二叉树的层序遍历Ⅱ {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmp = queue.remove();
                oneLevel.add(tmp.val);
                if (null != tmp.left) {
                    queue.add(tmp.left);
                }
                if (null != tmp.right) {
                    queue.add(tmp.right);
                }
            }
            res.add(0, oneLevel);
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{3, 9, 20, -1, -1, 15, 7});
        System.out.println(levelOrderBottom(root));
    }
}