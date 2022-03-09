package leetcode;

/**
 * @author 小乐乐
 * @date 2021/6/4 20:34
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 构造列表
     * @param nums 列表各结点的值
     * @return     列表头结点
     */
    public static ListNode createList(int[] nums){
        int len = nums.length;
        if(len == 0){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;

        for(int i = 1; i < len; i++){
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }
}