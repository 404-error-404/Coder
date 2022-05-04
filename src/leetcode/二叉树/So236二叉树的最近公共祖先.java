package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/4 17:13
 **/
public class So236二叉树的最近公共祖先 {
    Stack<TreeNode> stack;
    int count;

    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        boolean tmp = false;
        if (null == root) {
            return false;
        }
        if (count == 0) {
            stack.add(root);
            tmp = true;
        }
        if (root.val == p.val || root.val == q.val) {
            count++;
        }
        if (count == 2) {
            return true;
        }
        if (findNode(root.left, p, q)) {
            return true;
        }
        if (findNode(root.right, p, q)) {
            return true;
        }
        if (tmp) {
            stack.pop();
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        stack = new Stack<>();
        count = 0;
        findNode(root, p, q);
        return stack.pop();
    }
}
