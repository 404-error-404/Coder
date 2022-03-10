package leetcode.链表.设计链表;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * 1. get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * 2. addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * 3. addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * 4. addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * 5. deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/9 15:13
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyListNode {
    int val;
    MyListNode last = null;
    MyListNode next = null;

    public MyListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int len = 0;
    MyListNode head;

    public MyLinkedList() {
        this.head = new MyListNode(0);
        this.head.last = this.head;
        this.head.next = this.head;
    }

    @Override
    public String toString() {
        List<Integer> strList = new ArrayList<>();
        MyListNode p = this.head.next;
        while (p != this.head) {
            strList.add(p.val);
            p = p.next;
        }
        return strList.toString();
    }

    public int get(int index) {
        if (index >= this.len || index < 0) {
            return -1;
        }
        MyListNode p = this.head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        this.len++;
        MyListNode p = new MyListNode(val);
        p.next = this.head.next;
        p.last = this.head;
        this.head.next.last = p;
        this.head.next = p;
    }

    public void addAtTail(int val) {
        this.len++;
        MyListNode p = new MyListNode(val);
        p.next = this.head;
        p.last = this.head.last;
        this.head.last.next = p;
        this.head.last = p;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > this.len) {
            return;
        }
        MyListNode p = new MyListNode(val), cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        p.next = cur.next;
        p.last = cur;
        cur.next.last = p;
        cur.next = p;
        this.len++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.len) {
            return;
        }
        MyListNode p = this.head;
        // for循环将p移动到要删除的节点上
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        p.last.next = p.next;
        p.next.last = p.last;
        this.len--;
    }
}

public class So707设计链表 {
    public void pintList(MyListNode p, int len) {
        for (int i = 0; i < len; i++) {
            p = p.next;
            System.out.print(p.val + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(38);
        myLinkedList.addAtTail(66);
        myLinkedList.addAtTail(61);
        myLinkedList.addAtTail(76);
        myLinkedList.addAtTail(26);
        myLinkedList.addAtTail(37);
        myLinkedList.addAtTail(8);
        myLinkedList.deleteAtIndex(5);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtHead(45);
        System.out.println(myLinkedList.get(4));
        myLinkedList.addAtTail(85);
        myLinkedList.addAtHead(37);
        System.out.println(myLinkedList.get(5));
        myLinkedList.addAtTail(93);
        myLinkedList.addAtIndex(10, 23);
        myLinkedList.addAtTail(21);
        myLinkedList.addAtHead(52);
        myLinkedList.addAtHead(15);
        myLinkedList.addAtHead(47);
        System.out.println(myLinkedList.get(12));
        myLinkedList.addAtIndex(6, 24);
        myLinkedList.addAtHead(64);
        System.out.println(myLinkedList.get(4));
        myLinkedList.addAtHead(31);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.addAtHead(40);
        myLinkedList.addAtTail(17);
        myLinkedList.addAtTail(15);
        myLinkedList.addAtIndex(19, 2);
        myLinkedList.addAtTail(11);
        myLinkedList.addAtHead(86);
        System.out.println(myLinkedList.get(17));
        myLinkedList.addAtTail(55);
        myLinkedList.deleteAtIndex(15);
        myLinkedList.addAtIndex(14, 95);
        myLinkedList.deleteAtIndex(22);
        myLinkedList.addAtHead(66);
        myLinkedList.addAtTail(95);
        myLinkedList.addAtHead(8);
        myLinkedList.addAtHead(47);
        myLinkedList.addAtTail(23);
        myLinkedList.addAtTail(39);
        System.out.println(myLinkedList.get(30));
        pintList(myLinkedList.head, myLinkedList.len);
        System.out.println(myLinkedList.get(27));
        myLinkedList.addAtHead(0);
        myLinkedList.addAtTail(99);
        myLinkedList.addAtTail(45);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtIndex(9, 11);
        System.out.println(myLinkedList.get(6));
        myLinkedList.addAtHead(81);
        myLinkedList.addAtIndex(18, 32);
        myLinkedList.addAtHead(20);
        myLinkedList.addAtTail(13);
        myLinkedList.addAtTail(42);
        myLinkedList.addAtIndex(37, 91);
        myLinkedList.deleteAtIndex(36);
        myLinkedList.addAtIndex(10, 37);
        myLinkedList.addAtHead(96);
        myLinkedList.addAtHead(57);
        myLinkedList.deleteAtIndex(20);
        myLinkedList.addAtTail(89);
        myLinkedList.deleteAtIndex(18);
        myLinkedList.addAtIndex(41, 5);
        myLinkedList.addAtTail(23);
        myLinkedList.addAtHead(75);
        myLinkedList.get(7);
        myLinkedList.addAtIndex(25, 51);
        myLinkedList.addAtTail(48);
        myLinkedList.addAtHead(46);
        myLinkedList.addAtHead(29);
        myLinkedList.addAtHead(85);
        myLinkedList.addAtHead(82);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtHead(38);
        myLinkedList.deleteAtIndex(14);
        myLinkedList.get(1);
        myLinkedList.get(12);
        myLinkedList.addAtHead(42);
        myLinkedList.get(42);
        myLinkedList.addAtTail(83);
        myLinkedList.addAtTail(13);
        myLinkedList.addAtIndex(14, 20);
        myLinkedList.addAtIndex(17, 34);
        myLinkedList.addAtHead(36);
        myLinkedList.addAtTail(58);
        myLinkedList.addAtTail(2);
        myLinkedList.get(38);
        myLinkedList.addAtIndex(33, 59);
        myLinkedList.addAtHead(37);
        myLinkedList.deleteAtIndex(15);
        myLinkedList.addAtTail(64);
        myLinkedList.get(56);
        myLinkedList.addAtHead(0);
        myLinkedList.get(40);
        myLinkedList.addAtHead(92);
        myLinkedList.deleteAtIndex(63);
        myLinkedList.get(35);
        myLinkedList.addAtTail(62);
        myLinkedList.addAtTail(32);

    }
}
