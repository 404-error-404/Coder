package leetcode.So2021.So04;

import java.util.Arrays;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * @author 小乐乐
 * @date 2021/4/26 10:16
 **/
public class So0426 {
    public static int shipWithinDays(int[] weights, int D) {
        // 初始化左边界为最大箱子重量，右边界为总和
        int left = Arrays.stream(weights).max().getAsInt();
        int right = 0;
        for (int weight : weights) {
            right += weight;
        }
        // 不断折半查找能在D天内装好的最大箱子
        while (left < right){
            int mid = (right + left) / 2;
            int cur = 0, need = 1;
            // 判断mid能否在D天内装好
            for(int i: weights){
                if(cur + i > mid){
                    need++;
                    cur = 0;
                }
                cur += i;
            }
            if(need <= D){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int num = 5;
        System.out.print(shipWithinDays(arr, num));
    }
}
