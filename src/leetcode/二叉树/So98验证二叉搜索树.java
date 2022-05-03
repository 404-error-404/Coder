package leetcode.二叉树;

import leetcode.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 22:31
 **/
public class So98验证二叉搜索树 {
    long cur = -2147483649L;
    boolean res = true;

    public void inorder(TreeNode root) {
        if (!res || null == root) {
            return;
        }
        inorder(root.left);
        // 处理数字
        if (root.val <= cur) {
            res = false;
            return;
        } else {
            cur = root.val;
        }
        inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        res = true;
        long cur = -2147483649L;
        // 中序遍历
        inorder(root);
        return res;
    }
}
