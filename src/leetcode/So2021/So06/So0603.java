package leetcode.So2021.So06;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * @author 小乐乐
 * @date 2021/6/3 15:59
 */
public class So0603 {
    /**
     * 计算含有相同数量的0和1的最长连续子数组
     * @param nums 给定数组
     * @return     子数组长度
     */
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        int len = nums.length;
        for (int i = 0; i < len; i++){
            int num = nums[i];
            if(num == 1){
                counter++;
            }
            else {
                counter--;
            }
            if (map.containsKey(counter)){
                int prevIndex = map.get(counter);
                maxLen = Math.max(maxLen, i - prevIndex);
            }
            else {
                map.put(counter, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,0,0,0,1,1};
        System.out.println(
                new So0603().findMaxLength(nums)
        );
    }
}
