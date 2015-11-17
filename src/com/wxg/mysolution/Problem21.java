package com.wxg.mysolution;

import com.wxg.mysolution.list.ListNode;


public class Problem21 {
    public static void main(String[] args) {

    }

    /**
     * Merge two lists.
     *
     * @param l1 the l1
     * @param l2 the l2
     * @return the list node
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result = null;
        ListNode newNode = null;
        while (l1 != null && l2 != null){
            ListNode temp = null;
            if (l1.val > l2.val){
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }
            if (result == null){
                result = temp;
                newNode = result;
            }else{
                result.next = temp;
                result = result.next;
            }
        }
        if (l1 != null)
            result.next = l1;
        if (l2 != null)
            result.next = l2;
        return newNode;
    }
}


