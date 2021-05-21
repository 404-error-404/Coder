package leetcode.So05;

/**
 * @author 张佳乐
 * @date 2021/5/21 20:46
 **/
public class So0521 {
    /**
     * 求最长公共子串长度
     * @param nums1 第一排的数字
     * @param nums2 第二排的数字
     * @return      最长公共子串长度
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // dp[i][j]表示nums1[0:i]和nums2[0:j]的最长公共子串长度
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,4,2};
        int[] arr2 = new int[]{1,2,4};
        System.out.println(
                new So0521().maxUncrossedLines(arr1, arr2)
        );
    }
}
