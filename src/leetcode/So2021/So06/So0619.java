package leetcode.So2021.So06;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 *
 * 请返回所有可行解 s 中最长长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/6/19 11:00
 **/
public class So0619 {
    int ans = 0;

    public int maxLength(List<String> arr) {
        int[] masks = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            String s = arr.get(i);
            // 将字符串转为int表示的数字
            for(int j = 0; i < s.length(); j++){
                int ch = s.charAt(j) - 'a';
                ch = 1 << ch;
                // 若字符重复出现则该字符串不可取
                if((masks[i] & ch) == 1){
                    masks[i] = 0;
                    break;
                }
                masks[i] |= ch;
            }
        }
        backtrack(masks, 0, 0);
        return ans;
    }

    public void backtrack(int[] masks, int index, int mask){

    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println(
                new So0619().maxLength(arr)
        );
    }
}
