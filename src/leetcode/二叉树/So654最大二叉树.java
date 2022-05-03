package leetcode.二叉树;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author 小乐乐
 * @date 2022/5/3 22:01
 **/
public class So654最大二叉树 {
    public int maxIdx(int[] nums, int left, int right) {
        int max = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    public TreeNode maxTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = maxIdx(nums, left, right);
        TreeNode root = new TreeNode(nums[max]);
        root.left = maxTree(nums, left, max - 1);
        root.right = maxTree(nums, max + 1, right);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode);

    }
}
