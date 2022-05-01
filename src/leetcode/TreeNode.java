package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树节点
 *
 * @author 小乐乐
 * @date 2021/4/25 11:05
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 从数组转换为树
     * -1表示对应的结点不存在
     *
     * @param arr 数组
     * @return 树根结点
     */
    public static TreeNode arrToTreeNode(int[] arr) {
        if (arr[0] == -1) {
            System.out.println("根结点不为空");
            return null;
        }
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
            if (leftNumber != -1) {
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);

                if (index == arr.length) {
                    break;
                }
            }

            int rightNumber = arr[index++];
            if (rightNumber != -1) {
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}