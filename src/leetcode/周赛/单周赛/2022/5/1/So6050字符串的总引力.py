#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/5/1 10:34
# @Remarks  :
# 字符串的 引力 定义为：字符串中 不同 字符的数量。
#
# 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
# 给你一个字符串 s ，返回 其所有子字符串的总引力 。
#
# 子字符串 定义为：字符串中的一个连续字符序列。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/total-appeal-of-a-string
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    def appealSum(self, s: str) -> int:
        ## TODO 可以再做一次
        # 当前子串的引力
        cur_sum = 0
        res = 0
        last_pos = [-1] * 26
        for i, c in enumerate(s):
            c = ord(c) - ord("a")
            cur_sum += i - last_pos[c]
            last_pos[c] = i
            res += cur_sum
        return res


s = Solution()
ans = s.appealSum("abbca")
print(ans)
