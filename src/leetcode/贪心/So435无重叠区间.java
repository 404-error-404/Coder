package leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/15 23:41
 **/
public class So435无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[1]));
        int last = -50001;
        int res = 0;
        for (int[] interval : intervals) {
            if (interval[0] < last) {
                res++;
            } else {
                last = interval[1];
            }
        }
        return res;
    }
}
