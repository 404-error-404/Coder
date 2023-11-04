# 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
#
# 子字符串长度为 k 。
# 子字符串能整除 num 。
# 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
#
# 注意：
#
# 允许有 前缀 0 。
# 0 不能整除任何值。
# 一个 子字符串 是一个字符串里的连续一段字符序列。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/find-the-k-beauty-of-a-number
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    def divisorSubstrings(self, num: int, k: int) -> int:
        res = 0
        num_str = str(num)
        i = 0
        while i <= len(num_str) - k:
            div = int(num_str[i: i + k])
            if div != 0 and num % div == 0:
                res += 1
            i += 1
        return res


s = Solution()
s.divisorSubstrings(30003, 3)
