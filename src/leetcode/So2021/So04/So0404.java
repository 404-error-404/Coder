package leetcode.So2021.So04;

import java.util.*;

public class So0404 {
	public static void main(String[] args) {
		int[] nums = new int[] {10,20,30};
		System.out.print(numRabbits(nums));
	}
	
    public static int numRabbits(int[] answers) {
    	int sum = 0;
    	Map<Integer, Integer> rabbitMap = new HashMap<>();
    	// 统计回答i的兔子的数量
    	for(int i: answers) {
    		rabbitMap.put(i, rabbitMap.getOrDefault(i, 0)+1);
    	}
    	
    	// 计算
    	for(Map.Entry<Integer, Integer> entry: rabbitMap.entrySet()) {
    		int x = entry.getKey(), y = entry.getValue();
    		// 计算当前回答同样数字的兔子最少有多少中不同的颜色
    		// 如：回答1的有3只兔子，则可能是 红红和蓝，但是另一只蓝兔子没有回答 
    		sum += (x+y) / (x+1) * (x+1);
    	}
    	
        return sum;
    }
}
