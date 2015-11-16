package com.wxg.mysolution;

/**
 * @ClassName Problem2
 * @Description You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * @example (2 -> 4 -> 3) + (5 -> 6 -> 4)  <--> 342+465=708
 * @author wuxuguang
 * @date 2015-2-15 上午9:25:04
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
  
         ListNode newHead = new ListNode(0);
         ListNode p1 = l1, p2 = l2, p3=newHead;
  
         while(p1 != null || p2 != null){
             if(p1 != null){
                 carry += p1.val;
                 p1 = p1.next;
             }
  
             if(p2 != null){
                 carry += p2.val;
                 p2 = p2.next;
             }
  
             p3.next = new ListNode(carry%10);
             p3 = p3.next;
             carry /= 10;
         }
  
         if(carry==1) 
             p3.next=new ListNode(1);
  
         return newHead.next;
     }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}