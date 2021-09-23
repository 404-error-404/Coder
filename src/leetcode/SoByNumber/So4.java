package leetcode.SoByNumber;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/4/16 15:00
 **/
public class So4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] newArr = new int[len];
        System.arraycopy(nums1, 0, newArr, 0, len1);
        System.arraycopy(nums2, 0, newArr, len1, len2);
        Arrays.sort(newArr);
        if(len % 2 == 0){
            return (newArr[len/2-1] + newArr[len/2]) / 2.0;
        }
        else {
            return newArr[len/2];
        }
    }

    /**
     * 二分法求两个正序数组中位数
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int mid = len / 2;
        int index1 = 0, index2 = 0;
        int res = 0;
        while (true){
            if(index1 == len1){
                res = nums2[index2+mid-1];
                break;
            }
            if (index2 == len2){
                res = nums1[index1+mid-1];
                break;
            }
            if (mid == 1){
                res = Math.min(nums1[index1], nums2[index2]);
                break;
            }
            int half = mid / 2;
        }
        return 0.0;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{6,7};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
