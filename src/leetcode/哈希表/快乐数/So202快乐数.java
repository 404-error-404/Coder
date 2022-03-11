package leetcode.哈希表.快乐数;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/11 18:13
 */
public class So202快乐数 {
    Set<Integer> midRes = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int temp = 0;
        while (n != 0) {
            int mod10 = n % 10;
            temp += mod10 * mod10;
            n = n / 10;
        }
        if (midRes.contains(temp)) {
            return false;
        }
        midRes.add(temp);
        return isHappy(temp);
    }

    @Test
    public void test() {
        for (int i = 1; i < 10; i++) {
            System.out.println(isHappy(i));
        }
    }
}
