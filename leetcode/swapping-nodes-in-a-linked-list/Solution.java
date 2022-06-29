
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
	public ListNode swapNodes(ListNode head, int k) {
		ListNode kth = head;
		for (int i = 1; i < k; i++)
			kth = kth.next;

		int val = kth.val;

		ListNode curr = kth;
		ListNode klast = head;
		while (curr.next != null) {
			klast = klast.next;
			curr = curr.next;
		}

		kth.val = klast.val;
		klast.val = val;

		return head;
	}

	public static void main(String[] args) {
		// ListNode n4 = new ListNode(5);
		// ListNode n3 = new ListNode(4, n4);
		// ListNode n2 = new ListNode(3, n3);
		ListNode n1 = new ListNode(2, null);
		ListNode head = new ListNode(1, n1);

		Solution obj = new Solution();
		ListNode h = obj.swapNodes(head, 2);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
	}
}