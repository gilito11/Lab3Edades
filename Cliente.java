package part2;

public class Cliente {
    private int tiempoDeLlegada;
    private int tiempoDeSalida;

    public Cliente(int tiempoDeLlegada) {
        this.tiempoDeLlegada = tiempoDeLlegada;
        this.tiempoDeSalida = -1; // Inicialmente no se ha atendido, por lo que el tiempo de salida es -1
    }

    public int getTiempoDeLlegada() {
        return tiempoDeLlegada;
    }

    public int getTiempoDeSalida() {
        return tiempoDeSalida;
    }

    public void setTiempoDeSalida(int tiempoDeSalida) {
        this.tiempoDeSalida = tiempoDeSalida;
    }

    public int calcularTiempoTotal() {
        if (tiempoDeSalida == -1) {
            System.out.println("Error: El cliente aún no ha sido atendido.");
            return -1; // Puedes devolver un valor que indique un error o un estado no válido
        }
        return tiempoDeSalida - tiempoDeLlegada;
    }

}
