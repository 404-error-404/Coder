package leetcode.So07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建一个基于时间的键值存储类TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键key、值value，以及给定的时间戳timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用set(key, value, timestamp_prev)所存储的值，其中timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的timestamp_prev的那个值。
 * 如果没有值，则返回空字符串（""）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 张佳乐
 * @date 2021/7/10 16:50
 **/
class TimeMap {

    Map<String, List<List<Object>>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)){
            insertValue2List(map.get(key), value, timestamp);
        }
        else {
            List<List<Object>> list = new ArrayList<>();
            List<Object> listTemp = new ArrayList<>();
            listTemp.add(value);
            listTemp.add(timestamp);
            list.add(listTemp);
            map.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)){
            List<List<Object>> keyList = map.get(key);
            for (List<Object> list: keyList){
                if((int)list.get(1) <= timestamp){
                    return (String)list.get(0);
                }
            }
        }
        return "";
    }

    /**
     * 将新的值和数时间戳插入到对应的键中
     * @param list      键对应的列表
     * @param value     待插入的值
     * @param timestamp 值对应的时间戳
     */
    void insertValue2List(List<List<Object>> list, String value, int timestamp){
        List<Object> listTemp = new ArrayList<>();
        listTemp.add(value);
        listTemp.add(timestamp);
        int min = list.size() - 1;
        int max = 0;
        if ((int)list.get(max).get(1) <= timestamp){
            list.add(max, listTemp);
        }
        else if((int)list.get(min).get(1) >= timestamp){
            list.add(min, listTemp);
        }
        else {
            int mid = -1;
            while (max != mid){
                mid = (max + min) / 2;
                int temp = (int)list.get(mid).get(1) - timestamp;
                if(temp == 0){
                    max = mid;
                    min = mid;
                }
                else if (temp > 0){
                    max = mid;
                }
                else {
                    min = mid;
                }
            }
            list.add(min, listTemp);
        }
    }
}

/**
 * @author 翼灵
 */
public class So0710 {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 10));
    }
}
