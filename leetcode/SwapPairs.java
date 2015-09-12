public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode cur = ans;
        ListNode slow = ans;
        ListNode fast = ans;
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	ListNode temp = fast.next;
        	cur.next = fast;
        	fast.next = slow;
        	slow.next = temp;
        	cur = fast;
        }
        return ans.next;
    }
}