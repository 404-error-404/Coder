package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 127. 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 *
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 * @author 小乐乐
 * @date 2021/10/30 14:43
 **/
public class So127 {
    /**
     * 判断两个字符串是否相似，即只相差一个字符
     * @param s1 待判断字符串
     * @param s2 待判断字符串
     * @return 是否相似
     */
    public boolean isSimilar(String s1, String s2){
        int len = s1.length();
        if (len != s2.length()){
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < len; i++){
            if (s1.charAt(i) != s2.charAt(i)){
                diffCount++;
                if (diffCount > 1){
                    return false;
                }
            }
        }
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Stack<String> wordStack = new Stack<>();
        wordStack.push(beginWord);
        int step = 1;
        int len = wordList.size();
        while (!wordList.isEmpty() && !wordStack.isEmpty()){
            String wordNow;
            Stack<String> tempStack = new Stack<>();
            step++;
            while (!wordStack.isEmpty()){
                wordNow = wordStack.pop();
                for(int i = 0; i < len;){
                    String s = wordList.get(i);
                    if (isSimilar(wordNow, s)){
                        if (s.equals(endWord)){
                            return step;
                        }
                        tempStack.push(s);
                        wordList.remove(s);
                        len--;
                    }
                    else {
                        i++;
                    }
                }
            }
            wordStack = tempStack;
        }
        return 0;
    }

    @Test
    public void testSo127(){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        System.out.println(
                ladderLength(beginWord, endWord, wordList)
        );
    }
}
