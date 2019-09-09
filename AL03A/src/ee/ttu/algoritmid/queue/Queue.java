package ee.ttu.algoritmid.queue;

public class Queue {

    // Don't change those lines
    final Stack stack1 = new Stack();
    final Stack stack2 = new Stack();

    public void enqueue(int number) {
        stack1.push(number);
    }

    public int dequeue() {
    	int number = 0;
    	if (!stack2.isEmpty()) {
    		number = stack2.pop();
    	} else {
    		if (!stack1.isEmpty()){
    	
    		while (!stack1.isEmpty()) {
	        	stack2.push(stack1.pop());
    		}
    		number = stack2.pop();
    		}
    	}
	     
	     return number;
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}


