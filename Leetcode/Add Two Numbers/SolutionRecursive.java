/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SolutionRecursive {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int carry = 0;
        return helper(l1, l2, carry);
    }
    
    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry ==0)
            return null;
        
        ListNode result = new ListNode(carry);
        if (l1 != null)
            result.val += l1.val;
        if (l2 != null)
            result.val += l2.val;
        
        if (result.val >= 10) {
            carry = 1;
            result.val = result.val % 10;
        } else {
            carry = 0;
        }
        
        if (l1 != null || l2 != null || carry == 1) {
            ListNode more = helper(l1 == null ? null:l1.next,
                                   l2 == null ? null:l2.next,
                                    carry);
            result.next = more;
        }
        return result;
    }
}