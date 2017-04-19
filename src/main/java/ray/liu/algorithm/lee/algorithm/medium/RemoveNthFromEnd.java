package ray.liu.algorithm.lee.algorithm.medium;

import java.time.LocalDate;
import java.time.Month;

public class RemoveNthFromEnd {

	ListNode head = null;

	public ListNode r(int n){
		ListNode dummy = new ListNode(0);
		dummy.next = this.head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) {
			return head;
		}
		if(n<=0){
			return head;
		}

		int last = 0;
		ListNode x , cu, h = null, tmp; h = new ListNode(0);h.next = head; x=cu=h;
		while(x != null && cu != null) {
			if( x.next == null ) { // x is tail, need to remove cu.next
				tmp = cu.next.next;
				cu.next.next = null;
				int val = cu.next.val;
				cu.next = tmp;
				System.out.println("val = " + val);
				break;
			}
			if(last-n +1>0){
				cu = cu.next;
			}
			x = x.next;
			last++;
		}
		return h.next;
	}

	public ListNode assumble(ListNode x, int val){
		if(x == null) {
			x =  new ListNode(val);
		}else {
			x.next = this.assumble(x.next, val);
		}
		return x;
	}

	public static void main(String[] args) {
		RemoveNthFromEnd r = new RemoveNthFromEnd();
		int[] tags = {1,2,3,4,5};
		for(int i : tags){
			r.head = r.assumble(r.head, i);
		}

		int re1 = 2;
		System.out.println(r.head.print() + " <--- " + re1);
		ListNode n1 = r.removeNthFromEnd(r.head, re1);
		System.out.println(RemoveNthFromEnd.print(n1));
		RemoveNthFromEnd r2 = new RemoveNthFromEnd();
		int[] tags2 = {1};
		for(int i : tags2){
			r2.head = r2.assumble(r2.head, i);
		}
		int re2 = 1;
		System.out.println(r2.head.print() + " <--- " + re2);
		//		ListNode n2 = r2.r(re2);
		ListNode n2 = r2.removeNthFromEnd(r2.head, re2);
		System.out.println(RemoveNthFromEnd.print(n2));

		RemoveNthFromEnd r3 = new RemoveNthFromEnd();
		int[] tags3 = {1,2};
		for(int i : tags3){
			r3.head = r3.assumble(r3.head, i);
		}
		int re3 =1 ;
		System.out.println(r3.head.print() + " <--- " + re3);
		//		ListNode n3 =r3.r(re3);
		ListNode n3 =r3.removeNthFromEnd(r3.head, re3);
		System.out.println(RemoveNthFromEnd.print(n3));

		RemoveNthFromEnd r4 = new RemoveNthFromEnd();
		int[] tags4 = {1,2};
		for(int i : tags4){
			r4.head = r4.assumble(r4.head, i);
		}
		int re4 = 2;
		System.out.println(r4.head.print() + " <--- " + re4);
		ListNode n4 =r4.removeNthFromEnd(r4.head, re4);
		System.out.println(RemoveNthFromEnd.print(n4));

		LocalDate ld = LocalDate.of(1987, Month.JUNE, 28);
		System.out.println(ld);
	}

	public static String print(ListNode x){
		if(x == null) {
			return "[]";
		}else {
			return x.print();
		}
	}

	//  Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { this.val = x; }

		public String print(){
			return "[" + this.printRes() + "]";
		}

		private String printRes(){
			String append = "";
			if(this.next != null) {
				append = this.next.printRes();
			}
			return this.val + " " +  append;
		}

		@Override
		public String toString(){
			return String.valueOf(this.val);
		}


	}
}

