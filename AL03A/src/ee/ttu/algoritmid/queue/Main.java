package ee.ttu.algoritmid.queue;

public class Main {

	public static void main(String[] args) {
		Queue q1 = new Queue();
		q1.enqueue(3);
		q1.enqueue(2);
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());

	}

}
