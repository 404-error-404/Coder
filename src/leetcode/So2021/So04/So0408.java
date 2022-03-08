package leetcode.So2021.So04;

public class So0408 {
	public static void main(String[] args) {
		System.out.print(findMin(new int[] {4,5,6,7,0,1,2}));
	}
	
    public static int findMin(int[] nums) {
    	int min = nums[0];
    	for(int i: nums) {
    		min = min > i? i: min;
    	}
    	return min;
    }
}
