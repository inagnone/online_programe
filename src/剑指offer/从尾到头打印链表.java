package 剑指offer;

import java.util.ArrayList;

public class 从尾到头打印链表 {
	static class ListNode {
		int val;
		ListNode next = null;
		ListNode(int val) {
			this.val = val;
		}
	}
	static ListNode createlist(String s){
		ListNode root = new ListNode(Integer.valueOf(s.charAt(0)+""));
		ListNode head = root;
		for(int i=1;i<s.length();i++){
			head.next = new ListNode(Integer.valueOf(s.charAt(i)+""));
			head = head.next;
		}
		return root;
	}

	static void addNode(ListNode listNode, ArrayList<Integer> list) {
		if(listNode == null) return ;
		addNode(listNode.next, list);
		list.add(listNode.val);
	}

	static public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listNode != null)
			addNode(listNode, list);
		return list;
	}
	
	public static void main(String[] args) {
		ListNode node = createlist("123456789156546131354684131351346846");
		printListFromTailToHead(node);
	}
}
