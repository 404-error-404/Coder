package leetcode.SoByNumber;

import leetcode.ListNode;

public class So_2 {
	static ListNode n1 = new ListNode(), n2 = new ListNode();
	
	public static void main(String[] args) {
		create(n1, new int[] {9,9,9,9,9,9,9});
		create(n2, new int[] {9,9,9,9});
		n1 = addTwoNumbers(n1, n2);
		while(null != n1) {
			System.out.print(n1.val + " ");
			n1 = n1.next;
		}
	}
	
	public static void create(ListNode head, int[] nums) {
		ListNode p = head;
		for(int i = 0; i < nums.length; i++) {
			p.val = nums[i];
			if(i == nums.length-1) {return;}
			p.next = new ListNode();
			p = p.next;
		}
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int temp = 0;
    	ListNode headListNode = l1;
    	while(null != l1.next && null != l2.next) {
    		l1.val = l1.val + l2.val + temp;
    		if(l1.val > 9) {
    			l1.val -= 10;
    			temp = 1;
    		}
    		else {
				temp = 0;
			}
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	l1.val = l1.val + l2.val + temp;
    	if(l1.val > 9) {
			l1.val -= 10;
			temp = 1;
		}
		else {
			temp = 0;
		}
    	// l1和l2有一个到头了，把到头的链表合并到一起，然后对temp进行
    	if(null == l1.next) {	// l1到头
    		l1.next = l2.next;
    	}
    	// l2到头可以直接忽略
    	
    	
    	// 接下来开始处理temp
    	while(temp == 1) {
    		if(null != l1.next) {
				l1.next.val += temp;
				if(l1.next.val <= 9) {
					temp = 0;
				}
				else {
					l1.next.val -= 10;
					l1 = l1.next;
				}
			}
			else {
				l1.next = new ListNode(temp);
				temp = 0;
			}
		}
    	return headListNode;
    }
}


