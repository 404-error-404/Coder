package leetcode.So2021.So04;

import leetcode.TreeNode;

/**
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @author 小乐乐
 * @date 2021/4/25 0:32
 **/
public class So0425 {
    static TreeNode head = new TreeNode(), p=head;
    public static TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head.right;
    }

    public static void inorder(TreeNode root){
        if(null != root.left){
            inorder(root.left);
        }
        root.left = null;
        // 遍历当前节点，将其挂在p右子树上
        p.right = root;
        p = p.right;
        // 遍历右孩子节点
        if(null != root.right){
            inorder(root.right);
        }
    }

    public static TreeNode newTreeNode(int[] arr){
        int len = arr.length;
        TreeNode[] nodes = new TreeNode[len];
        for(int i = 0; i < len; i++){
            if(arr[i] != 0){
                nodes[i] = new TreeNode(arr[i]);
            }
        }
        for(int i = 0; i <= len/2; i++){
            if(arr[i] != 0){
                nodes[i].left = arr[i*2+1] == 0? null: nodes[i*2+1];
                nodes[i].right = arr[i*2+2] == 0? null: nodes[i*2+2];
            }
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        TreeNode root = newTreeNode(new int[]{5,3,6,2,4,0,8,1,0,0,0,7,9});
        root = increasingBST(root);
        while (null != root){
            System.out.print(root.val + " ");
            if(null != root.left){
                System.out.print(-1);
                break;
            }
            root = root.right;
        }
    }
}
