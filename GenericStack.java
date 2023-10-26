import java.util.LinkedList;

public class GenericStack<E> implements InterfaceStack<E> {
    private LinkedList<E> stack;

    public GenericStack() {
        stack = new LinkedList<>();
    }

    @Override
    public void push(E element) {
        stack.push(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return stack.pop();
    }

    @Override
    public int getSize() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
