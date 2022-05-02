package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/2 21:18
 **/
public class So14二叉树的所有路径 {
    public void treePath(TreeNode root, String head, List<String> res) {
        head = head + "->" + String.valueOf(root.val);
        if (null == root.left && null == root.right) {
            res.add(head);
        }
        if (null != root.left) {
            treePath(root.left, head, res);
        }
        if (null != root.right) {
            treePath(root.right, head, res);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        String head = String.valueOf(root.val);
        if (null == root.left && null == root.right) {
            res.add(head);
            return res;
        }
        if (null != root.left) {
            treePath(root.left, head, res);
        }
        if (null != root.right) {
            treePath(root.right, head, res);
        }
        return res;
    }
}
