package leetcode.二叉树;

import leetcode.TreeNode;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * ·节点的左子树仅包含键 小于 节点键的节点。
 * ·节点的右子树仅包含键 大于 节点键的节点。
 * ·左右子树也必须是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/7 0:44
 **/
public class So538把二叉搜索树转换为累加树 {
    int sum;

    public void traverse(TreeNode root) {
        if (null == root) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        traverse(root);
        return root;
    }
}
