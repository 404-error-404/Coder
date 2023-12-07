package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
 * <p>
 * 每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。
 * <p>
 * 给定路径的 价格总和 是该路径上所有节点的价格之和。
 * <p>
 * 另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何你喜欢的路径前往节点 endi 。
 * <p>
 * 在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。
 * <p>
 * 返回执行所有旅行的最小价格总和。
 * <p>
 * https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/description
 **/
class TreeNode {
    int val;
    int price;
    int halfPrice;
    TreeNode parent;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(int val, int price) {
        this.val = val;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

class LinkNode {
    int val;
    LinkNode pre;

    public LinkNode(int val, LinkNode pre) {
        this.val = val;
        this.pre = pre;
    }
}

public class So2646最小化旅行的价格总和 {
    TreeNode[] nodes;

    public LinkNode bfs(int target, List<LinkNode> toTraverse, Set<Integer> hasTraverse, Map<Integer, Integer> count) {
        List<LinkNode> nextTraverse = new ArrayList<>();
        for (LinkNode linkNode : toTraverse) {
            // 当前待遍历节点
            TreeNode cur = this.nodes[linkNode.val];
            if (hasTraverse.contains(cur.val)) {
                continue;
            } else if (cur.val == target) {
                count.put(cur.val, count.get(cur.val) + 1);
                return linkNode.pre;
            }
            hasTraverse.add(cur.val);
            if (cur.parent != null) {
                nextTraverse.add(new LinkNode(cur.parent.val, linkNode));
            }
            for (TreeNode child : cur.children) {
                nextTraverse.add(new LinkNode(child.val, linkNode));
            }
        }

//        for (Integer[] integers : toTraverse) {
//            // 当前待遍历节点
//            TreeNode cur = this.nodes[integers[0]];
//            // 改节点上一步节点
//            TreeNode pre = this.nodes[integers[1]];
//            if (cur == null || hasTraverse.contains(cur.val)) {
//                continue;
//            } else if (cur.val == target) {
//                count.put(cur.val, count.get(cur.val) + 1);
//                return pre.val;
//            }
//            hasTraverse.add(cur.val);
//            nextTraverse.add(new Integer[]{cur.parent.val, cur.val});
//            for (TreeNode child : cur.children) {
//                nextTraverse.add(new Integer[]{child.parent.val, cur.val});
//            }
//        }

        LinkNode tmp = bfs(target, nextTraverse, hasTraverse, count);
        if (tmp != null) {
            count.put(tmp.val, count.get(tmp.val) + 1);
            return tmp.pre;
        }
        return null;
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        for (TreeNode child : root.children) {
            postOrder(child);
        }
        int price = root.price, halfPrice = root.price / 2;
        for (TreeNode child : root.children) {
            halfPrice += child.price;
            price += Math.min(child.price, child.halfPrice);
        }
        root.price = price;
        root.halfPrice = halfPrice;
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        // 初始化，构造树
        int[][] grids = new int[n][n];
        for (int[] edge : edges) {
            grids[edge[0]][edge[1]] = 1;
            grids[edge[1]][edge[0]] = 1;
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (Arrays.stream(grids[i]).sum() == 1) {
                root = i;
                break;
            }
        }

        this.nodes = new TreeNode[n];

        for (int i = 0; i < n; i++) {
            this.nodes[i] = new TreeNode(i, price[i]);
        }
        List<Integer> to_build = new ArrayList<>();
        to_build.add(root);
        while (!to_build.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : to_build) {
                for (int j = 0; j < n; j++) {
                    if (grids[i][j] == 1 && this.nodes[j].parent == null && this.nodes[j].val != root) {
                        this.nodes[i].children.add(nodes[j]);
                        this.nodes[j].parent = this.nodes[i];
                        tmp.add(j);
                    }
                }
            }
            to_build = tmp;
        }
        // 初始化完成，构造树根节点值存储在root变量中

        // 广度优先遍历树，找到各个旅行的最短路径，对经过的节点计数，存放在count中
        Map<Integer, Integer> count = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            count.put(i, 0);
        }
        for (int[] trip : trips) {
            List<LinkNode> toTraverse = new ArrayList<>();
            toTraverse.add(new LinkNode(trip[0], null));
            bfs(trip[1], toTraverse, new HashSet<>(n), count);
        }

        // 更新节点的值
        for (int i = 0; i < n; i++) {
            this.nodes[i].price *= count.get(i);
        }

        // 后序遍历，求出每个节点折半与不折半的价值
        postOrder(this.nodes[root]);
        return Math.min(this.nodes[root].price, this.nodes[root].halfPrice);
    }

    @Test
    public void test() {
        // res = 23
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}};
        int[] price = {2, 2, 10, 6};
        int[][] trips = {{0, 3}, {2, 1}, {2, 3}};

        // res = 29;
        n = 5;
        edges = new int[][]{{2, 0}, {3, 1}, {1, 0}, {0, 4}};
        price = new int[]{2, 16, 4, 16, 6};
        trips = new int[][]{{4, 3}};

        // res = 1
        n = 1;
        edges = new int[][]{};
        price = new int[]{2};
        trips = new int[][]{{0, 0}};
        int res = minimumTotalPrice(n, edges, price, trips);
        System.out.println(res);
    }
}
