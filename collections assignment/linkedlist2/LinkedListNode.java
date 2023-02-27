package str;
import java.util.HashSet;

public class LinkedListNode {
	 public int data;
	    public LinkedListNode next;
	    
	    public LinkedListNode(int data) {
	        this.data = data;
	    }
	}

	 class LinkedList {
	    public LinkedListNode head;
	    
	    public void append(int data) {
	        if (head == null) {
	            head = new LinkedListNode(data);
	            return;
	        }
	        
	        LinkedListNode current = head;
	        while (current.next != null) {
	            current = current.next;
	        }
	        current.next = new LinkedListNode(data);
	    }
	    
	    public static LinkedList findCommonElements(LinkedList listOne, LinkedList listTwo) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        LinkedList result = new LinkedList();
	        
	        LinkedListNode current = listOne.head;
	        while (current != null) {
	            set.add(current.data);
	            current = current.next;
	        }
	        
	        current = listTwo.head;
	        while (current != null) {
	            if (set.contains(current.data)) {
	                result.append(current.data);
	            }
	            current = current.next;
	        }
	        
	        return result;
	    }

}
