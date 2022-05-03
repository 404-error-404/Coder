package leetcode.二叉树.构造二叉树;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/3 16:16
 */
public class So105从前序与中序遍历序列构造二叉树 {
    public int findTarget(int[] nums, int begin, int end, int target) {
        for (int i = begin; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return nums.length;
    }

    public TreeNode build(int[] preorder, int prStart, int prEnd, int[] inorder, int inStart, int inEnd) {
        if (prStart > prEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prStart]);
        if (prStart == prEnd) {
            return root;
        }
        int subPreLen = findTarget(inorder, inStart, inEnd, root.val) - inStart;
        root.left = build(preorder, prStart + 1, prStart + subPreLen, inorder, inStart, inStart + subPreLen - 1);
        root.right = build(preorder, prStart + subPreLen + 1, prEnd, inorder, inStart + subPreLen + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    @Test
    public void test() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
//        inorder = new int[]{2, 1};
//        preorder = new int[]{2, 1};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
