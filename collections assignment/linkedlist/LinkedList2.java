package str;

public class LinkedList2 {
	 public int data;
	    public LinkedList2 next;

	    public LinkedList2(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}

	 class LinkedList {
	    private LinkedList2 head;

	    public LinkedList() {
	        this.head = null;
	    }

	    public LinkedList2 getHead() {
	        return head;
	    }

	    public void setHead(LinkedList2 head) {
	        this.head = head;
	    }

	    public void insert(int data) {
	        LinkedList2 newNode = new LinkedList2(data);
	        if (head == null) {
	            head = newNode;
	        } else {
	            LinkedList2 currentNode = head;
	            while (currentNode.next != null) {
	                currentNode = currentNode.next;
	            }
	            currentNode.next = newNode;
	        }
	    }

	    public void removeDuplicates() {
	        if (head == null) {
	            return;
	        }
	        LinkedList2 currentNode = head;
	        while (currentNode != null) {
	            LinkedList2 runnerNode = currentNode;
	            while (runnerNode.next != null) {
	                if (runnerNode.next.data == currentNode.data) {
	                    runnerNode.next = runnerNode.next.next;
	                } else {
	                    runnerNode = runnerNode.next;
	                }
	            }
	            currentNode = currentNode.next;
	        }
	    }

	    public void printList() {
	        LinkedList2 currentNode = head;
	        while (currentNode != null) {
	            System.out.print(currentNode.data + "->");
	            currentNode = currentNode.next;
	        }
	        System.out.println("");
	    }

}
