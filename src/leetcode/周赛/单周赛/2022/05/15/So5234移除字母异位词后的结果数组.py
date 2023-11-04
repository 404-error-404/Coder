# 给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
#
# 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
#
# 1. 0 < i < words.length
# 2. words[i - 1] 和 words[i] 是 字母异位词 。
#
# 只要可以选出满足条件的下标，就一直执行这个操作。
#
# 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
#
# 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


class Solution:
    def get_row_word(self, word: str) -> str:
        word = list(word)
        word.sort()
        return "".join(word)

    def removeAnagrams(self, words: List[str]) -> List[str]:
        res = [words[0]]
        i = 1
        while i < len(words):
            w = words[i]
            lw = words[i - 1]

            row_word = self.get_row_word(w)
            row_wordl = self.get_row_word(lw)
            if row_wordl != row_word:
                res.append(w)
            i += 1
        return res


www = ["abba", "baba", "bbaa", "cd", "cd"]
s = Solution()
res = s.removeAnagrams(www)
print(res)
