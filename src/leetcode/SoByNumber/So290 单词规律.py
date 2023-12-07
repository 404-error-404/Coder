#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/12/4 15:26
# @Remarks  :
# 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
#
# 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
#
# https://leetcode.cn/problems/word-pattern/description/
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        # 转换pattern为list，针对它创建一个map记录对应的单词
        # 遍历s进行校验
        pattern = list(pattern)
        s = s.split(" ")
        # 校验长度
        if len(pattern) != len(s):
            return False
        flag = {}
        flag_v = {}
        for idx in range(len(s)):
            k = pattern[idx]
            v = s[idx]
            # 校验k对应的值是否唯一
            if flag.get(k, None) != v:
                return False
            else:
                flag[k] = v
            # 校验值对应的k是否唯一
            if flag_v.get(v, None) != k:
                return False
            else:
                flag_v[v] = k
        return True


sss = Solution()
res = sss.wordPattern("abba", "dog dog dog dog")
print(res)
