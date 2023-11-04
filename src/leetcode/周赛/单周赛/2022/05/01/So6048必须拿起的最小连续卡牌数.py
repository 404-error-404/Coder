#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/5/1 10:34
# @desc :
# 给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。
#
# 返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/minimum-consecutive-cards-to-pick-up
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        card_dict = {}
        res = 100001
        for i in range(len(cards)):
            c = cards[i]
            if c in card_dict.keys():
                res = min(res, i - card_dict[c] + 1)
            card_dict[c] = i
        if res == 100001:
            return -1
        return res
