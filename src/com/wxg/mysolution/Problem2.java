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
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	int carry;
    	int tmp;
    	if(l1.val + l2.val > 9){
    		carry = 1;
    		tmp = l1.val + l2.val - 10;
    	}else{
    		carry = 0;
    		tmp = l1.val + l2.val;
    	}
    	ListNode result = new ListNode(tmp);
    	ListNode tempNode = result;
    	while(l1.next != null || l2.next != null || carry > 0){
    		tmp = carry;
    		if(l1.next != null){
    			l1 = l1.next;
    			tmp += l1.val;
    		}
    		if(l2.next != null){
    			l2 = l2.next;
    			tmp += l2.val;
    		}
    		if(tmp > 9){
    			tmp = tmp - 10;
    			carry= 1;
    		}else
    			carry = 0;
    		ListNode node = new ListNode(tmp);
    		tempNode.next = node;
    		tempNode = tempNode.next;
    	}
    	return result;
    }
    
}


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}