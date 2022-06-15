package leetcode.贪心;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/15 23:16
 **/
public class So452用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        // 对所有的气球排序，以end排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int last = points[0][1];
        for (int[] point : points) {
            if (point[0] > last) {
                last = point[1];
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] points = new int[][]{{10, 16}, {2, 8}, {5, 8}, {4, 8}, {1, 6}, {7, 12}};
        points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots(points));
    }
}
