package leetcode.So03;

import java.util.*;

class So0328 {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[] {10,1,1,6,6,6,1,8,8,5,1,2,6,6,6,4,4,8,7,1};
        // {151,42,769,349,835,92,242,82,357,494,880,683,470,631,479,298,941,113,892,103,755,575,885,50,479,502,181,164,292,832,657,512,528,588,716,965,195,106,396,649}
        System.out.print(movesToMakeZigzag(arr));
    }
    public static int movesToMakeZigzag(int[] nums) {
        int nSize = nums.length;
        if (nSize < 2) {
            return 0;
        }
        int[] nums2 = Arrays.copyOf(nums, nSize);
        int max1 = 0, max2 = 0;
        // 先计算偶数大的情况
        for(int i = 0; i < nSize - 2; i+=2){
            if(nums[i] <= nums[i+1]){
                max1 += nums[i+1] - nums[i] + 1;
                nums[i+1] = nums[i] - 1;
            }
            if(nums[i+1] >= nums[i+2]){
                max1 += nums[i+1] + 1 - nums[i+2];
                nums[i+1] = nums[i+2] - 1;
            }

            // 再计算奇数大的情况
            if(nums2[i] >= nums2[i+1]){
                max2 += nums2[i] + 1 - nums2[i+1];
                nums2[i] = nums2[i+1] - 1;
            }
            if(nums2[i+1] <= nums2[i+2]){
                max2 += nums2[i+2] - nums2[i+1] + 1;
                nums2[i+2] = nums2[i+1] - 1;
            }
        }
        if(nSize % 2 == 0) {
            // 数组长度为偶数数时要多算一次奇数大最后一位
            if (nums[nSize-1] >= nums[nSize-2]) {
                max1 += nums[nSize-1] - nums[nSize-2] + 1;
            }
            // 再计算偶数数大的最后一位
            if(nums2[nSize-2] >= nums2[nSize-1]){
                max2 += nums2[nSize-2] + 1 - nums2[nSize-1];
                nums2[nSize-2] = nums2[nSize-1] - 1;
            }
        }
        return Math.min(max1, max2);
    }
}