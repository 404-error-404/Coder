package leetcode.二叉树.二叉树的遍历.层序遍历;

/**
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/26 18:37
 */
public class So117填充每个节点的下一个右侧节点指针Ⅱ {
    public Node connect(Node root) {
        Node lineHead = root;
        while (null != lineHead) {
            Node tmp = lineHead, lastNode = null;
            lineHead = null;
            while (null != tmp) {
                // 将该行节点的孩子节点连成一行
                if (null != tmp.left) {
                    // 存储下一行的头节点
                    if (null == lineHead) {
                        lineHead = tmp.left;
                    }
                    // 串联tmp的左孩子节点
                    if (null != lastNode) {
                        lastNode.next = tmp.left;

                    }
                    lastNode = tmp.left;
                }
                if (null != tmp.right) {
                    // 更新下一行的头结点
                    if (null == lineHead) {
                        lineHead = tmp.right;
                    }
                    // 串联tmp的右孩子节点
                    if (null != lastNode) {
                        lastNode.next = tmp.right;
                    }
                    lastNode = tmp.right;
                }
                tmp = tmp.next;
            }
        }
        return root;
    }
}
