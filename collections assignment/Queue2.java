package str;
import java.util.ArrayDeque;
import java.util.Deque;

public class Queue2 {
	public static Deque<Character> updateStack(Deque<Character> inputStack) {
		//Implement your logic here
		Deque<Character> tempStack = new ArrayDeque<Character>();
		for (int i = 0; i < 3; i++) {
			tempStack.push(inputStack.removeLast()); // remove bottom 3 elements and push to tempStack
		}
		while (!tempStack.isEmpty()) {
			inputStack.push(tempStack.pop()); // pop from tempStack and push to inputStack
		}
		return inputStack;
	}

	public static void main(String[] args) {
		
		Deque<Character> inputStack = new ArrayDeque<Character>();
		inputStack.push('E');
		inputStack.push('D');
		inputStack.push('C');
		inputStack.push('B');
		inputStack.push('A');
		
		Deque<Character> resultStack = updateStack(inputStack);
		
		System.out.println("The alphabets in updated stack are:");
		for(Character alphabet: resultStack)
		    System.out.println(alphabet);
	}

}
