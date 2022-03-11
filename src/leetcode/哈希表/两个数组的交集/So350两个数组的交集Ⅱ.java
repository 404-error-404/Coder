package leetcode.哈希表.两个数组的交集;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/11 12:54
 */
public class So350两个数组的交集Ⅱ {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        // 双指针顺序遍历两个数组
        int idx1 = 0, idx2 = 0, i, j;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            i = nums1[idx1];
            j = nums2[idx2];
            if (i == j) {
                res.add(i);
                idx1++;
                idx2++;
            } else if (i < j) {
                idx1++;
            } else {
                idx2++;
            }
        }
        int[] ans = new int[res.size()];
        i = 0;
        for (; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
