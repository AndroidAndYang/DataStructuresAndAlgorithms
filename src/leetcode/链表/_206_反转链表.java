package leetcode.链表;

/**
 * link：https://leetcode-cn.com/problems/reverse-linked-list/
 */

public class _206_反转链表 {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; //前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (head != null) {
            ListNode nextTemp = head.next; //临时节点，暂存当前节点的下一节点，用于后移
            head.next = prev; //将当前节点指向它前面的节点
            prev = head; //前指针后移
            head = nextTemp; //当前指针后移
        }
        return prev;
    }
}
