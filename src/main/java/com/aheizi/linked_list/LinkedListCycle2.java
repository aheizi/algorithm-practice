package com.aheizi.linked_list;

import com.aheizi.linked_list.data_structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangquan1 on 2019-08-13.
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycle2 {

    /**
     * 使用set保存迭代过的节点
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> listNodes = new HashSet<ListNode>();
        ListNode node = head;
        while (node != null) {
            if (listNodes.contains(node)) {
                return node;
            }
            listNodes.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * Floyd 算法
     *
     * 2(F+a) = F+a+b+a
     * 2F+2a = F+2a+b
     * F = b
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        // 第一步，快慢指针找出碰撞点
        ListNode crash = getCrash(head);
        if (crash == null) {
            return null;
        }

        // 第二步，两个指针一步一步走，相遇即是环的起点
        ListNode l1 = head;
        ListNode l2 = crash;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    public static ListNode getCrash(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }
}
