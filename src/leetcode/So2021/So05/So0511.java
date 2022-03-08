package leetcode.So2021.So05;

import java.util.Arrays;

/**
 * 给你一个整数数组perm，它是前n个正整数的排列，且n是个 奇数。
 *
 * 它被加密成另一个长度为 n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。比方说，如果perm = [1,3,2]，那么encoded = [2,1]。
 *
 * 给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class So0511 {
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        // 求出前n个数的异或结果
        int total = 0;
        for(int i = 1; i <= len+1; i++){
            total ^= i;
        }
        // 求出perm数组中除了第一个数的异或结果
        int odd = 0;
        for(int i = 1; i < len; i+=2){
            odd ^= encoded[i];
        }
        // total和odd异或即为perm[0]
        int[] perm = new int[len+1];
        perm[0] = odd ^ total;
        for(int i = 0; i < len; i++){
            perm[i+1] = encoded[i] ^ perm[i];
        }
        return perm;
    }

    public static void main(String[] args) {
        int[] encoded = new int[]{6,5,4,6};
        System.out.println(
                Arrays.toString(new So0511().decode(encoded))
        );
    }

}
