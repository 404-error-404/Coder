package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 张佳乐
 * @date 2021/4/25 11:05
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode arrToTreeNode(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == arr.length) {
                break;
            }

            int leftNumber = arr[index++];
            node.left = new TreeNode(leftNumber);
            nodeQueue.add(node.left);

            if (index == arr.length) {
                break;
            }

            int rightNumber = arr[index++];
            node.right = new TreeNode(rightNumber);
            nodeQueue.add(node.right);
        }
        return root;
    }
}