package leetcode.So2021.So04;

import leetcode.TreeNode;

import java.util.Stack;


/**
 * @author WHU-LiXiaoJian
 */
public class So0427 {
    public static int rangeSumBST(TreeNode root, int low, int high) {
    	int sum = 0;
    	Stack<TreeNode> stack = new Stack<>();
    	while(null != root && root.val > high) {
    		root = root.left;
    	}while(null != root && root.val < low) {
    		root = root.right;
    	}
    	if(null == root){ return sum; }
    	stack.push(root);
    	TreeNode p;
    	while(!stack.empty()) {
    		p = stack.pop();
    		if(p.val <= high && p.val >= low) {
    			sum += p.val;
    			if(null != p.left) {
        			stack.push(p.left);
        		}
    			if(null != p.right) {
        			stack.push(p.right);
    			}
    		}
    		else {
    			if(p.val > high && null != p.left) {
        			stack.push(p.left);
        		}
        		if(p.val < low && null != p.right){
        			stack.push(p.right);
        		}
    		}
    	}
    	return sum;
    }
    
	public static void main(String[] args) {
		int low, high;
		TreeNode rooTreeNode = TreeNode.arrToTreeNode(new int[]{10,5,15,3,7,13,18,1,-1,6});
		low = 6;
		high = 10;
		System.out.print(rangeSumBST(rooTreeNode, low, high));
	}
}
