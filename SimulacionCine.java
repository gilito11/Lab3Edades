package part2;

import java.util.Random;

public class SimulacionCine {
    private ListCua<Cliente> colaClientes;
    private int[] vectorDeCajeros;
    private static final int MAX_CAJEROS = 10;
    private static final int MAX_CLIENTES = 100;
    private static final int TIEMPO_ATENCION = 120; // Tiempo en segundos para atender a un cliente

    public SimulacionCine() {
        colaClientes = new ListCua<>();
        vectorDeCajeros = new int[MAX_CAJEROS];
    }

    public void inicializarColaClientes() {
        Random random = new Random();
        for (int i = 0; i < MAX_CLIENTES; i++) {
            int tiempoDeLlegada = random.nextInt(15 * MAX_CLIENTES); // Genera tiempos de llegada aleatorios
            colaClientes.inserir(new Cliente(tiempoDeLlegada));
        }
    }

    public void simularConCantidadDeCajeros(int numCajeros) {
        for (int i = 0; i < numCajeros; i++) {
            vectorDeCajeros[i] = 0; // Inicializa los cajeros disponibles
        }

        int tiempoTotal = 0;

        while (!colaClientes.isEmpty()) {
            for (int i = 0; i < numCajeros; i++) {
                if (!colaClientes.isEmpty() && vectorDeCajeros[i] <= colaClientes.treure().getTiempoDeLlegada()) {
                    vectorDeCajeros[i] = colaClientes.treure().getTiempoDeLlegada() + TIEMPO_ATENCION;
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < numCajeros; i++) {
                if (vectorDeCajeros[i] < min) {
                    min = vectorDeCajeros[i];
                }
            }

            for (int i = 0; i < numCajeros; i++) {
                if (vectorDeCajeros[i] == min) {
                    vectorDeCajeros[i] = 0;
                }
            }

            tiempoTotal += min;
        }

        double tiempoPromedio = (double) tiempoTotal / MAX_CLIENTES;
        System.out.println("Nombre de cajeros: " + numCajeros + " Tiempo promedio en ser atendidos (en segundos): " + tiempoPromedio);
    }

    public static void main(String[] args) {
        SimulacionCine simulacion = new SimulacionCine();
        simulacion.inicializarColaClientes();

        for (int i = 1; i <= MAX_CAJEROS; i++) {
            simulacion.simularConCantidadDeCajeros(i);
        }
    }
}
