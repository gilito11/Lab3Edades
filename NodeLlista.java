package part2;

class NodeLlista<E> {
    private E persona;
    private NodeLlista<E> seguent;

    public NodeLlista(E dada) {
        this.persona = dada;
        this.seguent = null;
    }

    public E getPersona() {
        return persona;
    }

    public NodeLlista<E> getSeguent() {
        return seguent;
    }

    public void setSeguent(NodeLlista<E> seguent) {
        this.seguent = seguent;
    }
}
