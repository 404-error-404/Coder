package leetcode.贪心;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/14 19:26
 */
public class So135分发糖果 {
    public int candy(int[] ratings) {
        // TODO 方法很巧，可以再做一遍
        // 临时存储相对值，可以为负数
        int[] res = new int[ratings.length];
        res[0] = 1;
        // 从左向右扫描，保证右侧大于左侧
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }
        // 从右向左扫描，保证左侧大于右侧
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        return Arrays.stream(res).sum();
    }

    @Test
    public void test() {
        int[] ratings = new int[]{1, 3, 4, 5, 2};
        System.out.println(candy(ratings));
    }
}
