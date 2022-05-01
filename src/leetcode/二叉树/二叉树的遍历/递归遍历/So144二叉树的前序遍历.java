package leetcode.二叉树.二叉树的遍历.递归遍历;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal">https://leetcode-cn.com/problems/binary-tree-preorder-traversal</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/25 21:44
 */
public class So144二叉树的前序遍历 {
    public void preOrder(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        // 处理自己
        res.add(root.val);
        // 处理左孩子
        preOrder(root.left, res);
        // 处理右孩子
        preOrder(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1, -1, 2, 3});
        System.out.println(preorderTraversal(root));
    }
}
