package leetcode.二叉树;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/6 23:51
 **/
public class So669修剪二叉搜索树 {
    public TreeNode preDeal(TreeNode root, int low, int high) {
        if (null == root) {
            return null;
        }
        if (root.val > high) {
            return preDeal(root.left, low, high);
        } else if (root.val < low) {
            return preDeal(root.right, low, high);
        } else {
            return root;
        }
    }

    public void removeLeft(TreeNode root, int low) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            TreeNode left = root.left;
            if (left.val > low) {
                removeLeft(root.left, low);
            } else if (left.val == low) {
                left.left = null;
            } else {
                root.left = left.right;
                removeLeft(root, low);
            }
        }
    }

    public void removeRight(TreeNode root, int high) {
        if (null == root) {
            return;
        }
        if (null != root.right) {
            TreeNode right = root.right;
            if (right.val < high) {
                removeRight(root.right, high);
            } else if (right.val == high) {
                right.right = null;
            } else {
                root.right = right.left;
                removeRight(root, high);
            }
        }
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        root = preDeal(root, low, high);
        if (null == root) {
            return null;
        }
        removeLeft(root, low);
        removeRight(root, high);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{28, 12, 45, 4, 24, 35, 47, 2, 9, 14, 25, 31, 42, 46, 48, 0, 3, 8, 11, 13, 20, -1, 26, 30, 33, 41, 43, -1, -1, -1, 49, -1, 1, -1, -1, 7, -1, 10, -1, -1, -1, 17, 22, -1, 27, 29, -1, 32, 34, 36, -1, -1, 44, -1, -1, -1, -1, 6, -1, -1, -1, 16, 18, 21, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, 5, -1, 15, -1, -1, 19, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, 39, -1, 38});
        int low = 12, high = 22;
        TreeNode treeNode = trimBST(root, low, high);
        System.out.println(treeNode);
    }
}
