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
        NodeLlista<E> node = new NodeLlista<>(x);
        if(isEmpty()){
            cap = node;
            cua = node;
        }
        cua.next = node;
        cua = node;
    }

    @Override
    public E remove() {
        return null;
    }



}
