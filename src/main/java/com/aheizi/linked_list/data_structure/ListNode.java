package com.aheizi.linked_list.data_structure;

/**
 * Created by yangquan1 on 2019-08-11.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            result.append(current.val);
            result.append(" ");
            current = current.next;
        }
        return result.toString();
    }
}
