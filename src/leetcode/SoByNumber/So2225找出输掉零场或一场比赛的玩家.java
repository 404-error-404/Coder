package leetcode.SoByNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 * <p>
 * 返回一个长度为 2 的列表 answer ：
 * <p>
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * <p>
 * 注意：
 * <p>
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-players-with-zero-or-one-losses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/10/6 13:08
 */
public class So2225找出输掉零场或一场比赛的玩家 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] match : matches) {
            count.put(match[0], count.getOrDefault(match[0], 0));
            count.put(match[1], count.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> lose0 = new ArrayList<>(), lose1 = new ArrayList<>();
        count.forEach((k, v) -> {
            if (v == 0) {
                lose0.add(k);
            } else if (v == 1) {
                lose1.add(k);
            }
        });
        Collections.sort(lose0);
        Collections.sort(lose1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(lose0);
        res.add(lose1);
        return res;
    }
}
