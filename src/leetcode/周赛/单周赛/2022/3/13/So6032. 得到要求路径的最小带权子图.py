# 给你一个整数 n ，它表示一个 带权有向 图的节点数，节点编号为 0 到 n - 1 。
# 
# 同时给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi, weighti] ，表示从 fromi 到 toi 有一条边权为 weighti 的 有向 边。
# 
# 最后，给你三个 互不相同 的整数 src1 ，src2 和 dest ，表示图中三个不同的点。
# 
# 请你从图中选出一个 边权和最小 的子图，使得从 src1 和 src2 出发，在这个子图中，都 可以 到达 dest 。如果这样的子图不存在，请返回 -1 。
# 
# 子图 中的点和边都应该属于原图的一部分。子图的边权和定义为它所包含的所有边的权值之和。

# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/minimum-weighted-subgraph-with-the-required-paths
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def minimumWeight(self, n: int, edges: List[List[int]], src1: int, src2: int, dest: int) -> int:
        # TODO 困难题，不会写
        return 0
