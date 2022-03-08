package leetcode.So2021.So04;

public class So0402 {
	
	public static void main(String[] args) {
		int[] he = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.print(trap(he));
	}
	
    public static int trap(int[] height) {
		// 总的储水量
    	int sum = 0;
		// 数组长度
    	int len = height.length;
		// 记录当前位置左侧最高高度
    	int[] left_top = new int[len];
    	left_top[0] = 0;
		// 记录当前位置右侧最高高度
    	int[] right_top = new int[len];
    	right_top[len-1] = 0;
    	
    	// 下面更新每个元素两侧的最高高度
    	for(int i = 1; i < len; i++) {
    		left_top[i] = Math.max(left_top[i-1], height[i-1]);
    		right_top[len-1-i] = Math.max(right_top[len-i], height[len-i]);
    	}
    	// 根据两侧的最高高度来计算当前位置的储水量
    	for(int i = 1; i < len-1; i++) {
    		int water = Math.min(left_top[i], right_top[i]) - height[i];
    		if(water > 0) {
    			sum += water;
    		}
    	}
        return sum;
    }
}
