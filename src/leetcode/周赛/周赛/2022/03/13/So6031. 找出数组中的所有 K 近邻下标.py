# 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
#
# 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/find-all-k-distant-indices-in-an-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


def findKDistantIndices(nums: List[int], key: int, k: int) -> List[int]:
    res = set()
    for i in range(len(nums)):
        if nums[i] == key:
            left = i - k
            if left < 0:
                left = 0
            right = i + k
            if right >= len(nums):
                right = len(nums) - 1
            res |= set(range(left, right + 1))
    res = list(res)
    res.sort()
    return res


nums = [3, 4, 9, 1, 3, 9, 5]
key = 3
k = 1
print(findKDistantIndices(nums, key, k))
