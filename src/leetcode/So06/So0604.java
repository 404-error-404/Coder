package leetcode.So06;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 * 图片连接：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 小乐乐
 * @date 2021/6/4 20:31
 **/
public class So0604 {
    /**
     * 将一个链表放入哈希表中，然后循环另一个链表，依次检测该结点是否在哈希表中即可
     * @param headA A链表头结点
     * @param headB B链表头结点
     * @return      相交的首结点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode p = headA;
        while (null != p){
            nodeSet.add(p);
            p = p.next;
        }
        p = headB;
        while (null != p){
            if(nodeSet.contains(p)){
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
