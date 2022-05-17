# 给你区间的 空 集，请你设计并实现满足要求的数据结构：
#
# · 新增：添加一个区间到这个区间集合中。
# · 统计：计算出现在 至少一个 区间中的整数个数。
#
# 实现 CountIntervals 类：
#
# · CountIntervals() 使用区间的空集初始化对象
# · void add(int left, int right) 添加区间 [left, right] 到区间集合之中。
# · int count() 返回出现在 至少一个 区间中的整数个数。
#
# 注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/count-integers-in-intervals
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class CountIntervals:
    def __init__(self, l=1, r=10 ** 9):
        self.left = self.right = None
        self.l, self.r, self.cnt = l, r, 0

    def add(self, left: int, right: int) -> None:
        # 全覆盖的情况
        if self.cnt == self.r - self.l + 1:
            return
        # self已被区间[left,right]覆盖，不再递归
        if left <= self.l and self.r <= right:
            self.cnt = self.r - self.l + 1
            return

        mid = (self.l + self.r) // 2
        if self.left is None:
            self.left = CountIntervals(self.l, mid)
        if self.right is None:
            self.right = CountIntervals(mid + 1, self.r)

        if left <= mid:
            self.left.add(left, right)
        if mid < right:
            self.right.add(left, right)
        self.cnt = self.left.cnt + self.right.cnt

    def count(self) -> int:
        return self.cnt
# Your CountIntervals object will be instantiated and called as such:
# obj = CountIntervals()
# obj.add(left,right)
# param_2 = obj.count()
