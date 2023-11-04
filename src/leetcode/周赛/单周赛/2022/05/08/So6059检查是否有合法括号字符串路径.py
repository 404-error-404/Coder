from functools import lru_cache
from typing import List


class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        #  TODO 这个缓存很重要！
        @lru_cache()  # 效果类似 vis 数组
        def dfs(x: int, y: int, c: int) -> bool:
            if x >= m or y >= n or c < 0:
                return False
            if c > m - x + n - y - 1:
                return False
            if x == m - 1 and y == n - 1:
                return c == 1
            if grid[x][y] == "(":
                c += 1
            else:
                c -= 1
            return dfs(x + 1, y, c) or dfs(x, y + 1, c)

        m, n = len(grid), len(grid[0])
        if (m + n) % 2 == 0 or grid[0][0] == ")" or grid[-1][-1] == "(":
            return False

        return dfs(0, 0, 0)


grid = [["(", "(", ")", ")", ")", "(", "(", ")", "(", "(", ")", "(", ")", "(", "(", ")"],
        [")", "(", ")", ")", ")", ")", "(", "(", "(", "(", ")", ")", "(", "(", "(", "("],
        ["(", ")", ")", ")", "(", "(", "(", ")", "(", "(", ")", ")", ")", "(", ")", ")"],
        ["(", "(", ")", ")", ")", ")", "(", "(", "(", ")", "(", "(", "(", ")", "(", "("],
        ["(", "(", "(", "(", "(", "(", ")", ")", ")", "(", "(", ")", ")", "(", ")", ")"],
        ["(", "(", ")", "(", ")", "(", "(", "(", "(", ")", ")", ")", "(", "(", ")", ")"],
        [")", "(", "(", "(", ")", "(", ")", ")", ")", ")", "(", "(", ")", ")", ")", "("],
        ["(", "(", "(", ")", "(", "(", ")", ")", ")", "(", "(", ")", "(", ")", ")", "("],
        [")", ")", "(", ")", ")", ")", "(", "(", "(", ")", "(", "(", ")", "(", ")", ")"],
        ["(", "(", ")", ")", ")", "(", ")", ")", ")", ")", "(", ")", "(", "(", "(", ")"],
        ["(", "(", "(", ")", "(", ")", ")", "(", "(", ")", ")", ")", "(", ")", "(", ")"],
        ["(", ")", ")", ")", ")", ")", ")", "(", ")", ")", ")", ")", "(", ")", ")", ")"],
        [")", "(", ")", ")", "(", "(", "(", "(", "(", ")", "(", ")", "(", ")", "(", ")"],
        [")", ")", ")", ")", "(", ")", ")", "(", ")", ")", ")", ")", "(", "(", ")", ")"]]
grid = [["(", ")", ")", "(", "(", "(", "(", ")", ")", "(", ")", "(", ")", "(", "(", "(", "(", ")", "(", ")", "("],
        ["(", "(", ")", ")", "(", ")", ")", ")", "(", ")", "(", ")", "(", "(", ")", "(", "(", "(", "(", "(", ")"],
        [")", ")", "(", ")", ")", "(", "(", ")", "(", "(", ")", "(", ")", ")", "(", ")", ")", "(", "(", ")", ")"],
        ["(", "(", ")", "(", ")", "(", ")", ")", ")", "(", ")", "(", "(", ")", "(", ")", ")", "(", ")", ")", ")"],
        ["(", "(", "(", ")", "(", "(", ")", "(", ")", ")", "(", ")", ")", ")", ")", ")", ")", "(", ")", "(", "("],
        [")", ")", "(", "(", ")", ")", ")", ")", ")", "(", ")", ")", ")", "(", "(", ")", "(", "(", "(", "(", ")"],
        [")", ")", ")", ")", "(", ")", "(", ")", "(", "(", ")", "(", "(", ")", "(", "(", ")", ")", "(", ")", "("],
        ["(", ")", "(", "(", "(", ")", ")", ")", ")", "(", "(", ")", "(", "(", ")", ")", "(", ")", ")", ")", "("],
        ["(", ")", "(", ")", "(", "(", "(", "(", ")", "(", "(", "(", "(", "(", "(", ")", "(", ")", "(", ")", ")"],
        ["(", ")", "(", "(", "(", ")", "(", ")", ")", ")", ")", "(", "(", "(", "(", ")", ")", "(", "(", "(", ")"],
        ["(", "(", ")", "(", ")", ")", "(", ")", "(", ")", ")", ")", ")", ")", "(", ")", "(", ")", ")", ")", "("],
        [")", "(", "(", "(", ")", "(", ")", ")", "(", ")", "(", ")", "(", "(", ")", "(", "(", ")", "(", "(", ")"],
        ["(", ")", "(", ")", ")", "(", "(", ")", "(", ")", "(", ")", ")", ")", "(", "(", "(", "(", ")", "(", ")"],
        ["(", "(", ")", "(", ")", ")", "(", "(", "(", ")", "(", ")", "(", "(", ")", ")", "(", "(", "(", ")", ")"],
        ["(", "(", "(", "(", ")", ")", "(", ")", "(", "(", "(", ")", ")", "(", ")", "(", ")", ")", ")", ")", "("],
        ["(", "(", "(", ")", ")", ")", "(", ")", ")", "(", ")", ")", "(", "(", ")", "(", ")", "(", "(", "(", ")"],
        [")", ")", ")", ")", ")", ")", "(", ")", ")", ")", "(", "(", ")", "(", ")", "(", "(", "(", "(", ")", ")"]]
s = Solution()
res = s.hasValidPath(grid)
print(res)
