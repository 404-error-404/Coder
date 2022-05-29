#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/5/29 21:02
# @Remarks  :
# 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
#
# 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/rearrange-characters-to-make-target-string
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
        target_count = {}
        for i in target:
            target_count[i] = target_count.get(i, 0) + 1

        s_count = {i: 0 for i in target_count.keys()}
        for i in s:
            if i in target_count.keys():
                s_count[i] = s_count[i] + 1

        res = 0

        while True:
            for i in target_count.keys():
                s_count[i] -= target_count[i]
                if s_count[i] < 0:
                    return res
            res += 1


s = Solution()
print(s.rearrangeCharacters("abbaccaddaeea", "aaaaa"))
