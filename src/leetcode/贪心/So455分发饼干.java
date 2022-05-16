package leetcode.贪心;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/11 15:44
 */
public class So455分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 小饼干分给胃口小的孩子
        int gIdx = 0, sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (s[sIdx] >= g[gIdx]) {
                res += 1;
                gIdx++;
            }
            sIdx++;
        }
        return res;
    }

    @Test
    public void test() {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        int res = findContentChildren(g, s);
        System.out.println(res);
    }
}
