#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/4/30 22:27
# @desc :
# 计算烧满所有位置需要时间
# 给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
#
# 0 表示草地。
# 1 表示着火的格子。
# 2 表示一座墙，你跟火都不能通过这个格子。
# 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
#
# 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总是 能到达安全屋，请你返回 109 。
#
# 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
#
# 如果两个格子有共同边，那么它们为 相邻 格子。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/escape-the-spreading-fire
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def dfs(self, grid: List[List[int]], start: List[List[int]]):
        m, n = len(grid), len(grid[0])
        direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        minute = 1
        while len(start) != 0:
            minute += 1
            for _ in range(len(start)):
                x, y = start.pop()
                for dx, dy in direction:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == 0:
                        grid[nx][ny] = minute
                        start.insert(0, [nx, ny])

    def maximumMinutes(self, grid: List[List[int]]) -> int:

        m, n = len(grid), len(grid[0])
        fire = []
        for x in range(m):
            for y in range(n):
                if grid[x][y] == 1:
                    fire.append([x, y])
                elif grid[x][y] == 2:
                    grid[x][y] = -1
        fire_grid = [
            [grid[x][y] for y in range(n)]
            for x in range(m)
        ]
        self.dfs(fire_grid, fire)
        self.dfs(grid, [[0, 0]])
        if grid[-1][-1] == 0:
            return -1

        if fire_grid[-1][-1] == 0:
            return 10 ** 9

        ans = fire_grid[-1][-1] - grid[-1][-1]
        if ans < 0:
            return -1
        # 判断人和火是否是同向到达的
        people = set()
        if grid[-1][-1] - grid[-1][-2] == 1:
            people.add(0)
        if grid[-1][-1] - grid[-2][-1] == 1:
            people.add(1)

        fire = set()
        if fire_grid[-1][-1] - fire_grid[-1][-2] == 1:
            fire.add(0)
        if fire_grid[-1][-1] - fire_grid[-2][-1] == 1:
            fire.add(1)
        if len(people - fire) == 0:
            return ans - 1
        else:
            return ans


s = Solution()
s.maximumMinutes(
    [
        [0, 2, 0, 0, 0, 0, 0],
        [0, 0, 0, 2, 2, 1, 0],
        [0, 2, 0, 0, 1, 2, 0],
        [0, 0, 2, 2, 2, 0, 2],
        [0, 0, 0, 0, 0, 0, 0]
    ]
)
s.maximumMinutes([[0, 0, 2, 2, 1, 1, 0, 2, 1, 1, 2, 2, 0, 2, 2, 1, 2, 0, 1, 2, 2, 0, 1, 2, 2, 1, 2, 2],
                  [2, 2, 2, 1, 1, 2, 2, 1, 2, 0, 1, 1, 1, 2, 2, 1, 1, 0, 2, 2, 2, 0, 1, 0, 1, 2, 2, 2],
                  [0, 0, 1, 1, 0, 1, 2, 0, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2],
                  [2, 2, 0, 0, 0, 0, 1, 0, 1, 0, 2, 0, 1, 0, 2, 0, 0, 1, 2, 1, 0, 1, 1, 1, 2, 0, 2, 0],
                  [2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 0, 1, 1, 1, 1, 2, 0, 2, 1, 1, 2, 0, 2, 0, 2, 0],
                  [0, 1, 0, 1, 2, 2, 2, 0, 2, 0, 2, 2, 1, 2, 0, 0, 1, 0, 2, 0, 2, 0, 1, 2, 2, 0, 2, 0],
                  [1, 0, 2, 2, 2, 0, 2, 0, 2, 0, 2, 0, 1, 0, 2, 2, 0, 2, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0],
                  [0, 1, 2, 0, 1, 0, 1, 0, 2, 1, 2, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 2, 0, 1, 0, 1, 0, 2],
                  [2, 1, 1, 0, 1, 1, 2, 2, 1, 2, 2, 1, 0, 1, 0, 0, 0, 2, 1, 0, 2, 2, 1, 2, 1, 2, 0, 1],
                  [1, 1, 2, 0, 2, 2, 1, 2, 0, 2, 1, 1, 0, 0, 0, 2, 2, 2, 2, 1, 2, 2, 0, 2, 1, 1, 2, 0],
                  [2, 1, 2, 2, 0, 0, 1, 0, 1, 2, 1, 0, 1, 0, 2, 0, 0, 1, 1, 0, 2, 0, 2, 0, 1, 2, 2, 0],
                  [1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 2, 0, 2, 1, 2, 1, 1, 0, 1, 0, 0, 2, 1, 2, 1, 0, 2],
                  [2, 0, 1, 0, 2, 0, 1, 0, 2, 0, 2, 1, 2, 0, 2, 2, 2, 1, 0, 2, 1, 0, 1, 2, 1, 0, 1, 1],
                  [0, 2, 2, 1, 0, 2, 1, 0, 1, 2, 2, 1, 2, 2, 1, 2, 0, 1, 2, 2, 0, 2, 1, 0, 2, 1, 0, 0],
                  [0, 2, 2, 2, 1, 2, 1, 0, 0, 2, 2, 0, 1, 0, 2, 1, 0, 0, 2, 1, 1, 1, 2, 1, 2, 1, 0, 1],
                  [2, 2, 2, 1, 1, 1, 1, 0, 2, 2, 2, 1, 0, 0, 2, 2, 0, 0, 1, 1, 0, 0, 2, 1, 2, 1, 2, 2],
                  [2, 1, 2, 1, 1, 1, 0, 2, 1, 0, 1, 1, 2, 1, 0, 0, 1, 1, 2, 1, 2, 2, 1, 2, 0, 2, 0, 0]])
