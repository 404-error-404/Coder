package leetcode.So2021.So06;

/**
 * 有效数字（按顺序）可以分成以下几个部分：
 *
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 *
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 *
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/6/17 9:47
 */
public class So0617 {
    /**
     * 判断是否为有效数字
     * @param s 给定字符串
     * @return  是否为有效数字
     */
    public boolean isNumber(String s) {
        // 去除符号位
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            s = s.substring(1);
        }
        int indexE = s.indexOf('E');
        if(indexE < 0){
            indexE = s.indexOf('e');
        }
        if(indexE > 0){
            // e前边的字符串
            String s1 = s.substring(0, indexE);
            // e后边的字符串
            String s2 = s.substring(indexE+1);
            if (s2.length() == 0){
                return false;
            }
            if(s2.charAt(0) == '+' || s2.charAt(0) == '-'){
                s2 = s2.substring(1);
            }
            return isDecimal(s1) && isInteger(s2);
        }
        return isDecimal(s);
    }

    /**
     * 判断是否为整数
     * @param s 给定字符串
     * @return  是否为整数
     */
    public boolean isInteger(String s){
        int len = s.length();
        if (len == 0){
            return false;
        }
        for(int i = 0; i < len; i++){
            char temp = s.charAt(i);
            if (temp > '9' || temp < '0'){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为小数
     * @param s 给定字符串
     * @return  是否为小数
     */
    public boolean isDecimal(String s){
        int ifDe = s.indexOf(".");
        if (ifDe < 0){
            return isInteger(s);
        }
        if(s.length() == ifDe+1){
            s = s.substring(0, ifDe);
        }
        else {
            s = s.substring(0, ifDe) + s.substring(ifDe+1);
        }
        return isInteger(s);
    }

    public static void main(String[] args) {
        System.out.println(
                new So0617().isNumber("ReE")
        );
    }

}
