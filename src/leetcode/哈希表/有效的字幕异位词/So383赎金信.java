package leetcode.哈希表.有效的字幕异位词;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/11 0:05
 **/
public class So383赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int base = 'a';
        for (char c : magazine.toCharArray()) {
            count[(int)c - base]++;
        }
        for (char c: ransomNote.toCharArray()){
            int index = (int)c - base;
            count[index]--;
            if (count[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
