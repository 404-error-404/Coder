#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/4/24 16:51
# @Remarks  :
# 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
#
# 注意：
#
# 格点 是指整数坐标对应的点。
# 圆周上的点 也被视为出现在圆内的点。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/count-lattice-points-inside-a-circle
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def countLatticePoints(self, circles: List[List[int]]) -> int:
        res = set()
        for c in circles:
            # 遍历左下角四分之一的位置即可
            for x_diff in range(c[2]+1):
                for y_diff in range(c[2]+1):
                    # 判断点是否在园内
                    if x_diff ** 2 + y_diff ** 2 <= c[2] ** 2:
                        res.add((c[0] - x_diff, c[1] - y_diff,))
                        res.add((c[0] - x_diff, c[1] + y_diff,))
                        res.add((c[0] + x_diff, c[1] - y_diff,))
                        res.add((c[0] + x_diff, c[1] + y_diff,))
                    else:
                        continue
            res.add((c[0], c[1],))
        return len(res)


s = Solution()
cs = [[2, 2, 1]]
ans = s.countLatticePoints(cs)
print(ans)
