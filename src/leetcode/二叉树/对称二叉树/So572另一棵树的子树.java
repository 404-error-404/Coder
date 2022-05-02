package leetcode.二叉树.对称二叉树;

import leetcode.TreeNode;

/**
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/2 0:25
 **/
public class So572另一棵树的子树 {
    public boolean isSameTree(TreeNode root, TreeNode sub) {
        if (null == sub && null == root) {
            return true;
        }
        if (null == sub || null == root) {
            return false;
        }
        return root.val == sub.val && isSameTree(root.left, sub.left) && isSameTree(root.right, sub.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)) {
            return true;
        }
        else if (null == root){
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
