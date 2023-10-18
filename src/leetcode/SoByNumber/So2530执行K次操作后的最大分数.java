package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * <p>
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * https://leetcode.cn/problems/maximal-score-after-applying-k-operations/
 *
 * @author 小乐乐
 * @date 2023/10/18 20:23
 **/
public class So2530执行K次操作后的最大分数 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        long res = 0L;
        for (int i = 0; i < k; i++) {
            int tmp = pq.poll();
            res += tmp;
            pq.add((tmp + 2) / 3);
        }
        return res;
    }

    @Test
    public void test() {
        long res = maxKelements(new int[]{1, 2, 3}, 2);
        System.out.println(res);
    }
}
