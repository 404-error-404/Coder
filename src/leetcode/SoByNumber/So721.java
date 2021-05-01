package leetcode.SoByNumber;

import java.util.*;

class Node {
	Node preNode = null, nextNode = null;
	int index = 0;
}

/**
 * @author 翼灵
 */
public class So721 {
	public static void main(String[] args) {
		List<List<String>> accountsList = new ArrayList<>();
		accountsList.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		accountsList.add(Arrays.asList("John", "johnnybravo@mail.com"));
		accountsList.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
		accountsList.add(Arrays.asList("Mary", "mary@mail.com"));
		accountsList = accountsMerge(accountsList);
		for(List<String> list: accountsList) {
			for(String string: list) {
				System.out.print(string + " ");
			}
			System.out.println();
		}
	}
	
	public static void mergeNodes(Node n1, Node n2) {
		while(null != n1.nextNode) {
			n1 = n1.nextNode;
		}
		while(null != n2.nextNode) {
			n2 = n2.nextNode;
		}
		// 如果n1和n2是同一条链则直接返回
		if(n1 == n2) {
			return;
		}
		while(null != n2.preNode) {
			n2 = n2.preNode;
		}
		n1.nextNode = n2;
		n2.preNode = n1;
	}
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
    	int len = accounts.size();
    	Node[] nodes = new Node[len];
    	for(int i = 0; i < len; i++) {
    		nodes[i] = new Node(); 
    		nodes[i].index = i; 
    	}
    	Map<String, Integer> email_map = new HashMap<>();
    	// 遍历每个人的邮箱，将有重复邮箱的人串到一条链上
    	for(int i = 0; i < len; i++) {
    		for(String email: accounts.get(i).subList(1, accounts.get(i).size())) {
    			if (email_map.containsKey(email)) {
					// 整合i和email_map[i]两个结点所在的链表
    				mergeNodes(nodes[i], nodes[email_map.get(email)]);
				}
    			else {
					email_map.put(email, i);
				}
    		}
    	}
    	// 遍历结点，构造返回结果的list
    	List<List<String>> res = new ArrayList<>();
    	List<String> res_one;
    	for(Node n: nodes) {
    		res_one = new ArrayList<>();
    		// 判断是否为一条链的起始
    		if (null == n.preNode) {
				// 人名
				String name = accounts.get(n.index).get(0);
				while(null != n) {
					// 将n.index对应用户的邮箱全部加入
					for(String s: accounts.get(n.index).subList(1, accounts.get(n.index).size())) {
						if (! res_one.contains(s)) {
							res_one.add(s);
						}
					}
					n = n.nextNode;
				}
				Collections.sort(res_one);
				res_one.add(0, name);
				res.add(res_one);
			}
    	}
    	
    	return res;
    }
}
