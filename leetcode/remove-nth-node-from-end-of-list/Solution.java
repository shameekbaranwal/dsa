
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

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;

		ListNode nth = head;
		for (int i = 0; i < n; i++)
			nth = nth.next;

		if (nth == null)
			return head.next;

		ListNode nlast = head;
		while (nth.next != null) {
			nth = nth.next;
			nlast = nlast.next;
		}
		nlast.next = nlast.next.next;

		return head;
	}

	public static void main(String[] args) {
		// ListNode n4 = new ListNode(5);
		// ListNode n3 = new ListNode(4, n4);
		// ListNode n2 = new ListNode(3, n3);
		ListNode n1 = new ListNode(2, null);
		ListNode head = new ListNode(1, n1);

		Solution obj = new Solution();
		ListNode h = obj.removeNthFromEnd(head, 2);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
	}
}