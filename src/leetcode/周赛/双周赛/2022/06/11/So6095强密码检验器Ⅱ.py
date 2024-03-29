#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/6/11 22:30
# @desc :
# 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
# 
# · 它有至少 8 个字符。
# · 至少包含 一个小写英文 字母。
# · 至少包含 一个大写英文 字母。
# · 至少包含 一个数字 。
# · 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
# · 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
#
# 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/strong-password-checker-ii
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        if len(password) < 8:
            return False
        lowercase = False
        capital = False
        num = False
        symbol_list = set(list("!@#$%^&*()-+"))
        has_symbol = False
        last = '.'

        for i in password:
            if i == last:
                return False
            last = i
            if 'a' <= i <= 'z':
                lowercase = True
            elif 'A' <= i <= 'Z':
                capital = True
            elif '0' <= i <= '9':
                num = True
            elif i in symbol_list:
                has_symbol = True
        return lowercase and capital and num and has_symbol
