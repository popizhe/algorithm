package ray.liu.algorithm.lee.algorithm.medium;

/**
 * total 46 mins for all
 * https://leetcode.com/problems/add-two-numbers/#/description 
 * @author ray
 *
 */
public class AddTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode head = null;
		 ListNode tail = new ListNode(0);
		 int b = 0;
		 while(l1 != null || l2 != null || b != 0){
			 int eachValue = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + b;
			 if(eachValue > 9) {
				 b = eachValue / 10;
				 eachValue = eachValue % 10;
			 } else {
				 b = 0;
			 }
			 ListNode current = new ListNode(eachValue);
			 tail = tail.next = current;
			 if(head == null) {
				 head = current;
			 }
			 l1 = l1 == null ? null : l1.next;
			 l2= l2 == null ? null : l2.next;
		 }
		 return head;
	 }
	 
	 public static void main(String[] args) {
		AddTwoNumbers ad = new AddTwoNumbers();
		ListNode l1head = new ListNode(2);
		ListNode l1n = new ListNode(4);
		ListNode l1nn = new ListNode(3);
		l1n.next = l1nn;
		l1head.next = l1n;
		ListNode l2head = new ListNode(5);
		ListNode l2n = new ListNode(6);
		ListNode l2nn = new ListNode(4);
		l2head.next = l2n;
		l2n.next = l2nn;
		System.out.println(l1head);
		System.out.println(l2head);
		ListNode wrong1 = new ListNode(0);
		ListNode wrong2 = new ListNode(1);
//		ListNode head = ad.addTwoNumbers(l1head, l2head);
//		System.out.println("--> " + head);
		ListNode wrong = ad.addTwoNumbers(wrong1, wrong2);
		System.out.println("--> " + wrong);
	}
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
	@Override
	public String toString() {
		return next == null ? "val= " + val + " and no more node." : "val=" + val + " : " +  next.toString();
	}
      
}
