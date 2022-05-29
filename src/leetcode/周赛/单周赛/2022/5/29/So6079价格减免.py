#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2022/5/29 21:41
# @Remarks  :
# 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。
# 
# 例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
# 注意：本题输入中的价格均为整数。
# 
# 给你一个字符串 sentence  和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
# 
# 返回表示修改后句子的字符串。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/apply-discount-to-prices
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    def get_money(self, price: str, discount: int) -> str:
        if price[0] != "$":
            return price
        try:
            p = str(int(price[1:]) * discount)
            if len(p) < 3:
                p = ("0" * (3 - len(p))) + p
            return "$" + p[:-2] + "." + p[-2:]
        except Exception as e:
            return price

    def discountPrices(self, sentence: str, discount: int) -> str:
        res = []
        for i in sentence.split(" "):
            res.append(self.get_money(i, 100 - discount))
        return " ".join(res)


s = Solution()
print(s.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 30))
