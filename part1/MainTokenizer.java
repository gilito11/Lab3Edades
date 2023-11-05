package part1;

import java.util.*;
public class MainTokenizer {

    public static void main (String[]args){

        testCase_1();
        testCase_2();
        testCase_3();


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
    public static void testCase_1(){
        List<Symbol> simbols = new ArrayList<>();
        OpenParentesis openParentesis = new OpenParentesis();
        ClosingParentesis closingParentesis = new ClosingParentesis();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closingClaudator = new ClosingClaudator();

        simbols.add(openClaudator);
        simbols.add(closingClaudator);
        simbols.add(openParentesis);
        simbols.add(closingParentesis);


        System.out.println("Test Case 1: ");
        System.out.println("-------------");
        for (Symbol simbol : simbols){
            System.out.println(simbol.toString());
        }
        System.out.println("-------------");


        boolean resultado = comprovarExpressio(simbols);
        if (resultado) {
            System.out.println("Resultat: Espressió correcte.");
            System.out.println("-------------");
        } else {
            System.out.println("Resultat: Espressió incorrecte.");
            System.out.println("-------------");
        }

    }
    public static void testCase_2(){
        List<Symbol> simbols = new ArrayList<>();
        OpenParentesis openParentesis = new OpenParentesis();
        ClosingParentesis closingParentesis = new ClosingParentesis();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closingClaudator = new ClosingClaudator();

        simbols.add(openClaudator);
        simbols.add(closingClaudator);
        simbols.add(openParentesis);
        simbols.add(closingParentesis);


        System.out.println("Test Case 2: ");
        System.out.println("-------------");
        for (Symbol simbol : simbols){
            System.out.println(simbol.toString());
        }
        System.out.println("-------------");


        boolean resultado = comprovarExpressio(simbols);
        if (resultado) {
            System.out.println("Resultat: Espressió correcte.");
            System.out.println("-------------");
        } else {
            System.out.println("Resultat: Espressió incorrecte.");
            System.out.println("-------------");
        }
    }

    public static void testCase_3(){
        List<Symbol> simbols = new ArrayList<>();
        OpenParentesis openParentesis = new OpenParentesis();
        ClosingParentesis closingParentesis = new ClosingParentesis();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closingClaudator = new ClosingClaudator();

        simbols.add(closingClaudator);
        simbols.add(openClaudator);
        simbols.add(openParentesis);
        simbols.add(closingParentesis);

        System.out.println("Test Case 3: ");
        System.out.println("-------------");
        for (Symbol simbol : simbols){
            System.out.println(simbol.toString());
        }
        System.out.println("-------------");


        boolean resultado = comprovarExpressio(simbols);
        if (resultado) {
            System.out.println("Resultat: Espressió correcte.");
            System.out.println("-------------");
        } else {
            System.out.println("Resultat: Espressió incorrecte.");
            System.out.println("-------------");
        }

    }



}
