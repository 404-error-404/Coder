package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 * <p>
 * https://leetcode.cn/problems/single-number-ii/description/
 *
 * @author 小乐乐
 * @date 2023/10/15 15:21
 **/
public class So137只出现一次的数字Ⅱ {
    /**
     * 对所有数字，计算其二进制数字每一位上出现的次数，最后再转为数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int n : nums) {
            // 取n中每一位数字，记录其出现次数
            for (int i = 0; i < 32; i++) {
                count[i] += (n >> i) & 1;
                count[i] %= 3;
            }
        }
        int res = 0;
        if (count[31] == 1) {    // 负数，此时存的是补码
            for (int i = 0; i < 31; i++) {
                count[i] = 1 - count[i];
            }
        }
        for (int i = 30; i >= 0; i--) {
            res = res * 2 + count[i];
        }
        if (count[31] == 1) {
            res = -res - 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{2, 2, 15465, 2}));
    }
}
