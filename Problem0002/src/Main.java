import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] l1Values = new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		int[] l2Values = new int[] {5, 6, 4};
		
		ListNode l1Node = solution.generateNodes(l1Values);
		ListNode l2Node = solution.generateNodes(l2Values);
		
		ListNode resultNode = solution.addTwoNumbers(l1Node, l2Node);
		
		System.out.println("Done!");
	}

	
}
