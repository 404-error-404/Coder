package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/10/4 18:53
 */
public class So260只出现一次的数字Ⅲ {
    public int[] singleNumber(int[] nums) {
        // 异或
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        // 这里求最后一个二进制为1的数字可以mask = xor & -xor
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }
        int[] res = new int[2];
        for (int n : nums) {
            if ((n & mask) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }

    public int[] singleNumber2(int[] nums) {
        // 哈希表
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        int[] res = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                res[idx] = entry.getKey();
                idx++;
            }
            if (idx == 2) {
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        singleNumber(nums);
    }
}
