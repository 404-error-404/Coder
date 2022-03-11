package leetcode.哈希表.两个数组的交集;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/11 12:28
 */
public class So349两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            s2.add(i);
        }
        if (s1.size() > s2.size()) {
            Set<Integer> temp = s1;
            s1 = s2;
            s2 = temp;
        }
        Set<Integer> common = new HashSet<>();
        for (int i : s1) {
            if (s2.contains(i)) {
                common.add(i);
            }
        }
        int[] res = new int[common.size()];
        int index = 0;
        for (int i : common) {
            res[index] = i;
            index++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
