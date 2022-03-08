package leetcode.So2021.So04;

/**
 * 运行超时
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii/solution/cun-zai-zhong-fu-yuan-su-iii-by-leetcode-bbkt/
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/4/17 9:57
 **/
public class So0417 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for (int j = i + 1; j <= Math.min(k + i, len - 1); j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 1));
    }
}