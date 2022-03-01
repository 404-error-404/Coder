package leetcode.So05;

/**
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/24 13:49
 */
public class So0524 {
    /**
     * 计算打印指定字符串需要的次数
     * @param s 指定的字符串
     * @return  需要打印的次数
     */
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] f = new int[len][len];
        for(int i = len-1; i >= 0; i--){
            f[i][i] = 1;
            for(int j = i+1; j < len; j++){
                if(s.charAt(j) == s.charAt(i)){
                    f[i][j] = f[i][j-1];
                }
                else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(
                new So0524().strangePrinter("aba ")
        );
    }
}
