package leetcode.SoByNumber;

import leetcode.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/9/16 16:37
 */
public class So2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 记录l1表头，用于最后返回
        ListNode head1 = l1;
        // 记录是否进位
        int temp = 0;
        while (null != l1.next && null != l2.next){
            l1.val += l2.val + temp;
            if (l1.val > 9){
                temp = 1;
                l1.val -= 10;
            }
            else {
                temp = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        // 处理最后一个非空节点
        l1.val += l2.val + temp;
        if (l1.val > 9){
            temp = 1;
            l1.val -= 10;
        }
        else {
            temp = 0;
        }
        // 将剩下的非空节点接到l1后边
        if (null == l1.next) {
            l1.next = l2.next;
        }
        // 处理进位
        while (temp == 1){
            temp = 0;
            if (l1.next == null){
                l1.next = new ListNode(1);
            }
            else {
                l1.next.val += 1;
                if(l1.next.val > 9){
                    l1.next.val -= 10;
                    l1 = l1.next;
                    temp = 1;
                }
            }
        }
        return head1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode().createList(new int[]{2,4,3});
        ListNode l2 = new ListNode().createList(new int[]{5,6,4});
        ListNode listNode = new So2().addTwoNumbers(l1, l2);
        while (null != listNode){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }


}
