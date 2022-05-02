package leetcode.二叉树;

import leetcode.Node;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/2 15:55
 **/
public class So559N叉树的最大深度 {
    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                queue.addAll(queue.remove().children);
            }
        }
        return depth;
    }

    @Test
    public void test() {
        String s = "[48,null,79,0,94,null,null,44,64,null,69,71,46,null,null,45,null,2,9,22,null,57,77,31,null,8,56,1,null,59,86,0,null,null,100,99,67,null,69,79,24,null,2,66,null,11,76,null,null,95,58,78,null,97,53,null,100,null,42,null,38,99,54,null,21,12,23,null,34,39,null,null,null,null,null,100,82,null,81,41,null,null,null,21,59,null,null,null,12,16,null,null,null,57,99,null,69,73,31,null,30,66,50,null,34,null,5,11,60,null,null,32,97,16,null,27,null,null,34,92,null,66,39,85,null,6,null,66,null,62,null,60,null,null,95,91,null,32,null,null,5,null,null,9,27,null,36,null,98,10,null,null,null,98,null,68,4,null,null,1,null,82,78,null,null,87,93,null,70,73,69,null,18,15,null,19,null,100,64,null,40,52,null,49,78,null,35,null,null,38,1,null,45,21,47,null,null,83,null,37,null,8,65,8,null,46,65,23,null,47,87,null,92,41,29,null,null,96,14,null,79,41,null,null,90,32,null,92,51,null,96,80,98,null,86,null,null,53,45,null,78,57,3,null,98,6,null,null,70,null,27,14,42,null,24,null,37,91,null,38,48,8,null,null,56,32,53,null,33,null,55,8,75,null,17,39,92,null,null,60,44,9,null,null,63,35,11,null,19,52,61,null,71,55,null,53,95,0,null,null,27,67,null,null,11,null,null,96,null,29,null,75,40,15,null,93,null,21,13,null,null,null,83,59,59,null,72,null,100,98,null,null,41,null,null,2,96,16,null,40,66,null,null,null,32,null,99,2,54,null,2,4,68,null,25,null,null,27,8,57,null,42,null,25,48,null,28,17,99,null,84,64,86,null,22,null,7,42,28,null,40,59,14,null,6,12,42,null,null,null,null,null,75,null,12,null,78,10,61,null,40,null,52,null,null,null,54,56,null,26,53,null,82,null,null,68,59,4,null,90,null,78,87,null,79,null,85,null,90,58,null,10,null,null,87,null,78,null,76,null,null,86,null,46,53,null,20,21,51,null,null,79,50,69,null,94,null,null,20,3,null,24,87,null,52,81,33,null,null,null,57,90,21,null,56,null,52,66,null,76,94,null,78,85,null,65,91,null,19,null,71,null,null,84,36,null,38,null,null,63,1,71,null,38,93,null,27,null,50,null,39,null,80,24,null,67,60,null,41,19,87,null,29,86,98,null,79,33,57,null,89,36,null,30,null,13,null,17,93,null,null,null,null,null,17,null,79,null,44,null,34,null,12,3,54,null,null,null,71,33,null,9,0,null,89,0,null,0,null,80,14,null,52,null,45,18,null,89,null,null,13,null,71,46,91,null,null,1,77,52,null,5,null,36,null,47,65,69,null,null,83,91,null,59,null,75,90,null,35,null,22,55,null,56,7,null,77,100,34,null,73,23,null,7,null,86,59,43,null,75,98,58,null,55,53,null,76,null,9,62,null,71,43,null,null,67,null,61,44,48,null,69,69,null,39,null,41,65,52,null,39,39,20,null,null,null,null,6,77,83,null,11,97,null,81,null,null,64,7,null,50,9,0,null,47,76,34,null,null,30,16,null,null,null,3,94,53,null,61,23,null,100,12,null,77,6,null,32,5,null,null,82,50,47,null,76,39,72,null,null,84,8,null,21,49,null,17,12,16,null,33,null,null,2,57,null,60,24,null,88,27,null,null,null,48,88,55,null,88,72,28,null,24,64,41,null,56,16,null,45,13,16,null,null,64,19,35,null,null,45,81,null,6,29,84,null,66,null,null,null,null,65,null,null,19,61,null,null,null,68,50,null,14,null,null,11,null,68,66,23,null,null,33,79,null,63,null,null,74,71,null,49,null,1,null,18,7,58,null,40,34,null,37,44,null,null,89,null,88,null,null,69,null,80,64,null,0,34,11,null,69,40,81,null,42,71,null,42,10,null,null,98,49,17,null,42,96,null,16,64,null,92,null,39,41,null,43,84,null,null,32,57,50,null,68,null,null,null,59,13,43,null,null,41,null,5,null,58,null,84,16,null,42,null,42,37,40,null,64,51,null,34,null,4,null,61,27,null,21,null,88,null,71,null,47,23,30,null,null,46,null,13,null,64,56,27,null,43,39,95,null,99,74,null,65,82,null,null,28,75,null,15,0,75,null,77,73,null,45,93,null,11,15,null,null,79,33,23,null,8,17,76]";
//        s = "[1,null,3,2,4,null,5,6]";
        Node root = Node.strToNode(s);
        System.out.println(maxDepth(root));
    }
}
