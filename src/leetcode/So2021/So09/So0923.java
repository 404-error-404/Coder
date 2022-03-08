package leetcode.So2021.So09;

import org.junit.jupiter.api.Test;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/9/23 17:47
 */
public class So0923 {
    public boolean isPowerOfThree(int n) {
        if (n == 1 || n == 3){
            return true;
        }
        int[] n3 = new int[50];
        n3[0] = 1;
        n3[1] = 3;
        int k;
        for (int i = 1; i < 50; i*=2){
            for (int j = 1; j <= i; j++){
                k = i + j;
                System.out.print(k + " ");
                n3[k] = n3[i] * n3[j];
                System.out.println(n3[k]);
                if(n3[k] == n){
                    return true;
                }
                else if(n3[k] > n){
                    return false;
                }
            }
        }
        return false;
    }

    @Test
    public void testIsPowerOfThree(){
        int n = 27*27*27*27*27*27*3;
        System.out.println(isPowerOfThree(n));
    }
}
