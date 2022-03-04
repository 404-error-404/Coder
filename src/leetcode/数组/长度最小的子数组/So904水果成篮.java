package leetcode.数组.长度最小的子数组;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fruit-into-baskets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/3 15:43
 */
public class So904水果成篮 {
    private int getMax(List<Tree> trees, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += trees.get(i).count;
        }
        return count;
    }

    public int totalFruit(int[] fruits) {
        // 将连续相同的树合并到一块
        List<Tree> trees = new ArrayList<>();
        Tree tree;

        int count = 1;
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i] != fruits[i - 1]) {
                tree = new Tree(fruits[i - 1], count);
                trees.add(tree);
                count = 1;
            } else {
                count++;
            }
        }
        trees.add(new Tree(fruits[fruits.length - 1], count));

        // 遍历合并后的块
        if (trees.size() == 1) {
            return trees.get(0).count;
        }
        int fast = 1;
        int slow = 0;
        // 保存慢指针的水果和可能存在的另一个水果
        int slowFruit = trees.get(0).fruit;
        int anotherFruit = -1;
        int max = trees.get(0).count + trees.get(1).count;
        for (; fast < trees.size(); fast++) {
            tree = trees.get(fast);
            if (tree.fruit != slowFruit) {
                if (anotherFruit == -1) {
                    anotherFruit = tree.fruit;
                } else if (tree.fruit != anotherFruit) {
                    max = Math.max(max, getMax(trees, slow, fast - 1));
                    slow = fast - 1;
                    slowFruit = trees.get(slow).fruit;
                    anotherFruit = tree.fruit;
                    while (trees.get(slow).fruit == slowFruit) {
                        slow--;
                    }
                    slow++;
                }
            }
        }
        max = Math.max(max, getMax(trees, slow, fast - 1));
        return max;
    }

    @Test
    public void test() {
        int[] fruits = new int[]{0, 1, 1, 4, 3};
        System.out.println(totalFruit(fruits));
    }

    private static class Tree {
        int fruit;
        int count;

        public Tree(int fruit, int count) {
            this.fruit = fruit;
            this.count = count;
        }
        @Override
        public String toString(){
            return "(" + fruit + ", " + count + ")";
        }
    }
}
