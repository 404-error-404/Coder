package bytedance;

import java.util.Scanner;

/**
 * 通过60%测试用例
 * @author 张佳乐
 * @date 2021/6/13 19:01
 **/
public class So061301 {
    public static void main(String[] args) {
        // 输入数据------------------------
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        // ----------------------------
        // 选中当前节点可以得到的最大值
        int[] value = new int[n];
        // 不选中当前节点可以得到的最大值
        int[] valueN = new int[n];
        // 找到最后一排起始下标
        int lastIndex = 0;
        while (lastIndex < n){
            lastIndex = (lastIndex + 1) * 2 - 1;
        }
        lastIndex = (lastIndex + 1) / 2 - 1;
        while (lastIndex > 0){
            calculate(value, valueN, nums, lastIndex);
            lastIndex /= 2;
        }
        calculate(value, valueN, nums, 0);
        System.out.println(Math.max(value[0], valueN[0]));
    }

    /**
     * 计算当前行节点对应的value值
     * @param value
     * @param nums
     * @param begin
     */
    static void calculate(int[] value, int[] valueN, int[] nums, int begin){
        for (int i = begin; i <= begin*2 && i < nums.length; i++){
            // 右孩子是
            int temp = (i+1)*2;
            // 计算包含当前节点的最大值
            int sum = nums[i];
            if(temp < nums.length){
                sum += valueN[temp] + valueN[temp-1];

                // 计算不包含当前节点的最大值
                int left = Math.max(value[temp-1], valueN[temp-1]);
                int right = Math.max(value[temp], valueN[temp]);
                valueN[i] = left + right;
            }
            value[i] = sum;
        }
    }
}
