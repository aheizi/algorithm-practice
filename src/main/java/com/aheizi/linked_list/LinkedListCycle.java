package com.aheizi.linked_list;

import com.aheizi.linked_list.data_structure.ListNode;

/**
 * Created by yangquan1 on 2019-08-11.
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode next = listNode;
        for (int i = 0; i < 4; i++) {
            next.next = new ListNode(i + 2);
            next = next.next;
        }
        next.next = listNode;

        // 此处因为有环，所以toString方法会内存溢出
        // System.out.println("list：" + listNode);

        System.out.println("has cycle: " + hasCycle(listNode));
    }
}
