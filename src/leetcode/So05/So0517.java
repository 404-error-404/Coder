package leetcode.So05;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/17 9:26
 **/
public class So0517 {
    /**
     * 遍历树，将指定值下标序号的值标记为他的深度，同时检测是否为亲兄弟结点
     * @param root 根结点
     * @param x    指定节点值一
     * @param y    指定节点值二
     * @return     是否为堂兄弟节点
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] nodeDepth = new int[101];
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur;
        while (!stack.empty()) {
            cur = stack.pop();
            if(null != cur.right && null != cur.left){
                if(check(cur.left.val, cur.right.val, x, y)){
                    return false;
                }
            }
            else {
                if (null != cur.left) {
                    stack.push(cur.left);
                    nodeDepth[cur.left.val] = nodeDepth[cur.val] + 1;
                }
                if (null != cur.right) {
                    stack.push(cur.right);
                    nodeDepth[cur.right.val] = nodeDepth[cur.val] + 1;
                }
            }
        }
        return nodeDepth[x] == nodeDepth[y];
    }

    /**
     * 检测x，y和m，n是否相等
     * @param x 第一组数的第一个
     * @param y 第一组数的第二个
     * @param m 第二组数的第一个
     * @param n 第二组数的第二个
     * @return  是否相等
     */
    boolean check(int x, int y, int m, int n){
        if(x == m && y == n){
            return true;
        }
        return x == n && y == m;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrToTreeNode(new int[]{1,2,3,-1,4});
        System.out.println(
                new So0517().isCousins(root, 2, 3)
        );
    }

}
