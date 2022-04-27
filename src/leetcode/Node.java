package leetcode;

import java.util.List;

/**
 * N叉树的节点
 *
 * @author 小乐乐
 * @date 2022/4/26 17:22
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

}
