package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/4 15:50
 **/
public class So501二叉搜索树中的众数 {
    int cur = 0;
    int count = 0;
    int max = 0;
    List<Integer> res;

    public void inorder(TreeNode root) {
        if (null == root) {
            return;
        }
        inorder(root.left);
        if (root.val == cur) {
            count++;
        } else {
            count = 1;
            cur = root.val;
        }

        if (count == max) {
            res.add(root.val);
        } else if (count > max) {
            max = count;
            res.clear();
            res.add(root.val);
        }
        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        count = 0;
        cur = 0;
        max = 0;
        inorder(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
