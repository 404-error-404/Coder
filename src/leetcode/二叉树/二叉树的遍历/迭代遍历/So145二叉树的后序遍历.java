package leetcode.二叉树.二叉树的遍历.迭代遍历;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 0:45
 **/
public class So145二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode tmp;
        while (!stack.empty()) {
            tmp = stack.pop();
            if (null != tmp.left) {
                stack.push(tmp.left);
            }
            if (null != tmp.right) {
                stack.push(tmp.right);
            }
            res.add(0, tmp.val);
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1, -1, 2, 3});
        System.out.println(postorderTraversal(root));
    }
}
