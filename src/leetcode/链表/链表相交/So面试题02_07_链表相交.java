package leetcode.链表.链表相交;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点headA 和 headB，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/10 18:58
 */
public class So面试题02_07_链表相交 {
    /**
     * 这里是方法一：使用set存储其中一个链表的所有节点，再遍历另一个
     * 其他还有方法二：双指针依次遍历两个链表，遍历完一个之后遍历另一个，等两个指针相等的时候到达公共节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        while (null != headA) {
            setA.add(headA);
            headA = headA.next;
        }
        while (null != headB) {
            if (setA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
