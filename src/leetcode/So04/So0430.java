package leetcode.So04;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * @author 小乐乐
 * @date 2021/4/30 11:40
 **/
public class So0430 {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(; i < nums.length-1; i+=3){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,2,0,1,0,1,0,1,6,6,6};
        System.out.print(singleNumber(nums));
    }
}
