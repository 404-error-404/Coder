package leetcode.So04;

/**
 * @author 张佳乐
 * @date 2021/4/21 13:07
 **/
public class So0421 {
    public static int numDecoding(String s) {
        // c表示当前字符位置的可解释方案数
        // b表示当前字符前一个字符位置可解释方案数
        // a表示当前字符前两个位置可解释方案数，初始化为首字符可解释方案数
        int a = 1, b, c;
        int len = s.length();
        // 长度为0则解释为空字符串
        if(len == 0){ return 1; }
        // 0字符开头则返回0
        if(s.charAt(0) == '0'){ return 0; }
        // 长度为1则返回1
        if(len == 1){ return 1; }
        // 否则定义a和b
        // 次字符为0而首字符大于2直接返回
        if(s.charAt(0) > '2' && s.charAt(1) == '0'){ return 0; }
        int temp = 10 * (s.charAt(0) - '0') + s.charAt(1) - '0';
        if(temp > 26 || temp == 10 || temp == 20){
            b = 1;
        }
        else {
            b = 2;
        }
        c = b;
        for(int i = 2; i < len; i++){
            c = 0;
            // 如果当前位置字符非'0'（即可以单独解释为一个字符）则当前位置方案加上b
            if(s.charAt(i) != '0'){
                c += b;
            }
            else if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2') {
                return  0;
            }
            // 如果当前位置字符和前一个位置字符可以组成10到26以内字符，则当前位置方案加上a
            temp = 10 * (s.charAt(i-1) - '0') + s.charAt(i) - '0';
            if(temp <= 26 && temp >= 10){
                c += a;
            }
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(numDecoding("10"));
    }
}
