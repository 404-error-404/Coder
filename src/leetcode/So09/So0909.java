package leetcode.So09;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @date 2021/9/9 23:17
 * @author 张佳乐
**/
public class So0909 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // 返回结果
        List<String> res = new ArrayList<>();
        // 单独存
        //
        //
        // 放一行的单词
        List<String> rowWords = new ArrayList<>();
        // 当前行单词总长度
        int tempWidth = 0;
        for (String word : words) {
            if (tempWidth + word.length() + rowWords.size() > maxWidth) {
                // 处理该行单词，但是不加入当前的单词
                StringBuilder tempString = new StringBuilder();
                int blankNeeded = maxWidth - tempWidth;
                if (rowWords.size() == 1){
                    tempString.append(rowWords.get(0));
                    tempString.append(" ".repeat(maxWidth - rowWords.get(0).length()));
                }
                else {
                    int minBlank = blankNeeded / (rowWords.size() - 1);
                    int j = 0;
                    for (; j < blankNeeded % (rowWords.size()-1); j++) {
                        tempString.append(rowWords.get(j));
                        tempString.append(" ".repeat(minBlank + 1));
                    }
                    for (; j < rowWords.size() - 1; j++) {
                        tempString.append(rowWords.get(j));
                        tempString.append(" ".repeat(minBlank));
                    }
                    tempString.append(rowWords.get(rowWords.size() - 1));
                }
                res.add(tempString.toString());
                // 重置当前行单词
                tempWidth = 0;
                rowWords.clear();
            }
            tempWidth += word.length();
            rowWords.add(word);
        }


        // 最后一行左对齐，且每个单词之间只有一个空格
        StringBuilder tempString = new StringBuilder();
        int i = 0;
        for (; i < rowWords.size()-1; i++) {
            tempString.append(rowWords.get(i)).append(" ");
        }
        tempString.append(rowWords.get(i));
        // 补全空格
        tempString.append(" ".repeat(Math.max(0, maxWidth - tempString.length())));
        res.add(tempString.toString());

        return res;
    }

    @Test
    public void test0909(){
        String[] words = new String[]{
                "ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"
        };
        for (String s: fullJustify(words, 16)){
            System.out.println(s);
        }
    }

}
