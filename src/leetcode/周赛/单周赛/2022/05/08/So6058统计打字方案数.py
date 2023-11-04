# Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
# 
# 
# 
# 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
# 
# 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
# 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
# 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
# 
# 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
# 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
# 
# 由于答案可能很大，将它对 109 + 7 取余 后返回。
# 
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/count-number-of-texts
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution:
    num_dict = {
        "2": 3,
        "3": 3,
        "4": 3,
        "5": 3,
        "6": 3,
        "7": 4,
        "8": 3,
        "9": 4
    }

    counts3 = []
    counts4 = []

    def get_count3(self, length: int) -> int:
        if self.counts3[length] != 0:
            return self.counts3[length]

        res = 0
        for i in range(1, min(3, length) + 1):
            res += self.get_count3(length - i)
        self.counts3[length] = res
        return res

    def get_count4(self, length: int) -> int:
        if self.counts4[length] != 0:
            return self.counts4[length]

        res = 0
        for i in range(1, min(4, length) + 1):
            res += self.get_count4(length - i)
        self.counts4[length] = res
        return res

    def countTexts(self, pressedKeys: str) -> int:
        self.counts3 = [0] * (len(pressedKeys) + 1)
        self.counts3[0] = 1

        self.counts4 = [0] * (len(pressedKeys) + 1)
        self.counts4[0] = 1

        res = 1

        cur = pressedKeys[0]
        count = 1

        for i in pressedKeys[1:]:
            if i == cur:
                count += 1
            else:
                if self.num_dict[cur] == 3:
                    res = res * self.get_count3(count) % 1000000007
                else:
                    res = res * self.get_count4(count) % 1000000007
                cur = i
                count = 1

        if self.num_dict[cur] == 3:
            res = res * self.get_count3(count) % 1000000007
        else:
            res = res * self.get_count4(count) % 1000000007
        return res


s = Solution()
print(s.countTexts("88882222"))
