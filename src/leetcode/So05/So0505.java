package leetcode.So05;

import java.util.*;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除每个等于nums[i] - 1或nums[i] + 1的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/5/5 16:31
 **/
public class So0505 {
    /**
     * 首先将数组初始化，使用map存放每个元素出现的次数，并且使用新数组num升序记录不重复的元素
     * 然后就是动态规划了
     * f[]记录动态规划的状态
     * f[i]表示前i个元素中可以获得的最大点数
     * 则第i+1个元素可获得最大点数为<i-1最大点数加上i+1元素的点数，i的最大点数>中的最大值
     * @param nums 原始数组
     * @return 可获得的最大点数
     */
    public int deleteAndEarn(int[] nums) {
        // 使用TreeMap，记录结果升序排序
        Map<Integer, Integer> map = new TreeMap<>();
        // 对每个数字计数
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // 获取升序排序且不重复的数字
        int len = map.keySet().size();
        int[] num = new int[len];
        int numIndex = 0;
        for (int i: map.keySet()){
            num[numIndex] = i;
            numIndex++;
        }
        // 记录长度声明动态规划的状态数组
        int[] f = new int[len];
        // 初始化第一个
        f[0] = map.get(num[0]) * num[0];
        // 如果只有一个则直接返回
        if(len == 1){
            return f[0];
        }
        // 否则初始化第二个
        if(num[1] == num[0]+1){
            f[1] = Math.max(f[0], map.get(num[1]) * num[1]);
        }
        else {
            f[1] = f[0] + map.get(num[1]) * num[1];
        }
        // 从第三个开始遍历num数组，直到最后
        // 状态转移方程：
        // 如果num[i]与num[i-1]相差1，则取f[i-2] 加 num[i]所代表点数与f[i-1]的最大值
        // 不相邻则直接f[i-1]加上num[i]所代表的点数
        for(int i = 2; i < len; i++){
            if(num[i] == num[i-1]+1){
                f[i] = Math.max(f[i-1], f[i-2] + map.get(num[i]) * num[i]);
            }
            else {
                f[i] = f[i-1] + map.get(num[i]) * num[i];
            }
        }
        return f[len-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,4,6};
        System.out.println(new So0505().deleteAndEarn(nums));
    }
}
