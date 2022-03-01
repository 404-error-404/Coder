package leetcode.So09;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/9/28 10:01
 **/
public class So0928 {
    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null){
            return 0;
        }

        int res;
        curr += root.val;

        long dif = curr - targetSum;
        res = prefix.getOrDefault(dif, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, prefix, curr, targetSum);
        res += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr,  0) - 1);

        return res;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    @Test
    public void pathSumTest(){
        TreeNode root = TreeNode.arrToTreeNode(new int[]{-10,5,-3,3,2,-1,11,3,-2,-1,1});
        int targetSum  = 8;
        System.out.println(pathSum(root, targetSum));
    }

}
