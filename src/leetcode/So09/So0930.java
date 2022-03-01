package leetcode.So09;

import org.junit.jupiter.api.Test;

/**
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/9/30 13:31
 */
public class So0930 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(0, overlapHeight) * Math.max(0, overlapWidth);
        return area1 + area2 - overlapArea;
    }

    @Test
    public void testComputeArea(){
        int ax1 = -3;
        int ay1 = 0;
        int ax2 = 3;
        int ay2 = 4;

        int bx1 = 0;
        int by1 = -1;
        int bx2 = 9;
        int by2 = 2;
        System.out.println(
                computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)
        );


    }
}
