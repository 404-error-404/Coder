# 给你一个下标从 0 开始的整数数组 nums ，它表示一个 栈 ，其中 nums[0] 是栈顶的元素。
# 
# 每一次操作中，你可以执行以下操作 之一 ：
# 
# 如果栈非空，那么 删除 栈顶端的元素。
# 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加 回栈顶，这个元素成为新的栈顶元素。
# 同时给你一个整数 k ，它表示你总共需要执行操作的次数。
# 
# 请你返回 恰好 执行 k 次操作以后，栈顶元素的 最大值 。如果执行完 k 次操作以后，栈一定为空，请你返回 -1 。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/maximize-the-topmost-element-after-k-moves
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def maximumTop(self, nums: List[int], k: int) -> int:
        nums_len = len(nums)
        if nums_len == 1:
            if k % 2 == 0:
                return nums[0]
            else:
                return -1

        if k == 0:
            return nums[0]
        if k == 1:
            return nums[1]

        if k > nums_len:
            nums.sort()
        elif k == nums_len:
            nums = nums[:k - 1]
        elif k < nums_len:
            nums[k - 1] = nums[k]
            nums = nums[:k]
        nums.sort(reverse=True)
        return nums[0]


s = Solution()
nums2 = [99, 95, 68, 100, 24, 18]
k2 = 7
print(s.maximumTop(nums2, k2))
