package pat;

import java.util.*;

public class So1032 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int id, score;
		Map<Integer, Integer> map = new HashMap<>();
		// 读入所有的分数并计算总和
		for(int i = 0; i < num; i++) {
			id = scanner.nextInt();
			score = scanner.nextInt();
			if (map.containsKey(id)) {
				map.put(id, map.get(id)+score);
			}
			else {
				map.put(id,  score);
			}
		}
		scanner.close();
		// 遍历map，找出最高分数
		List<Integer> keys_list = new ArrayList<>(map.keySet());
		int max_id = keys_list.get(0);
		for(int i: keys_list) {
			if (map.get(i) > map.get(max_id)) {
				max_id = i;
			}
		}
		System.out.print(max_id);
		System.out.print(" ");
		System.out.print(map.get(max_id));
	}
}
