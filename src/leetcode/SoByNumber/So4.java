package leetcode.SoByNumber;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @author 张佳乐
 * @date 2021/4/16 15:00
 **/
public class So4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] new_arr = new int[len];
        System.arraycopy(nums1, 0, new_arr, 0, len1);
        System.arraycopy(nums2, 0, new_arr, len1, len2);
        Arrays.sort(new_arr);
        if(len % 2 == 0){
            return (new_arr[len/2-1] + new_arr[len/2]) / 2.0;
        }
        else {
            return new_arr[len/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{6,7};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
