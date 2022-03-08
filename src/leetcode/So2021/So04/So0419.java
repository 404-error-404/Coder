package leetcode.So2021.So04;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * @author WHU-LiXiaoJian
 */
public class So0419 {
    public static int removeElement(int[] nums, int val) {
    	int len = nums.length-1;
    	int begin = 0;
    	while(begin <= len) {
    		if(nums[len] == val) {
				len--;
			}
    		else if(nums[begin] != val) {
    			begin++;
    		}
    		else {
				nums[begin] = nums[len];
				nums[len] = val;
			}
    	}
    	return len+1;
    }
    
    public static void main(String[] args) {
    	int[] arr = new int[] {3,2,2,3};
		int len = removeElement(arr, 3);
		for(int i = 0; i < len; i++) {
			System.out.print(arr[i] + " " );
		}
	}
	
}
