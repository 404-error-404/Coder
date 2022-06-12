#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/6/11 22:38
# @Remarks  :
# 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
# 
# 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
# 
# 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/successful-pairs-of-spells-and-potions
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    m = 0

    def get_target_pairs(self, spell: int, potions: List[int], success: int) -> int:
        if spell == 0:
            return 0
        # 小一个
        # 二分查找当前spell的
        left = 0
        right = self.m - 1

        while left < right:
            mid = (left + right) // 2
            tmp = potions[mid] * spell
            if tmp < success:
                left = mid + 1
            else:
                right = mid
        if spell * potions[left] < success:
            return 0
        else:
            return self.m - left

    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        self.m = len(potions)
        potions.sort()

        return [self.get_target_pairs(i, potions, success) for i in spells]


s = Solution()
sp = [5, 1, 3]
po = [1, 2, 3, 4, 5]
su = 7
print(s.successfulPairs(sp, po, su))
