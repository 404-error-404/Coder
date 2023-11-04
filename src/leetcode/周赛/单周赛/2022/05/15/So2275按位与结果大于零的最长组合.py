# 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
# 
# · 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
# · 同样，对 nums = [7] 而言，按位与等于 7 。
#
# 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。 candidates 中的每个数字在每种组合中只能使用 一次 。
# 
# 返回按位与结果大于 0 的 最长 组合的长度。
# 
#  
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        count = [0] * 32
        for c in candidates:
            i = 0
            while c > 0:
                count[i] += c & 1
                c >>= 1
                i += 1
        return max(count)


s = Solution()
nums = [16, 17, 71, 62, 12, 24, 14]
print(s.largestCombination(nums))
