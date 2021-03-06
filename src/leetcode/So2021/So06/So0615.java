package leetcode.So2021.So06;

/**
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/6/15 11:47
 */
public class So0615 {
    public int peakIndexInMountainArray(int[] arr) {
        int max = arr.length-1;
        int min = 0;
        while (max != min){
            int mid = (max + min) / 2;
            if(arr[mid] > arr[mid+1]){
                max = mid;
            }
            if (arr[mid] > arr[mid-1]){
                min = mid;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0};
        System.out.println(
                new So0615().peakIndexInMountainArray(arr)
        );
    }
}
