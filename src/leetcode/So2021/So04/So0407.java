package leetcode.So2021.So04;

public class So0407 {
	public static void main(String[] args) {
		
	}
	
    public static boolean search(int[] nums, int target) {
    	for(int i: nums) {
    		if(target == i) {
    			return true;
    		}
    	}
    	return false;
    }
}
