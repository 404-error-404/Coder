package leetcode.SoByNumber;

import leetcode.TreeNode;

import java.util.Arrays;

/**
 * @author 翼灵
 */
public class So105 {
	
	public static void main(String[] args) {
		int[] pre = new int[] {3,9,1,2,20,15,7};
		int[] in = new int[] {1,9,2,3,15,20,7};
		TreeNode resNode = buildTree(pre, in);
		System.out.print(resNode.val);
	}
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	// 无序列直接返回空树
    	if(preorder.length == 0) { return null; }
		// 根结点
    	TreeNode root = new TreeNode(preorder[0]);
    	
    	// 找到根结点在中序遍历中的位置
    	int index = 0;
    	while(preorder[0] != inorder[index]) { index++; }
    	
    	add_to_left(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index), root);
    	add_to_right(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length), root);
    	
    	return root;
    }
    
    public static void add_to_left(int[] pre, int[] in, TreeNode node) {
    	// 无序列直接返回
    	if(pre.length == 0) { return; }
    	// 否则将前序遍历的首元素赋值给当前节点的左孩子结点
    	node.left = new TreeNode(pre[0]);
    	// 找到此次根结点在中序遍历中的位置
    	int index = 0;
    	while(pre[0] != in[index]) { index++; }
    	
    	add_to_left(Arrays.copyOfRange(pre, 1, index+1), Arrays.copyOfRange(in, 0, index), node.left);
    	add_to_right(Arrays.copyOfRange(pre, index+1, pre.length), Arrays.copyOfRange(in, index+1, in.length), node.left);
    	
    }
    
    public static void add_to_right(int[] pre, int[] in, TreeNode node) {
    	// 无序列直接返回
    	if(pre.length == 0) { return; }
    	// 否则将前序遍历的首元素赋值给当前节点的左孩子结点
    	node.right = new TreeNode(pre[0]);
    	// 找到此次根结点在中序遍历中的位置
    	int index = 0;
    	while(pre[0] != in[index]) { index++; }
    	
    	add_to_left(Arrays.copyOfRange(pre, 1, index+1), Arrays.copyOfRange(in, 0, index), node.right);
    	add_to_right(Arrays.copyOfRange(pre, index+1, pre.length), Arrays.copyOfRange(in, index+1, in.length), node.right);
    	
    }
}
