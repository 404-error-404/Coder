#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @time : 2022/9/18 11:30
# @desc :
class Solution:
    def smallestEvenMultiple(self, n: int) -> int:
        if n % 2 == 0:
            return n
        return n * 2
