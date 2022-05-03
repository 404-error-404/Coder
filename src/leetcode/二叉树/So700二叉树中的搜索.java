package leetcode.二叉树;

import leetcode.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 22:26
 **/
public class So700二叉树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
