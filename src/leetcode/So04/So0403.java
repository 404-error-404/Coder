package leetcode.So04;

public class So0403 {
	public static void main(String[] args) {
		System.out.print(longestCommonSubsequence("area", "arffffffe"));
	}
	
	public static int longestCommonSubsequence(String text1, String text2){
		int len1 = text1.length();
		int len2 = text2.length();
		int[][] dp = new int[len1+1][len2+1];
		
		for(int i = 1; i <= len1; i++) {
			char c1 = text1.charAt(i-1);
			for (int j = 1; j <= len2; j++) {
				if (c1 == text2.charAt(j-1)){
					dp[i][j] =  dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
				}
			}
		}
		
		return dp[len1][len2];
	}
}
