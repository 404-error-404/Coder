package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/9/19 19:12
 **/
public class So6 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        // 字符串转char数组
        char[] chars = s.toCharArray();
        // 存储各行的字符
        StringBuilder[] charRows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            charRows[i] = new StringBuilder();
        }

        // 先补充第一竖列
        int minLen = Math.min(chars.length, numRows);
        for (int i = 0; i < minLen; i++){
            charRows[i].append(chars[i]);
        }



        // 将各个字符分配到各行--------------------------------------
        // 当前字符添加行
        int rowNow = numRows - 2;
        //
        // 记录操作符和最大行序号
        int op = -1, maxRowIndex = numRows - 1;
        for (int i = numRows; i < chars.length; i++){
            // 添加空格
            int spaceNums;
            if(op == 1){
                spaceNums = rowNow * 2 -1;
            }
            else {
                spaceNums = (numRows-1-rowNow)*2-1;
            }
            charRows[rowNow].append(" ".repeat(spaceNums));

            charRows[rowNow].append(chars[i]);
            if (rowNow == 0) {
                op = 1;
            }
            else if (rowNow == maxRowIndex) {
                op = -1;
            }
            rowNow += op;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder: charRows){
            res.append(stringBuilder.toString());
            res.append("\n");
        }
        return res.toString();
    }

    @Test
    public void testCovert(){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}
