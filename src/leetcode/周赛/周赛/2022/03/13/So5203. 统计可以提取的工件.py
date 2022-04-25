# 存在一个 n x n 大小、下标从 0 开始的网格，网格中埋着一些工件。给你一个整数 n 和一个下标从 0 开始的二维整数数组 artifacts ，artifacts 描述了矩形工件的位置，其中 artifacts[i] = [
# r1i, c1i, r2i, c2i] 表示第 i 个工件在子网格中的填埋情况：
#
# (r1i, c1i) 是第 i 个工件 左上 单元格的坐标，且
# (r2i, c2i) 是第 i 个工件 右下 单元格的坐标。
# 你将会挖掘网格中的一些单元格，并清除其中的填埋物。如果单元格中埋着工件的一部分，那么该工件这一部分将会裸露出来。如果一个工件的所有部分都都裸露出来，你就可以提取该工件。
#
# 给你一个下标从 0 开始的二维整数数组 dig ，其中 dig[i] = [ri, ci] 表示你将会挖掘单元格 (ri, ci) ，返回你可以提取的工件数目。
#
# 生成的测试用例满足：
#
# 不存在重叠的两个工件。
# 每个工件最多只覆盖 4 个单元格。
# dig 中的元素互不相同。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/count-artifacts-that-can-be-extracted
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    dig_set = None

    def check_artifact(self, r1: int, r2: int, c1: int, c2: int) -> int:
        for r in range(r1, r2 + 1):
            for c in range(c1, c2 + 1):
                if (r, c,) not in self.dig_set:
                    return 0
        return 1

    def digArtifacts(self, n: int, artifacts: List[List[int]], dig: List[List[int]]) -> int:
        self.dig_set = set()
        for i in dig:
            self.dig_set.add(tuple(i))
        count = 0
        # 判断一个工件所占单元格是否可以挖掘
        for i in artifacts:
            count += self.check_artifact(i[0], i[2], i[1], i[3])
        return count


s = Solution()
n = 2
artifacts = [[0, 0, 0, 0], [0, 1, 1, 1]]
dig = [[0, 0], [0, 1]]
print(s.digArtifacts(n, artifacts, dig))
