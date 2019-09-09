package ee.ttu.algoritmid.queue;

import java.util.ArrayDeque;

/**
 * SEDA FAILI MITTE MUUTA
 */
public class Stack {

    private final ArrayDeque<Integer> innerStack = new ArrayDeque<>();

    public void push(Integer number) {
        innerStack.push(number);
    }

    public Integer pop() {
        return innerStack.pop();
    }

    public boolean isEmpty() {
        return innerStack.isEmpty();
    }

}
