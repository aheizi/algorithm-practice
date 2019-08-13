package com.aheizi.linked_list;

import com.aheizi.linked_list.data_structure.ListNode;

/**
 * Created by yangquan1 on 2019-08-11.
 *
 * 题目来源：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs {

    /**
     * 主要思路是需要预存哪几个节点
     *
     * pre 的重要性，交换之后如何连接起来，必须要有pre
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode tempPre = pre;
        while (tempPre.next != null && tempPre.next.next != null) {
            ListNode current = tempPre.next;
            ListNode next = current.next;

            tempPre.next = next;
            current.next = next.next;
            next.next = current;

            tempPre = current;
        }

        return pre.next;
    }

    /**
     * 递归：待实现 囧
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode next = node;
        for (int i = 0; i < 4; i++) {
            next.next = new ListNode(i + 2);
            next = next.next;
        }
        System.out.println("before swap：" + node);

        ListNode swapPairs = swapPairs1(node);
        System.out.println("after swap: " + swapPairs);
    }

}
