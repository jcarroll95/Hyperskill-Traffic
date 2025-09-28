package traffic;
public class tClass implements Runnable {

    int counter = 0;
    boolean keepGoing = true;
    boolean sys = false;
    int roads = 0;
    int interval = 0;
    int openRoad = 0;
    traffic.CircularQueue queue;

    tClass(int roads, int interval, traffic.CircularQueue queue) {
        this.roads = roads;
        this.interval = interval;
        this.queue = queue;
    }

    public void run() {
        openRoad = queue.getFront();
        while (keepGoing) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (counter < Integer.MAX_VALUE) {
                counter++;
                if (counter % interval == 0) {
                    openRoad++;
                    if (openRoad > (queue.getSize() - 1))
                        openRoad = 0;
                }
            }
            if (sys)
                systemState();
        }
    }

    public void systemState() {
        System.out.print("\033[H\033[2J"); // move cursor home and clear screen
        System.out.flush();
        System.out.printf("! %ds. have passed since system startup !\n", counter);
        System.out.printf("! Number of rooads: %d !\n", roads);
        System.out.printf("! Interval: %d !\n", interval);
        System.out.println("");
        queue.printRoads(openRoad);
        System.out.println("");
        System.out.println("! Press \"Enter\" to open menu !");
    }

    public void setSys(boolean setter) {
        sys = setter;
    }
    public int getCounter() {
        return counter;
    }

    public void setRoads(int roads) {
        this.roads = roads;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setKeepGoing(boolean setter) {
        keepGoing = setter;
    }
}