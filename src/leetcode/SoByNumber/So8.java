package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

/**
 *
 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

 函数 myAtoi(string s) 的算法如下：

 读入字符串并丢弃无用的前导空格
 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 返回整数作为最终结果。
 注意：

 本题中的空白字符只包括空格字符 ' ' 。
 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * @author 张佳乐
 * @date 2021/9/25 21:41
 **/
public class So8 {
    public int myAtoi(String s) {
        char[] sc = s.toCharArray();
        // 忽略前导空格
        int begin = 0;
        for(; begin < sc.length; begin++){
            if (sc[begin] != ' '){
                break;
            }
        }
        if (sc.length == begin){
            return 0;
        }
        // 记录符号位
        int op = 1;
        if (sc[begin] == '-'){
            op = -1;
            begin++;
        }
        else if (sc[begin] == '+'){
            begin++;
        }
        // 忽视数字开头的0
        for (; begin < sc.length; begin++){
            if (sc[begin] != '0'){
                break;
            }
        }
        long ans = 0L;
        // 开始读取数字，注意因为最大的int数字是10位的，所以这里最多往后读取10位
        int count = 0;
        for (; begin < sc.length; begin++){
            count++;
            if ('0' <= sc[begin] && sc[begin] <= '9'){
                ans = 10 * ans + sc[begin] - '0';
            }
            else {
                break;
            }
            if(count > 11){
                break;
            }
        }
        ans *= op;
        if (ans >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if (ans <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else {
            return (int) ans;
        }
    }

    @Test
    public void testMyAutoi(){
        String[] s = {
                " ",
                "+",
                " ",
                "000000000000000000",
                " 454 s"
        };
        for (String ss: s){
            System.out.println(myAtoi(ss));
        }
    }
}
