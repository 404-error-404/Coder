package leetcode.So2021.So05;

import java.util.*;

/**
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/5/2 12:02
 **/
public class So0502 {
    public int leastBricks(List<List<Integer>> wall) {
        int high = wall.size();
        // 记录砖块的总宽度
        int sumRow = wall.get(0).stream().mapToInt(Integer::intValue).sum();
        // 宽度为1时直接返回
        if(sumRow == 1){return high;}
        // 用数组会超出内存限制，第一次碰到超内存
        // 用字典数组记录从每个缝隙往下通过砖块缝隙的数量
        Map<Integer, Integer> gap = new HashMap<>();
        for (List<Integer> wallRow: wall){
            // 记录当前行已计数的总宽度
            int sumCur = 0;
            // 最后一块砖的最右侧不用计入
            for(int i = 0; i < wallRow.size()-1; i++){
                sumCur += wallRow.get(i);
                gap.put(sumCur, gap.getOrDefault(sumCur, 0)+1);
            }
        }
        // 获取当前value中的最大值
        int max = 0;
        for (Integer value: gap.values()){
            max = max > value? max: value;
        }
        return high - Collections.max(gap.values());
    }
}
