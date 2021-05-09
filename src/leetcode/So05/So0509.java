package leetcode.So05;

import java.util.Arrays;

/**
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 *
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 *
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 *
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/5/9 10:38
 **/
public class So0509 {
    /**
     * 检查能否在day天内制作花束
     * @param bloomDay  花开日期
     * @param m         要制作花束数量
     * @param k         每束花需要的相邻花的数量
     * @return          能否制作花束
     */
    public int minDays(int[] bloomDay, int m, int k) {
        // 先检查花束总数能否制作m束花
        if(bloomDay.length < m*k) {return -1;}
        int l = Arrays.stream(bloomDay).min().orElse(-1);
        int r = Arrays.stream(bloomDay).max().orElse(-1);
        while (l < r){
            int mid = (l+r) / 2;
            if(check(bloomDay, m, k, mid)){
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 检查能否在day天内制作花束
     * @param bloomDay  花开日期
     * @param m         要制作花束数量
     * @param k         每束花需要的相邻花的数量
     * @param day       指定天数
     * @return          能否制作花束
     */
    boolean check(int[] bloomDay, int m, int k, int day){
        // 当前可以制作的花束数量
        int cur = 0;
        // 连续开放花朵计数
        int count = 0;
        // 遍历数组，计数可以开放的花朵
        for(int i: bloomDay){
            if(i <= day){
                count++;
            }
            else {
                cur += count / k;
                count = 0;
            }
        }
        return cur + count / k >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = new int[]{1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(new So0509().minDays(bloomDay, m, k));
    }
}
