package leetcode.So10;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/10/17 01:34
 **/
public class So1017 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if (k == 0){
                break;
            }
            root=root.right;
        }
        return root.val;
    }

    @Test
    public void kthSmallestTest(){
        TreeNode root = TreeNode.arrToTreeNode(new int[]{3,1,4,-1,2});
        System.out.println(kthSmallest(root, 4));
    }


}
