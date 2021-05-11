package leetcode.So04;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/

/**
 * @author WHU-LiXiaoJian
 */
public class So0406 {

	public static void main(String[] args) {
		int[] arrs = new int[] {1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,45};
		System.out.println(removeDuplicates(arrs));
		for(int i: arrs) {
			System.out.print(i + " ");
		}
	}
    public static int removeDuplicates(int[] nums) {
		// 分别指向当前待确定位置数字和当前扫描位置，从1开始
    	int now = 1, pre = 1;
		// 对当前数字进行计数
    	int count = 1;
    	int temp = nums[0];
    	while(pre != nums.length) {
    		if(nums[pre] == temp) {
    			count++;
    			if(count > 2) {
    				temp  = nums[pre];
    				pre++;
    				continue;
    			}
    		}
    		else {
    			count = 1;
    		}
    		nums[now] = nums[pre];
    		temp  = nums[pre];
			pre++;
			now++;
    	}
    	return now;
    }
}
