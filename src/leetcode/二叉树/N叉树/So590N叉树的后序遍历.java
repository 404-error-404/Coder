package leetcode.二叉树.N叉树;

import leetcode.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/2 0:19
 **/
public class So590N叉树的后序遍历 {
    public void post(Node root, List<Integer> res) {
        if (null == root) {
            return;
        }
        root.children.forEach(i -> post(i, res));
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        post(root, res);
        return res;
    }
}
