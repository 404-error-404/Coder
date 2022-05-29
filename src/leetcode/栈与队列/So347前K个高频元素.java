package leetcode.栈与队列;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/4/25 15:54
 */
public class So347前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o2[1] - o1[1]);
        Map<Integer, Integer> count = new HashMap<>(nums.length);
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        count.forEach((key, value) -> pq.add(new int[]{key, value}));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(pq.poll())[0];
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
