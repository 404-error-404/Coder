package leetcode.So06;

/**
 * @author Administrator
 * @date 2021/6/1 8:14
 */
public class So0601 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++){
            ans[i] = canEatDay(candiesCount, queries[i]);
        }
        return ans;
    }

    public boolean canEatDay(int[] candiesCount, int[] query){
        int candiesSum = 0;
        for(int i = 0; i < query[0]; i++){
            candiesSum += candiesCount[i];
        }
        if(candiesSum + candiesCount[query[0]] < query[1]+1){
            // 糖果吃不到指定日子
            return false;
        }
        // 前i-1个的糖果在指定日期前吃不完
        return candiesSum < query[2] * (query[1] + 1);
    }

    public static void main(String[] args) {
        String[] str1 = "[false,true,false,false,false,false,false,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false,true,true,false,false,true,false,false,false,false,false,false,false,false,true,true,true,true,true,true,true,true,true,true,true,false,false,false,true,false,true,false,true,true,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,false,true,true,false,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,false,true,false]".split(",");
        String[] str2 = "[false,true,true,false,true,false,false,false,false,false,true,false,true,true,true,false,false,false,false,true,false,false,true,true,false,false,true,false,false,false,false,false,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,false,true,true,false,true,true,true,true,true,true,true,false,true,true,true,true,true,true,true,true,false,true,false]".split(",");
        for(int i = 0; i < str1.length; i++){
            if (!str1[i].equals(str2[i])){
                System.out.println(i);
            }
        }
        int[] candiesCount = new int[]{5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114};
        int[][] queries = new int[][]{
                {91,244597,840227137},
                {3,1,2},
                {4,10,3},
                {3,10,100},
                {4,100,30},
                {1,3,1}
        };
        boolean[] res = new So0601().canEat(candiesCount, queries);
        for(boolean r: res){
            System.out.println(r);
        }
    }
}