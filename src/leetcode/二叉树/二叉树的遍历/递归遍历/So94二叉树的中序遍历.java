package leetcode.二叉树.二叉树的遍历.递归遍历;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/25 21:59
 */
public class So94二叉树的中序遍历 {
    public void inOrder(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1, -1, 2, 3});
        System.out.println(inorderTraversal(root));
    }
}
