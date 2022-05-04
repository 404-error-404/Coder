package leetcode.二叉树;

import leetcode.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/4 23:23
 **/
public class So701二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode v = new TreeNode(val);
        if (null == root){
            return v;
        }
        TreeNode head = root;
        while (true) {
            if (root.val > val) {
                if (null == root.left) {
                    root.left = v;
                    return head;
                }
                root = root.left;
            } else {
                if (null == root.right) {
                    root.right = v;
                    return head;
                }
                root = root.right;
            }
        }
    }
}
