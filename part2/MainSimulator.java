package part2;

public class MainSimulator {

    private static final int MAX_CAJEROS = 10;
    private static final int MAX_CLIENTES = 100;
    private static final int TIEMPO_LLEGADA = 15;
    private static final int TIEMPO_ATENCION = 120;

    public static void main(String[] args) {
        ListCua<Cliente> colaClientes = new ListCua<>();

        // Bucle que simula con diferentes cantidades de cajeros (de 1 a 10)
        for (int cajeros = 1; cajeros <= 10; cajeros++) {
            simularConCantidadDeCajeros(cajeros, colaClientes);
            colaClientes.remove();
        }
    }

    public static void simularConCantidadDeCajeros(int cajeros, ListCua<Cliente> colaClientes) {
        int[] vectorDeCajeros = new int[cajeros];

        int[] tiempoTotal = new int[MAX_CAJEROS];

        int tiempoLlegadaAcum = 0;

        // Inicializa los cajeros disponibles
        for (int i = 0; i < cajeros; i++) {
            vectorDeCajeros[i] = 0;
        }

        for (int i = 0; i < vectorDeCajeros.length; i++) {
            for (int cliente = 0; cliente < MAX_CLIENTES; cliente++) {

                // Simula la llegada de un cliente a la cola
                colaClientes.insert(new Cliente(tiempoLlegadaAcum));

                // Simula el procesamiento de clientes
                do {
                    if (tiempoTotal[i] <= tiempoLlegadaAcum) {
                        tiempoTotal[i] = TIEMPO_ATENCION;
                        tiempoLlegadaAcum += TIEMPO_LLEGADA;
                    } else if (tiempoTotal[i] != tiempoLlegadaAcum) {
                        tiempoTotal[i] = TIEMPO_ATENCION;
                        tiempoLlegadaAcum += TIEMPO_LLEGADA;
                    }
                } while (!colaClientes.isEmpty());
            }
        }

        // Cálculo del tiempo promedio
        int tiempoCapazProceso = cajeros * TIEMPO_ATENCION;
        int tiempoAtencion = tiempoTotal[vectorDeCajeros.length - 1] / cajeros;
        int tiempoPromedio = tiempoAtencion / cajeros * TIEMPO_ATENCION;

        // Imprimir el resultado
        System.out.println("Nombre de cajeros: " + vectorDeCajeros.length +
                " Tiempo promedio en ser atendidos (en segundos): " + tiempoPromedio);
    }
}
