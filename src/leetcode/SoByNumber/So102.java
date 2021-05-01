package leetcode.SoByNumber;

import java.util.*;

public class So102 {
	public static void main(String[] args) {
		
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
		// 待返回答案
        List<List<Integer>> ans = new ArrayList<>();
        if(null == root){return ans;}
        // 初始化队列
    	Queue<TreeNode> queue_tree = new LinkedList<>();
    	queue_tree.add(root);
    	
    	List<Integer> ans_one;	// 单独一行的遍历结果
    	TreeNode node;			// 保存当前节点，以输出数据
    	while(!queue_tree.isEmpty()) {
    		ans_one = new ArrayList<>();
    		// 获取队列当前元素数量，即当前行的元素数量
    		for(int i = queue_tree.size(); i > 0; i--) {
    			node = queue_tree.remove();
    			if(null != node.left) {
    				queue_tree.add(node.left);
    			}
    			if(null != node.right) {
    				queue_tree.add(node.right);
    			}
    			ans_one.add(node.val);
    		}
    		ans.add(ans_one);
    	}
    	return ans;
    }
}
