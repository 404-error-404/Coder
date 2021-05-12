package leetcode.So05;

import java.util.Arrays;

/**
 * @author 张佳乐
 * @date 2021/5/12 15:45
 */
public class So0512 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        // arrXor[i]表示arr数组中0~i个元素连续异或的结果
        int[] arrXor = new int[arr.length];
        arrXor[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            arrXor[i] = arrXor[i-1] ^ arr[i];
        }
        for(int i = 0; i < queries.length; i++){
            ans[i] = arrXor[queries[i][0]] ^ arrXor[queries[i][1]] ^ arr[queries[i][0]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{
                {0,1},
                {1,2},
                {0,3},
                {3,3},
        };
        System.out.println(
                Arrays.toString(new So0512().xorQueries(arr, queries))
        );
    }
}
