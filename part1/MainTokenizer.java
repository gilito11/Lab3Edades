package part1;

import java.util.*;
public class MainTokenizer {

    public static void main (String[]args){
        List<Symbol> listaDeSimbolos = new ArrayList<>();

        listaDeSimbolos.add(new OpenClaudator());
        listaDeSimbolos.add(new ClosingClaudator());
        listaDeSimbolos.add(new ClosingParentesis());
        listaDeSimbolos.add(new OpenParentesis());


        boolean resultado = comprovarExpressio(listaDeSimbolos);
        if (resultado) {
            System.out.println("La expresión es válida.");
        } else {
            System.out.println("La expresión no es válida.");
        }
    }



    public static <E extends Symbol> boolean comprovarExpressio(List<E> list){
        Pila<Symbol> pila = new Pila<>();

        for (E symbol : list) {
            if (symbol instanceof Symbol) {
                if(symbol instanceof OpenClaudator){
                    pila.push(symbol);
                } else if(symbol instanceof OpenParentesis){
                    pila.push(symbol);
                } else if(symbol instanceof ClosingParentesis) {
                    Symbol aux = pila.pop();
                    if ((aux instanceof OpenParentesis)==false){
                        return false;
                    }
                } else if(symbol instanceof ClosingClaudator) {
                    Symbol aux = pila.pop();
                    if ((aux instanceof OpenClaudator)==false) return false;
                }
            } else {
                return false;
            }
        }
        return pila.isEmpty();
    }

}
