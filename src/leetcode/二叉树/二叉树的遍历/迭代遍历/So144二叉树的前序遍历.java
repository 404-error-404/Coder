package leetcode.二叉树.二叉树的遍历.迭代遍历;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 0:24
 **/
public class So144二叉树的前序遍历 {
    /**
     * 递归方法实现先序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.empty()) {
            tmp = stack.pop();
            if (null != tmp.right) {
                stack.push(tmp.right);
            }
            if (null != tmp.left) {
                stack.push(tmp.left);
            }
            res.add(tmp.val);
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1, -1, 2, 3});
        System.out.println(preorderTraversal(root));
    }
}
