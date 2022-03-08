package leetcode.So2021.So04;

/**
 * @author 小乐乐
 * @date 2021/4/29 16:54
 */
public class So0428 {
    public static boolean judgeSquareSum(int c) {
        long a = (int)Math.sqrt(c);
        while (a >= 0){
            double b = Math.sqrt(c - a*a);
            if(b == (int)b){
                return true;
            }
            a--;
        }
        return false;
    }
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            System.out.println(judgeSquareSum(i));
        }
    }
}
