package leetcode.二叉树.对称二叉树;

import leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/2 0:25
 **/
public class So101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        // 层序遍历
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        while (left.size() != 0 && right.size() != 0) {
            TreeNode tmpLeft = left.remove();
            TreeNode tmpRight = right.remove();
            if (null == tmpLeft || null == tmpRight) {
                if (null != tmpLeft || null != tmpRight) {
                    return false;
                }
            } else {
                if (tmpLeft.val != tmpRight.val) {
                    return false;
                }
                left.add(tmpLeft.left);
                left.add(tmpLeft.right);

                right.add(tmpRight.right);
                right.add(tmpRight.left);
            }
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1, 2, 2, -1, 4, -1, 3});
        System.out.println(isSymmetric(root));
    }
}
