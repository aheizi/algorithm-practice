package com.aheizi.linked_list;

import com.aheizi.linked_list.data_structure.ListNode;

/**
 * Created by yangquan1 on 2019-08-11.
 *
 * 题目来源：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    /**
     * 迭代
     *
     * 基本思路：保留pre和next
     * 1. 节点没有引用其上一个节点，因此必须事先存储其前一个元素
     * 2. 改变next的时候，会丢失原next节点，事先存储
     *
     * 一句话总结：当前node指向上一个node，还要知道下一个node是谁
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNode = current.next;
            current.next = pre;
            pre = current;
            current = tempNode;
        }
        return pre;
    }

    /**
     * 递归
     *
     * 好难懂
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode next = node;
        for (int i = 0; i < 4; i++) {
            next.next = new ListNode(i + 2);
            next = next.next;
        }
        System.out.println("before reverse：" + node);

        ListNode reversedNode1 = reverseList1(node);
        System.out.println("after reverse1: " + reversedNode1);

        ListNode reversedNode2 = reverseList2(reversedNode1);
        System.out.println("after reverse2: " + reversedNode2);
    }
}
