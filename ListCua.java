package part2;

public class ListCua<E> implements CuaInterface<E> {
    private NodeLlista<E> cap;
    private NodeLlista<E> cua;

    public ListCua() {
        this.cap = null;
        this.cua = null;
    }

    @Override
    public boolean isEmpty() {
        return cap == cua;
    }

    @Override
    public void inserir(E x) {
        NodeLlista<E> nouNode = new NodeLlista<>(x);

        if (isEmpty()) {
            cap = nouNode;
            cua = nouNode;
        } else {
            cua.setSeguent(nouNode);
            cua = nouNode;
        }
    }

    @Override
    public E treure() {
        if (cap == null) {
            throw new IllegalStateException("La cua està buida");
        }

        E dada = cap.getPersona();
        cap = cap.getSeguent();

        if (cap == null) {
            cua = null;
        }

        return dada;
    }
}

