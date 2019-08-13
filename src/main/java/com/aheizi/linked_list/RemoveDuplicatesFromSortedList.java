package com.aheizi.linked_list;

import com.aheizi.linked_list.data_structure.ListNode;

/**
 * Created by yangquan1 on 2019-08-13.
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * 迭代
     *
     * 遇到相同的元素，直接跳过
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while (head.next != null) {
            if (head.val == head.next.val) {
                pre.next = head.next;
            } else {
                pre.next = head;
                pre = head;
            }
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);

        // 1->2->4
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l3.next = null;

        ListNode result = deleteDuplicates(l1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
