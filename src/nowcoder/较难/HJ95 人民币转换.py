#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/22 22:46
# @Remarks  : 考试题目和要点：
#
# 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
#
# 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
#
# 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
# 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
# 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
#
# https://www.nowcoder.com/practice/00ffd656b9604d1998e966d555005a4b
s1, s2 = input().split(".")
chinese = ["零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "元", "角", "分", "整"]
# for c in s:
#     if "0" <= c <= "9":
#         print(chinese[int(c)], end="")
chinese_千 = ["仟", "佰", "拾", ""]
replace_str = {
    "壹拾": "拾",
    "零零": "零"
}


def int_to_chinese(s: str):
    res = ""
    for i in range(-1, -len(s) - 1, -1):
        if s[i] == "0":
            res = "零" + res
        else:
            res = chinese[int(s[i])] + chinese_千[i] + res
    for k, v in replace_str.items():
        while k in res:
            res = res.replace(k, v)
    while len(res) > 0 and res[-1] == "零":
        res = res[:-1]
    while len(res) > 0 and res[0] == "零":
        res = res[1:]
    return res


ans = ""
num_ans = []
while len(s1) > 4:
    num_ans.insert(0, int_to_chinese(s1[-4:]))
    s1 = s1[:len(s1) - 4]
num_ans.insert(0, int_to_chinese(s1))
chinese_亿 = ["亿", "万", ""]
for i in range(-1, -len(num_ans) - 1, -1):
    if num_ans[i] != "":
        ans = num_ans[i] + chinese_亿[i] + ans
if ans:
    ans += "元"
if int(s2) != 0:
    if s2[0] != "0":
        ans += chinese[int(s2[0])]
        ans += "角"
    if s2[1] != "0":
        ans += chinese[int(s2[1])]
        ans += "分"
else:
    ans += "整"
ans = "人民币" + ans
print(ans)
