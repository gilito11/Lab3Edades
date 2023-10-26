import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Symbol[] symbols = {
                new OpenParentesi(),
                new ClosingParentesi(),
                new OpenClaudator(),
                new ClosingClaudator()
        };

        boolean expresionBalanceada = comprovarExpressio(Arrays.asList(symbols));

        if (expresionBalanceada) {
            System.out.println("La expresión está balanceada.");
        } else {
            System.out.println("La expresión no está balanceada.");
        }
    }

    public static <E extends Symbol> boolean comprovarExpressio(List<E> list) {
        Stack<E> stack = new Stack<>();

        for (E symbol : list) {
            if (esSimboloDeApertura(symbol)) {
                stack.push(symbol);
            } else if (esSimboloDeCierre(symbol)) {
                if (stack.isEmpty() || !simbolosCoinciden(stack.pop(), symbol)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean esSimboloDeApertura(Symbol symbol) {
        return "{[(".contains(symbol.getValue());
    }

    private static boolean esSimboloDeCierre(Symbol symbol) {
        return "}])".contains(symbol.getValue());
    }

    private static boolean simbolosCoinciden(Symbol openSymbol, Symbol closingSymbol) {
        String open = "{[(";
        String close = "}])";
        return open.indexOf(openSymbol.getValue()) == close.indexOf(closingSymbol.getValue());
    }

    public static void testCase_1() {
        List<Symbol> simbols = new ArrayList();
        OpenParentesi openParentesi = new OpenParentesi();
        ClosingParentesi closeParentesi = new ClosingParentesi();
        OpenClaudator openClaudator = new OpenClaudator();
        ClosingClaudator closeClaudator = new ClosingClaudator();

        simbols.add(openParentesi);
        simbols.add(openClaudator);
        simbols.add(closeClaudator);
        simbols.add(closeParentesi);

        System.out.println("Test case 1");
        System.out.println("-------");

        for (Symbol simbol : simbols) {
            System.out.println(simbol.toString());
        }

        System.out.println("-------");


        if (comprovarExpressio(simbols)) {
            System.out.println("Resultat: Expressió correcte");
            System.out.println("-------");
        } else {
            System.out.println("Resultat: Expressió incorrecte");
            System.out.println("-------");
        }
    }
}


