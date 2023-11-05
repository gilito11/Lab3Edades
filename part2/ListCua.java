package part2;

public class ListCua<E> implements CuaInterface<E>{
    private NodeLlista<E> cap;
    private NodeLlista<E> cua;

    @Override
    public boolean isEmpty() {
        return cap == cua;
    }

    @Override
    public void insert(E x) {
        NodeLlista<E> nouNode = new NodeLlista<>(x);
        if(isEmpty()){
            cap = nouNode;
            cua = nouNode;
        }
        cua.setNext(nouNode);
        cua = nouNode;
    }

    @Override
    public E remove() {
        if (cap == null) {
            throw new IllegalStateException("La cua està buida");
        }

        E node = cap.getPerson();
        cap = cap.getNext();

        if (cap == null) {
            cua = null;
        }

        return node;
    }



}
