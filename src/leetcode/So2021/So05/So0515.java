package leetcode.So2021.So05;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/15 11:20
 **/
public class So0515 {
    public int romanToInt(String s) {
        int ans = 0;
        // 初始化罗马字符和数字的对应关系映射表
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        // 但其实书上不推荐用charAt()方法
        // 因为字符串中的特殊字符可能会占用俩个字节的位置
        // 这时候用charAt()方法获取到的返回值其实是该特殊字符的第一个或者第二个字节对应的字符
        // 比如特殊字符𝕆

        // 遍历字符串进行解析
        int i = 0;
        for (; i < s.length()-1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
            }
            else {
                ans += map.get(s.charAt(i));
            }
        }
        if(i == s.length() - 1){
            ans += map.get(s.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new So0515().romanToInt("VIII")
        );
    }
}
