package part2;

public class Cliente {
    private int arriveTime;
    private int exitTime;

    public Cliente(int arriveTime){
        this.arriveTime = arriveTime;
        this.exitTime = -1;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public int getTotalTime(){
        if(exitTime == -1){
            System.out.println("Error: El cliente aún no ha sido atendido.");
            return -1;
        }
        return exitTime - arriveTime;
    }
}
