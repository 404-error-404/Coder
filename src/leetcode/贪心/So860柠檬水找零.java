package leetcode.贪心;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/14 21:14
 */
public class So860柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[2];
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    count[0]++;
                    break;
                case 10:
                    if (count[0] == 0) {
                        return false;
                    }
                    count[1]++;
                    count[0]--;
                    break;
                case 20:
                    if (count[0] >= 1 && count[1] >= 1) {
                        count[1]--;
                        count[0]--;
                    } else if (count[0] >= 3) {
                        count[0] -= 3;
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
