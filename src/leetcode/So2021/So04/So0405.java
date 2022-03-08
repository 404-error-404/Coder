package leetcode.So2021.So04;

public class So0405 {
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2,3,4,0,0,0};
		int[] nums2 = new int[] {2,5,6};
		merge(nums1, 4, nums2, 3);
		for(int i: nums1) {
			System.out.print(i + " ");
		}
	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int[] res = new int[m + n];
    	int i = 0, j = 0;
    	while(i < m && j < n) {
    		if (nums1[i] < nums2[j] ) {
				res[i+j] = nums1[i];
				i++;
			}
    		else {
				res[i+j] = nums2[j];
				j++;
			}
    	}
    	while(i < m) {
    		res[i+j] = nums1[i++];
    	}
    	while(j < n) {
    		res[i+j] = nums2[j++]; 
    	}
    	nums1 = res;
//		省空间费时间的写法
//    	int i = 0, now = 0;
//    	while(i < n && now < m + i) {
//    		if(nums2[i] < nums1[now]) {
//    			// 把nums2[i]的值，插入到now的位置
//    			for(int j = m+i; j > now; j--) {
//    				nums1[j] = nums1[j-1];
//    			}
//    			nums1[now] = nums2[i]; 
//    			i++;
//    		}
//			now++;
//    	}
//    	while(i < n) {
//    		nums1[now] = nums2[i];
//    		now++;
//    		i++;
//    	}
    }
}
