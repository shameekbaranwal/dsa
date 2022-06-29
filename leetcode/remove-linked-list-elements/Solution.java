
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
	public ListNode removeElements(ListNode head, int val) {
		ListNode newHead = head;
		while (newHead.val == val && newHead != null)
			newHead = newHead.next;

		if (newHead == null)
			return newHead;

		ListNode prev = newHead, curr = newHead.next;
		while (curr != null) {
			if (curr.val == val)
				prev.next = curr.next;
			else
				prev = prev.next;
			curr = curr.next;
		}

		return newHead;
	}
}