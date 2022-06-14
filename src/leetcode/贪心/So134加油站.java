package leetcode.贪心;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/14 19:02
 */
public class So134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 对汽油预处理，计算每到一个地方的代价
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }
        // 判断整体能否走一整个环
        int sum = Arrays.stream(gas).sum();
        if (sum < 0) {
            return -1;
        }

        int start = 0;
        sum = 0;
        for (int i = start; i < gas.length; i++) {
            sum += gas[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return start;
    }

    @Test
    public void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        canCompleteCircuit(gas, cost);
    }
}
