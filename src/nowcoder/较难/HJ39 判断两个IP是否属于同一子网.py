#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time     : 2023/11/19 23:35
# @Remarks  : IP地址是由4个0-255之间的整数构成的，用"."符号相连。
# 二进制的IP地址格式有32位，例如：10000011，01101011，00000011，00011000;每八位用十进制表示就是131.107.3.24
# 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
# 子网掩码与IP地址结构相同，是32位二进制数，由1和0组成，且1和0分别连续，其中网络号部分全为“1”和主机号部分全为“0”。
# 你可以简单的认为子网掩码是一串连续的1和一串连续的0拼接而成的32位二进制数，左边部分都是1，右边部分都是0。
# 利用子网掩码可以判断两台主机是否在同一子网中。
# 若两台主机的IP地址分别与它们的子网掩码进行逻辑“与”运算（按位与/AND）后的结果相同，则说明这两台主机在同一子网中。
#
# 示例：
# I P 地址　 192.168.0.1
# 子网掩码　 255.255.255.0
#
# 转化为二进制进行运算：
#
# I P 地址　  11000000.10101000.00000000.00000001
# 子网掩码　11111111.11111111.11111111.00000000
#
# AND运算   11000000.10101000.00000000.00000000
#
# 转化为十进制后为：
# 192.168.0.0
#
#
# I P 地址　 192.168.0.254
# 子网掩码　 255.255.255.0
#
#
# 转化为二进制进行运算：
#
# I P 地址　11000000.10101000.00000000.11111110
# 子网掩码  11111111.11111111.11111111.00000000
#
# AND运算  11000000.10101000.00000000.00000000
#
# 转化为十进制后为：
# 192.168.0.0
#
# 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
#
# 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
# 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
#
# 注:
# 有效掩码与IP的性质为：
# 1. 掩码与IP每一段在 0 - 255 之间
# 2. 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由'0'组成
#
# https://www.nowcoder.com/practice/34a597ee15eb4fa2b956f4c595f03218
from typing import List

import sys

ip_list = []
tmp = []
for line in sys.stdin:
    if line.strip() == "":
        break
    if len(tmp) == 3:
        ip_list.append(tmp)
        tmp = [line.strip()]
    else:
        tmp.append(line.strip())
ip_list.append(tmp)


def is_valid_code(code_str: str):
    code_int = []
    code_list = code_str.split(".")
    if len(code_list) != 4:
        return False
    code_str = ""
    for n in code_list:
        try:
            tmp_n = int(n)
        except ValueError:
            return False
        if not (0 <= tmp_n <= 255):
            return False
        code_int.append(tmp_n)
        tmp_n_str = bin(tmp_n)[2:]
        code_str += "0" * (8 - len(tmp_n_str)) + tmp_n_str

    idx_0 = code_str.find("0")
    if idx_0 == -1 or idx_0 == 0:
        return False
    if code_str.find("1", idx_0) != -1:
        return False
    return code_int


def is_valid_ip(ip_str: str):
    ip_int = []
    ip_str = ip_str.split(".")
    if len(ip_str) != 4:
        return False
    for n in ip_str:
        try:
            tmp_n = int(n)
        except ValueError:
            return False
        if not (0 <= tmp_n <= 255):
            return False
        ip_int.append(tmp_n)
    return ip_int

def belong_same_net(code: List[int], ip1: List[int], ip2: List[int]):
    for i in range(4):
        if code[i] & ip1[i] != code[i] & ip2[i]:
            return 2
    return 0

for line in ip_list:
    _code = is_valid_code(line[0])
    _ip1 = is_valid_ip(line[1])
    _ip2 = is_valid_ip(line[2])
    if _code and _ip1 and _ip1:
       print(belong_same_net(_code, _ip1, _ip2))
    else:
        print(1)
