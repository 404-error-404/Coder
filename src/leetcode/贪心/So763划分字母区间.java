package leetcode.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/6/16 22:54
 **/
public class So763划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();
        // 记录26个字幕首次出现和最后一次出现的位置
        int[] location = new int[26];
        Arrays.fill(location, sLen - 1);

        for (int i = 0; i < s.length(); i++) {
            location[s.charAt(i) - 'a'] = i;
        }

        int tmp = s.charAt(0) - 'a';
        int start = 0, end = location[tmp];

        // 从前往后遍历计算位置
        for (int i = 0; i < sLen; i++) {
            tmp = s.charAt(i) - 'a';
            if (location[tmp] > end) {
                end = location[tmp];
            }

            if (end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
