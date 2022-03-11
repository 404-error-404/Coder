package leetcode.哈希表.四数相加;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/11 18:27
 */
public class So454四数相加 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int temp = i + j;
                int tempCount = sumMap.getOrDefault(temp, 0) + 1;
                sumMap.put(temp, tempCount);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                count += sumMap.getOrDefault(-i - j, 0);
            }
        }
        return count;
    }
}
