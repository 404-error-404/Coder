package leetcode.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/17 23:47
 **/
public class So56合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (tmp[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], tmp[1]);
            } else {
                res.add(cur);
                cur = tmp;
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}
