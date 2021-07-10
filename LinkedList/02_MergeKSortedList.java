package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}
}

public class MergeKSortedList {

	public static void main(String[] args) {
		MergeKSortedList a = new MergeKSortedList();

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);

		ListNode[] list = new ListNode[3];
		list[0] = l1;
		list[1] = l2;
		list[2] = l3;
		ListNode result = a.solve(list);
		a.print(result);
	}
	private void print(ListNode node) {
		while(node != null) {
			System.out.println(node.val);
			 node = node.next;
		}
			
	}


	public ListNode solve(ListNode[] lists) {
		
		//1. 자바 8
//	     Queue<ListNode> queue= new PriorityQueue<>((a,b)-> a.val-b.val);
	     
	 	// 2
//			Queue<ListNode> queue = new PriorityQueue<>(Comp);
			
		// 3
			Queue<ListNode> queue = new PriorityQueue<>(new Comparator <>() {
				public int compare(ListNode l1, ListNode l2) {
					return l1.val -l2.val;
				}
			});
	

		ListNode head = new ListNode(0);
		ListNode res = head;

		for (ListNode list : lists) {
			if (list != null)
				queue.offer(list);
		}

		while (!queue.isEmpty()) {
			ListNode n = queue.poll();
			System.out.println("poll " + n.val);
			res.next = n;
			res = res.next;
			if (n.next != null)
				queue.offer(n.next);
		}
		return head.next;
	}

	Comparator<ListNode> Comp = new Comparator<ListNode>() {
		public int compare(ListNode a, ListNode b) {
			return a.val - b.val;
		}
	};

}
