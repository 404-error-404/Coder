package leetcode.So05;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
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
 * 给你一个整数，将其转为罗马数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/14 16:10
 */
public class So0514 {
    /**
     * 初始化两个map保存对应的数字和罗马字符转换关系，然后循环即可
     * @param num 转换前数字
     * @return    转换后罗马数字
     */
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int[] arr = new int[]{1000,500,100,50,10,5,1};
        int[] arr2 = new int[]{900,400,90,40,9,4,0};
        Map<Integer, String> map = new HashMap<>(arr.length);
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        Map<Integer, String> map2 = new HashMap<>(arr2.length);
        map2.put(0, "");
        map2.put(4, "IV");
        map2.put(9, "IX");
        map2.put(40, "XL");
        map2.put(90, "XC");
        map2.put(400, "CD");
        map2.put(900, "CM");

        for (int i = 0; i < arr.length; i++){
            int count = num / arr[i];
            ans.append(map.get(arr[i]).repeat(count));
            num %= arr[i];
            if(num >= arr2[i]){
                ans.append(map2.get(arr2[i]));
                num -= arr2[i];
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new So0514().intToRoman(65)
        );
    }
}
