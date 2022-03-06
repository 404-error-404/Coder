#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/3/5 22:45
# @Remarks  :
# 给你一个下标从 0 开始的整数数组 mapping ，它表示一个十进制数的映射规则，mapping[i] = j 表示这个规则下将数位 i 映射为数位 j 。
# 
# 一个整数 映射后的值 为将原数字每一个数位 i （0 <= i <= 9）映射为 mapping[i] 。
# 
# 另外给你一个整数数组 nums ，请你将数组 nums 中每个数按照它们映射后对应数字非递减顺序排序后返回。
# 
# 注意：
# 
# 如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序。
# nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/sort-the-jumbled-numbers
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        nums_map = []
        for n in nums:
            n_list = list(str(n))
            for i in range(len(n_list)):
                n_list[i] = str(mapping[int(n_list[i])])
            nums_map.append([n, int("".join(n_list))])
        res_list = sorted(nums_map, key=lambda x: x[1])
        return [i[0] for i in res_list]


s = Solution()
mapping = [8, 2, 9, 5, 3, 7, 1, 0, 6, 4]
nums = [77, 45, 77]
res = s.sortJumbled(mapping, nums)
print(res)
