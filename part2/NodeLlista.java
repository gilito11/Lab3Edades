package part2;

public class NodeLlista <E>{
    private E person;
    private NodeLlista<E> next;

    public NodeLlista(E x) {
        this.person = x;
        this.next = null;
    }

    public E getPerson() {
        return person;
    }

    public NodeLlista<E> getNext() {
        return next;
    }

    public void setNext(NodeLlista<E> next) {
        this.next = next;
    }
}
