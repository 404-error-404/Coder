package leetcode.二叉树.二叉树的遍历.层序遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 17:54
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class So116填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node last = queue.remove();
            if (null != last.left) {
                queue.add(last.left);
            }
            if (null != last.right) {
                queue.add(last.right);
            }
            for (int i = len-1; i > 0; i--) {
                Node cur = queue.remove();
                last.next = cur;
                last = cur;
                if (null != last.left) {
                    queue.add(last.left);
                }
                if (null != last.right) {
                    queue.add(last.right);
                }
            }
        }
        return root;
    }
}
