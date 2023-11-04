#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/3/6 10:29
# @desc :
# 给你一个整数数组 nums 。请你对数组执行下述操作：
#
# 从 nums 中找出 任意 两个 相邻 的 非互质 数。
# 如果不存在这样的数，终止 这一过程。
# 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
# 只要还能找出两个相邻的非互质数就继续 重复 这一过程。
# 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
#
# 生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
#
# 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/replace-non-coprime-numbers-in-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from math import gcd
from typing import List


class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        res = [nums[0]]
        for i in nums[1:]:
            res.append(i)
            while len(res) > 1:
                x, y = res[-1], res[-2]
                g = gcd(x, y)
                if g == 1:
                    break
                res.pop()
                res[-1] = res[-1] * x // g
        return res


s = Solution()
print(s.replaceNonCoprimes([6, 4, 3, 2, 7, 6, 2]))
