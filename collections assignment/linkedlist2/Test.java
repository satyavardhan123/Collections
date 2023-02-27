package str;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList listOne = new LinkedList();
        listOne.append(10);
        listOne.append(12);
        listOne.append(21);
        listOne.append(1);
        listOne.append(53);
        
        LinkedList listTwo = new LinkedList();
        listTwo.append(11);
        listTwo.append(21);
        listTwo.append(25);
        listTwo.append(53);
        listTwo.append(47);
        
        LinkedList result = LinkedList.findCommonElements(listOne, listTwo);
        LinkedListNode current = result.head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
        
        // Test case 2
        listOne = new LinkedList();
        listOne.append(51);
        listOne.append(45);
        listOne.append(63);
        listOne.append(15);
        listOne.append(82);
        
        listTwo = new LinkedList();
        listTwo.append(19);
        listTwo.append(63);
        listTwo.append(51);
        listTwo.append(87);
        listTwo.append(82);
        
        result = LinkedList.findCommonElements(listOne, listTwo);
        current = result.head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("");

	}

}
