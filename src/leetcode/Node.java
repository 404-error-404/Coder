package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


    public static Node strToNode(String s) {
        Node root = new Node(0, new ArrayList<>());
        s = s.substring(1, s.length() - 1);
        String[] nodes = s.split(",");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        for (String node : nodes) {
            if ("null".equals(node)) {
                queue.remove();
            }
            else {
                Node tmp = new Node(Integer.parseInt(node), new ArrayList<>());
                queue.peek().children.add(tmp);
                queue.add(tmp);

            }
        }
        return root.children.get(0);
    }
}
