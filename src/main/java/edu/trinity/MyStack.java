
package edu.trinity;
import java.util.Stack;
import java.util.EmptyStackException;
public class MyStack<T> {
    private Stack<T> stack = new Stack<T>();
    public void push(T hello) {
       stack.push(hello);
    }

    public T peek() {
        if(isEmpty()){
            throw  new EmptyStackException();
        }
        return stack.peek();
    }

    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}