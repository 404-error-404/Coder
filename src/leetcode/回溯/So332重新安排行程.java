package leetcode.回溯;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * <p>
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * <p>
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/5/8 19:35
 **/
public class So332重新安排行程 {
    String start = "JFK";
    Map<String, Integer> t;
    Map<String, List<String>> station;
    List<String> res;
    int count = 0;

    public boolean dfs(String airport) {
        if (count == 0) {
            return true;
        }
        List<String> strings = station.get(airport);
        if (null == strings) {
            return false;
        }

        for (String s : strings) {
            String ticketStr = airport + "." + s;
            int tmpCount = t.get(ticketStr);
            // 该机票已用过
            if (tmpCount == 0) {
                continue;
            }
            res.add(s);
            t.put(ticketStr, tmpCount - 1);
            count--;

            if (dfs(s)) {
                return true;
            }

            count++;
            t.put(ticketStr, tmpCount);
            res.remove(res.size() - 1);
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        count = tickets.size();
        t = new HashMap<>(tickets.size());
        station = new HashMap<>(tickets.size());
        res = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            String ticketStr = from + "." + to;
            t.put(ticketStr, t.getOrDefault(ticketStr, 0) + 1);
            if (!station.containsKey(from)) {
                station.put(from, new ArrayList<>());
            }
            station.get(from).add(to);
        }

        station.forEach((key, value) -> Collections.sort(value));
        res.add(start);
        dfs(start);
        return res;
    }

    @Test
    public void test() {
        List<List<String>> tickets = new ArrayList<>();
//        List<String> tmp = new ArrayList<>();
//        tmp.add("MUC");
//        tmp.add("LHR");
//        tickets.add(tmp);
//        tmp = new ArrayList<>();
//        tmp.add("JFK");
//        tmp.add("MUC");
//        tickets.add(tmp);
//        tmp = new ArrayList<>();
//        tmp.add("SFO");
//        tmp.add("SJC");
//        tickets.add(tmp);
//        tmp = new ArrayList<>();
//        tmp.add("LHR");
//        tmp.add("SFO");
//        tickets.add(tmp);

        String[][] tick = {
                {"EZE", "AXA"},
                {"TIA", "ANU"},
                {"ANU", "JFK"},
                {"JFK", "ANU"},
                {"ANU", "EZE"},
                {"TIA", "ANU"},
                {"AXA", "TIA"},
                {"TIA", "JFK"},
                {"ANU", "TIA"},
                {"JFK", "TIA"}
        };
        for (String[] strings : tick) {
            tickets.add(Arrays.asList(strings));
        }
        List<String> itinerary = findItinerary(tickets);
        System.out.println(itinerary.toString());
    }
}
