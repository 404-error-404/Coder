#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/4/24 17:08
# @Remarks  :
# 给你一个二维整数数组 rectangles ，其中 rectangles[i] = [li, hi] 表示第 i 个矩形长为 li 高为 hi 。给你一个二维整数数组 points ，其中 points[j] = [xj, yj] 是坐标为 (xj, yj) 的一个点。
#
# 第 i 个矩形的 左下角 在 (0, 0) 处，右上角 在 (li, hi) 。
#
# 请你返回一个整数数组 count ，长度为 points.length，其中 count[j]是 包含 第 j 个点的矩形数目。
#
# 如果 0 <= xj <= li 且 0 <= yj <= hi ，那么我们说第 i 个矩形包含第 j 个点。如果一个点刚好在矩形的 边上 ，这个点也被视为被矩形包含。
#
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/count-number-of-rectangles-containing-each-point
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


def lower_bound(nums: List[int], target) -> int:
    left, right = 0, len(nums) - 1
    res = len(nums)

    while left < right:
        mid = (left + right) // 2
        if nums[mid] < target:
            left = mid + 1
        else:
            right = mid
    if nums[left] >= target:
        res = left
    return res


class Solution:
    def countRectangles(self, rectangles: List[List[int]], points: List[List[int]]) -> List[int]:
        """
        先对矩形按照纵坐标排序（因为纵坐标范围小，方便之后对横坐标二分查找）
        然后在纵坐标 >= p[1] 的矩形数组中二分查找
        """
        res = []
        # 横坐标范围太大了，不适合做索引，这里用纵坐标做索引
        rectangle_sorts = []
        for i in range(101):
            rectangle_sorts.append([])
        for r in rectangles:
            rectangle_sorts[r[1]].append(r[0])
        for rs in rectangle_sorts:
            rs.sort()
        for x, y in points:
            count = 0
            # 在所有纵坐标>=y的正方形列表中二分查找>=x的
            for rs in rectangle_sorts[y:]:
                if rs:
                    count += len(rs) - lower_bound(rs, x)
            res.append(count)
        return res


rectangles = [[1, 1], [2, 2], [3, 3]]
points = [[1, 3], [1, 1]]
s = Solution()
ans = s.countRectangles(rectangles, points)
print(ans)
