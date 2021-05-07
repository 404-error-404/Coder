package leetcode.So04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/frog-jump/
 * @author 张佳乐
 * @date 2021/4/29 13:50
 */
public class So0429 {
    public static boolean canCross(int[] stones) {
        if(stones[1] != 1){return false;}
        int len = stones.length;
        // 存储到达每个石头时可以走的步数并初始化第一个石头
        Map<Integer, Set<Integer>> stonesStep = new HashMap<>(len);
        for (int stone: stones) {
            stonesStep.put(stone, new HashSet<>());
        }
        // 初始化第一块石头，和第二块石头
        stonesStep.get(0).add(1);
        stonesStep.get(1).add(1);
        for (int i = 1; i < len; i++) {
            for (int step : calculateSteps(stonesStep.get(stones[i]))) {
                int targetStone = stones[i] + step;
                if (stonesStep.containsKey(targetStone)) {
                    stonesStep.get(targetStone).add(step);
                }
            }
        }
        return !stonesStep.get(stones[len - 1]).isEmpty();
    }

    public static Set<Integer> calculateSteps(Set<Integer> step){
        Set<Integer> stepSet = new HashSet<>();
        for (int i: step){
            if(i > 1){
                stepSet.add(i-1);
            }
            stepSet.add(i);
            stepSet.add(i+1);
        }
        return stepSet;
    }

    public static void main(String[] args) {
        boolean res = canCross(new int[]{0,2});
        System.out.println(res);
    }
}
