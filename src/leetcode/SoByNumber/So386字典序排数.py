from typing import List


# 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
#
# 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/lexicographical-numbers
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
def lexical_order(n: int) -> List[int]:
    res = [str(i) for i in range(1, n + 1)]
    res.sort()
    return [int(i) for i in res]


print(lexical_order(13))
