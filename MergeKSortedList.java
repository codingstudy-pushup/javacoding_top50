package top50;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
	
	   public static void main(String[] args) {
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
		ListNode result = mergeKLists(list);
	   }
	   
	   public static ListNode mergeKLists(ListNode[] lists) {
			//1
//			PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator <ListNode>() {
//				public int compare(ListNode l1, ListNode l2) {
//					return l1.val -l2.val;
//				}
//			});
		   //2
		   PriorityQueue <ListNode> queue = new PriorityQueue<ListNode>(Comp);
			
			ListNode head = new ListNode(0);
			ListNode p = head;
			
			for(ListNode list : lists) {
				if(list != null)
					queue.offer(list);
			}
			
			while(!queue.isEmpty()) {
				ListNode n = queue.poll();
				System.out.print(n.val+"\t");
				p.next = n;
				p = p.next;
				if(n.next != null)
					queue.offer(n.next);
			}
			return head.next;
		}
	   
	   static Comparator<ListNode> Comp = new Comparator<ListNode>(){
	       public int compare(ListNode a, ListNode b){
	           return a.val-b.val;
	       }
	    };
}
