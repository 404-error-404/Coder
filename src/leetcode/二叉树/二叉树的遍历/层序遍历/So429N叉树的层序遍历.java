package leetcode.二叉树.二叉树的遍历.层序遍历;

import leetcode.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 17:21
 */
public class So429N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        int cur = 0;
        while (cur < nodes.size()) {
            List<Integer> oneLevel = new ArrayList<>();
            int len = nodes.size();
            for (; cur < len; cur++) {
                Node tmp = nodes.get(cur);
                oneLevel.add(tmp.val);
                if (null != tmp.children) {
                    nodes.addAll(tmp.children);
                }
            }
            res.add(oneLevel);
        }
        return res;
    }
}
