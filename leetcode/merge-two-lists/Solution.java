
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
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode resultHead = new ListNode();
		ListNode current = resultHead;

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		while (list1 != null && list2 != null) {
			ListNode r = new ListNode();
			if (list1.val < list2.val) {
				r = new ListNode(list1.val);
				list1 = list1.next;
			} else {
				r = new ListNode(list2.val);
				list2 = list2.next;
			}
			current.next = r;
			current = current.next;
		}

		if (list1 != null)
			current.next = list1;
		if (list2 != null)
			current.next = list2;

		return resultHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1 = l1.next;
		l1.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2 = l2.next;
		l2.next = new ListNode(4);

		Solution obj = new Solution();
		ListNode l3 = obj.mergeTwoLists(l1, l2);
		while (l3 != null) {
			System.out.print(l3.val);
			l3 = l3.next;
		}
		System.out.println();
	}
}