class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		if (head.next.next == null) {
			head.next = null;
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		slow.val = slow.next.val;
		slow.next = slow.next.next;

		return head;
	}

	public static void main(String[] args) {
		ListNode n6 = new ListNode(6);
		ListNode n5 = new ListNode(2, n6);
		ListNode n4 = new ListNode(1, n5);
		ListNode n3 = new ListNode(7, n4);
		ListNode n2 = new ListNode(4, n3);
		ListNode n1 = new ListNode(3, n2);
		ListNode head = new ListNode(1, n1);

		Solution obj = new Solution();
		obj.deleteMiddle(head);
	}
}