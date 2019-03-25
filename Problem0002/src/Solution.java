import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ArrayList<Integer> l1Numbers = new ArrayList<>();
		l1Numbers.add(l1.val);

		while (l1.next != null) {
			l1 = l1.next;
			l1Numbers.add(l1.val);
		}

		ArrayList<Integer> l2Numbers = new ArrayList<>();
		l2Numbers.add(l2.val);

		while (l2.next != null) {
			l2 = l2.next;
			l2Numbers.add(l2.val);
		}
		
		ArrayList<Integer> resultArrayList = new ArrayList<>();
		
		int sizeOfLargestArray = l1Numbers.size() > l2Numbers.size() ? l1Numbers.size() : l2Numbers.size();
		
		while (l1Numbers.size() < sizeOfLargestArray) {
			l1Numbers.add(l1Numbers.size(), 0);
		}

		while (l2Numbers.size() < sizeOfLargestArray) {
			l2Numbers.add(l2Numbers.size(), 0);
		}
		
		int carryover = 0;
		for (int currentDigit = 0; currentDigit < sizeOfLargestArray; currentDigit++) {
			int sum = l1Numbers.get(currentDigit) + l2Numbers.get(currentDigit) + carryover;
			if ( sum > 9) {
				sum -= 10;
				carryover = 1;
			} else {
				carryover = 0;
			}
			resultArrayList.add(sum);
		}
		
		if (carryover == 1) {
			resultArrayList.add(1);
		}

		int[] list2 = new int[resultArrayList.size()];
		for (int i = 0; i < list2.length; i++) {
			list2[i] = resultArrayList.get(i);
		}
		
		return generateNodes(list2);
	}

	ListNode generateNodes(int[] values) {
		ArrayList<ListNode> nodes = new ArrayList<>();
		ListNode currentNode = new ListNode(values[0]);
		nodes.add(currentNode);

		for (int i = 0; i < values.length - 1; i++) {
			currentNode.next = new ListNode(values[i + 1]);
			nodes.add(currentNode.next);
			currentNode = nodes.get(i + 1);
		}

		return nodes.get(0);

	}
}