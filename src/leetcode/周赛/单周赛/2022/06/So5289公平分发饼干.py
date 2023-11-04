#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/6/12 16:16
# @desc :
# 给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k 表示等待分发零食包的孩子数量，所有 零食包都需要分发。在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。
#
# 分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。
#
# 返回所有分发的最小不公平程度。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/fair-distribution-of-cookies
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def backtrack(self, cookies: List[int], k: int, limit: int, start: int, res: List[int]) -> bool:
        """
        回溯法分配饼干
        :param cookies: 从大到小排列的饼干
        :param k:       孩子数量
        :param limit:   上限
        :param start:   当前分配饼干序号
        :param res:     每个孩子拿到的饼干数
        """
        if start == len(cookies):
            return True
        for i in range(k):
            res[i] += cookies[start]

            # 不超过上限则继续回溯
            if res[i] <= limit and (i == 0 or res[i - 1] != 0):
                if self.backtrack(cookies, k, limit, start + 1, res):
                    return True

            res[i] -= cookies[start]
        return False

    def check(self, cookies: List[int], k: int, limit: int) -> bool:
        """
        检查在limit条件下能否满足要求
        """
        res = [0] * k
        return self.backtrack(cookies, k, limit, 0, res)

    def distributeCookies(self, cookies: List[int], k: int) -> int:
        """
        解法1，二分+回溯
        44ms，推荐
        """
        cookies.sort(reverse=True)

        # 二分查找可行方案
        left = cookies[0]
        right = sum(cookies)

        while left < right:
            mid = (left + right) // 2
            # 检查mid是否符合要求
            if self.check(cookies, k, mid):
                right = mid
            else:
                left = mid + 1
        return right

    def distributeCookies2(self, cookies: List[int], k: int) -> int:
        """
        解法2，全程使用回溯，不再使用二分
        212ms，更推荐用方法1
        """
        cookies.sort(reverse=True)
        ans = sum(cookies)
        buckets = [0] * k

        def backtrack(idx: int):
            nonlocal ans
            if idx == len(cookies):
                ans = min(ans, max(buckets))
                return

            for i in range(k):
                buckets[i] += cookies[idx]

                if buckets[i] < ans:
                    backtrack(idx + 1)

                buckets[i] -= cookies[idx]

        backtrack(0)
        return ans


s = Solution()
cookies_ = [8, 15, 10, 20, 8]
k_ = 2
print(s.distributeCookies2(cookies_, k_))
