package leetcode.SoByNumber;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class So100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if(null == p && null == q) { return true; }
    	if(null == p || null == q) { return false; }
    	
    	Queue<TreeNode> queue = new LinkedList<>();
		queue.add(p);
		queue.add(q);
		while(!queue.isEmpty()){
			p = queue.remove();
			q = queue.remove();
			// 判断当前节点的值是否相等
			if(p.val != q.val) { return false; }
			// 判断是否都有左孩子
			if(null != p.left && null != q.left) {
				queue.add(p.left);
				queue.add(q.left);
			}
			else if (null == p.left || null == q.left) {
				return false;
			}
			// 判断是否都有右孩子
			if(null != p.right && null != q.right) {
				queue.add(p.right);
				queue.add(q.right);
			}
			else if (null == p.right || null == q.right) {
				return false;
			}
		}
    	return true;
    }
    
	public static void main(String[] args) {
		
	}
}
