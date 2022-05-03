package leetcode.二叉树.构造二叉树;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 13:51
 */
public class So106从中序与后序遍历序列构造二叉树 {
    public int findTarget(int[] nums, int begin, int end, int target) {
        for (int i = begin; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return nums.length;
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[poEnd]);
        if (poEnd == poStart) {
            return root;
        }
        int rootIdx = findTarget(inorder, inStart, inEnd, root.val);
        int tmpLen = rootIdx - inStart;
        root.left = build(inorder, inStart, rootIdx - 1, postorder, poStart, poStart + tmpLen - 1);
        root.right = build(inorder, rootIdx + 1, inEnd, postorder, poStart + tmpLen, poEnd - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    @Test
    public void test() {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        inorder = new int[]{2, 1};
        postorder = new int[]{2, 1};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
