package leetcode.二叉树;

import leetcode.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/4 23:32
 **/
public class So450删除二叉搜索树中的节点 {
    /**
     * 在二叉搜索树中找到指定节点
     */
    public TreeNode findParent(TreeNode root, int key) {
        if (root.val > key) {
            if (null == root.left) {
                return null;
            }
            if (root.left.val == key) {
                return root;
            }
            root = root.left;
        } else {
            if (null == root.right) {
                return null;
            }
            if (root.right.val == key) {
                return root;
            }
            root = root.right;
        }
        return findParent(root, key);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode tmp = new TreeNode(100001);
        tmp.left = root;
        TreeNode parent = findParent(tmp, key);
        // 未找到对应节点
        if (null == parent) {
            return root;
        }
        // cur存储key对应节点的右孩子节点
        // left存储cur对应节点的左孩子结点
        // 然后将cur替换要删除的节点
        TreeNode left, cur;
        if (parent.val > key) {
            cur = parent.left.right;
            left = parent.left.left;
            if (null == cur) {
                parent.left = left;
                return tmp.left;
            }
            parent.left = cur;
        } else {
            cur = parent.right.right;
            left = parent.right.left;
            if (null == cur) {
                parent.right = left;
                return tmp.left;
            }
            parent.right = cur;
        }
        while (null != cur.left) {
            cur = cur.left;
        }
        cur.left = left;
        return tmp.left;
    }
}
