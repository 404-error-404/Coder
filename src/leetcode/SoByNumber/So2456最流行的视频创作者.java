package leetcode.SoByNumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。平台上第 i 个视频者是 creator[i] ，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。
 * <p>
 * 视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。
 * <p>
 * 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。
 * 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。
 * 返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的视频 id 是 idi ，可以按任何顺序返回该结果。
 * https://leetcode.cn/problems/most-popular-video-creator/
 *
 * @author 小乐乐
 * @date 2023/10/18 20:53
 **/
public class So2456最流行的视频创作者 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        // 整理到字典中
        HashMap<String, List<String>> creatorId = new HashMap<>();
        HashMap<String, Integer> idView = new HashMap<>();

        for (int i = 0; i < creators.length; i++) {
            List<String> tmp = creatorId.getOrDefault(creators[i], null);
            if (tmp == null) {
                tmp = new ArrayList<>();
                tmp.add(ids[i]);
            } else {
                int curMax = idView.get(tmp.get(0));    // 已遍历歌曲中最大播放量
                if ((views[i] == curMax) && (tmp.get(0).compareTo(ids[i]) > 0)){
                    tmp.add(0, ids[i]);
                }
                else if (views[i] > curMax) {
                    tmp.add(0, ids[i]);
                }
                else{
                    tmp.add(ids[i]);
                }
            }

            creatorId.put(creators[i], tmp);
            idView.put(ids[i], views[i]);
        }

        // 开始计算播放量
        int maxView = 0;
        List<String> maxViewCreators = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : creatorId.entrySet()) {
            int tmpView = 0;
            for (String id : entry.getValue()) {
                tmpView += idView.get(id);
            }
            if (tmpView == maxView) {
                maxViewCreators.add(entry.getKey());
            } else {
                maxViewCreators.clear();
                maxViewCreators.add(entry.getKey());
                maxView = tmpView;
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String maxViewCreator : maxViewCreators) {
            // 拿到了歌手名字，接下来查看其最大播放量的歌曲
            res.add(Arrays.asList(maxViewCreator, creatorId.get(maxViewCreator).get(0)));
        }
        return res;
    }

    @Test
    public void test() {
        List<List<String>> res = mostPopularCreator(
            new String[]{"alice", "bob", "alice", "chris"},
            new String[]{"zone", "two", "three", "four"},
            new int[]{5, 10, 5, 4}
        );
        System.out.println(res);
    }
}
