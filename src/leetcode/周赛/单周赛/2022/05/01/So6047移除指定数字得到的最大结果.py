#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/1 10:34
# @desc :
# 给你一个表示某个正整数的字符串 number 和一个字符 digit 。
#
# 从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/remove-digit-from-number-to-maximize-result
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        if digit == "0":
            idx = number.find(digit)
            number = number[:idx] + number[idx + 1:]
            return number
        else:
            res = ""
            number += "0"
            idx = number.find(digit)
            while idx != -1:
                if number[idx] < number[idx + 1]:
                    return res + number[:idx] + number[idx + 1:-1]
                else:
                    res += number[:idx + 1]
                    number = number[idx + 1:]
                    idx = number.find(digit)
            return res[:-1] + number[:-1]


s = Solution()
ans = s.removeDigit("551", "5")
print(ans)
