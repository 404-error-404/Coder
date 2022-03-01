package leetcode.So04;

/**
 * @author 小乐乐
 * @date 2021/4/18 9:41
 **/
public class So0418 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // 新数组长度
        int new_len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[new_len++] = nums[i];
            }
        }
        return new_len;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,1,1,1,1,1,1,1,1,1,2,2,3,3,4,4,5,5,6};
        arr = new int[]{};
        int len = removeDuplicates(arr);
        System.out.println(len);
        for(int i = 0; i < len; i++){
            System.out.print(arr[i]);
        }
    }
}
