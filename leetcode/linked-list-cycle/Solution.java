class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode currSlow = head;
		ListNode currFast = head;
		while (true) {
			if (currFast == null || currSlow == null || currFast.next == null || currFast.next.next == null)
				break;
			currFast = currFast.next.next;
			currSlow = currSlow.next;
			if (currFast == currSlow)
				return true;
		}
		return false;

	}

	public boolean hasCycle2(ListNode head) {
		for (int i = 0; i < 100005; i++, head = head.next) {
			if (head == null)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode n4 = new ListNode(5);
		ListNode n3 = new ListNode(4);
		n3.next = n4;
		ListNode n2 = new ListNode(3);
		n2.next = n3;
		ListNode n1 = new ListNode(2);
		n1.next = n2;
		ListNode head = new ListNode(1);
		head.next = n1;

		Solution obj = new Solution();
		obj.printList(head);
		System.out.println(obj.hasCycle(head));
	}

	void printList(ListNode h) {
		System.out.print("[ ");
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
		System.out.println("]");
	}
}