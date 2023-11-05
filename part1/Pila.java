package part1;

import java.util.ArrayList;

public class Pila<E> implements InterfaceStack<E>{
    private ArrayList<E> pila;
    private int stackPointer;
    public Pila(){
        stackPointer = 0;
        pila = new ArrayList<E>();
    }
    @Override
    public void push(E element) {
        pila.add(element);
        stackPointer++;
    }

    @Override
    public E pop() {
        if(this.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("ERROR PILA BUIDA");
        } else{
            stackPointer--;
            E result = pila.get(stackPointer);
            pila.remove(stackPointer);
            return result;
        }
    }

    @Override
    public int getSize() {
        return pila.size();
    }

    @Override
    public boolean isEmpty() {
        return pila.isEmpty();
    }
}
