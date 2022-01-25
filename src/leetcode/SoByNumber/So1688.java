package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

/**
 * 给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 *
 * 如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * 如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-matches-in-tournament
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2022/1/25 21:42
 **/
public class So1688 {
    public int numberOfMatches(int n) {
        // 根据数学规律，每场比赛淘汰一个队伍，总共淘汰n-1个队伍，所以比赛n-1场
        // return n - 1;
        if (n == 1) {
            return 0;
        }
        int temp = n % 2;
        int halfN = n / 2;
        return numberOfMatches(halfN + temp) + halfN;
    }

    @Test
    public void test() {
        System.out.println(numberOfMatches(45));
    }
}
