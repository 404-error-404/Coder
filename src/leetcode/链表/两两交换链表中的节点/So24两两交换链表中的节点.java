package leetcode.链表.两两交换链表中的节点;

import leetcode.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/10 18:36
 */
public class So24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode(), temp;
        cur.next = head;
        head = cur;
        while (null != cur.next && null != cur.next.next) {
            temp = cur.next.next;
            cur.next.next = temp.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createList(new int[]{});
        System.out.println(swapPairs(head));
    }
}
