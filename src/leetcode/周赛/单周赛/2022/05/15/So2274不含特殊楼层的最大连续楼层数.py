# Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
# 
# 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。
# 另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
# 
# 返回不含特殊楼层的 最大 连续楼层数。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def maxConsecutive(self, bottom: int, top: int, special: List[int]) -> int:
        special.sort()
        res = 0
        last_work = bottom
        for s in special:
            res = max(res, s - last_work)
            last_work = s + 1
        res = max(res, top - special[-1])
        return res


so = Solution()
res = so.maxConsecutive(2, 9, [4, 6])
print(res)
