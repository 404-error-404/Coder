package leetcode.So2021.So05;

/**
 * 有一个长度为arrLen的数组，开始有一个指针在索引0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数steps 和arrLen ，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模10^9 + 7 后的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/13 14:36
 */
public class So0513 {
    /**
     * 使用动态规划
     * @param steps  可以走的步数
     * @param arrLen 数组长度
     * @return       可以走的方案数量
     */
    public int numWays(int steps, int arrLen) {
        final int modulo = 1000000007;
        int maxColumn = Math.min(steps, arrLen-1);
        // dp[i][j]表示走了i步后，下标在j位置的方案数量
        int[][] dp = new int[steps+1][maxColumn+1];
        dp[0][0] = 1;
        for(int i = 1; i <= steps; i++){
            for (int j = 0; j <= maxColumn; j++){
                // 不动
                dp[i][j] += dp[i-1][j];
                // 右移
                if(j-1 >= 0){
                    dp[i][j] += dp[i-1][j-1];
                    dp[i][j] %= modulo;
                }
                // 左移
                if(j+1 <= maxColumn){
                    dp[i][j] += dp[i-1][j+1];
                    dp[i][j] %= modulo;
                }
            }
        }
        return dp[steps][0];
    }


    private int sum = 0;
    private int len = 0;

    /**
     * 使用递归，但会超时
     * @param steps  可以走的步数
     * @param arrLen 数组长度
     * @return       可以走的方案数量
     */
    public int dfsNumWays(int steps, int arrLen) {
        len = arrLen;
        dfs(steps, 0);
        return sum % (int)(Math.pow(10, 9) + 7);
    }

    public void dfs(int steps, int now){
        if(now == 0 && steps == 0){
            sum++;
            return;
        }
        if(now > steps){
            return;
        }
        // 左移
        if(now > 0){
            dfs(steps-1, now-1);
        }
        // 右移
        if(now < len - 1){
            dfs(steps-1, now+1);
        }
        // 不动
        dfs(steps-1, now);
    }

    public static void main(String[] args) {
        System.out.println(
                new So0513().numWays(4,2)
        );
        System.out.println(
                new So0513().dfsNumWays(4,2)
        );
    }
}
