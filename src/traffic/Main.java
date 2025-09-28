package traffic;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Welcome to the traffic management system!\n");
        Scanner input = new Scanner(System.in);
        int roads = 0;
        int interval = 0;
        String menuchoice;
        boolean roadsFlag = false;
        boolean intFlag = false;
        int state = 0;

        if (state == 0) {
            System.out.print("Input the number of roads: ");
            while (!roadsFlag) {
                try {
                    String tester = input.nextLine();
                    //input.nextLine();
                    roads = Integer.parseInt(tester);
                } catch (NumberFormatException e) {
                    //System.out.println("test.");
                }
                if (roads > 0)
                    roadsFlag = true;
                else
                    System.out.println("Incorrect input. Try again.");
            }
            System.out.print("Input the interval: ");
            while (!intFlag) {
                String testinterval = input.nextLine();
                //input.nextLine();
                try {
                    interval = Integer.parseInt(testinterval);
                } catch (NumberFormatException e) {

                }
                if (interval > 0)
                    intFlag = true;
                else
                    System.out.println("Incorrect input. Try again.");
            }
        }

        // implement the circularqueue
        CircularQueue myCircle = new CircularQueue(roads);
        state = 1;
        // Implement the new thread for system state:
        //stateSystem sys = new stateSystem();
        tClass myT = new tClass(roads, interval, myCircle);
        Thread myThread = new Thread(myT);
        myThread.setName("QueueThread");
        myThread.start();
    /*Thread qThread = new Thread(QueueThread);
    qThread.setName("QueueThread");
    qThread.start();
*/



        boolean menuOut = false;
        while (!menuOut) {
            System.out.print("Menu:\n1. Add\n2. Delete\n3. System\n0. Quit\n");
            menuchoice = String.valueOf(input.next());
            switch (menuchoice) {
                case "1":
                    if (!(myCircle.isFull())) {
                        System.out.print("Input the new road's name: ");
                        String roadName = input.next();
                        myCircle.enqueue(roadName);
                        roads++;
                        System.out.print("Road added");
                        input.nextLine();
                        input.nextLine();
                    } else {
                        System.out.println("The queue is full. No more roads can be added.");
                        input.nextLine();
                    }
                    break;
                case "2":
                    if (!(myCircle.isEmpty())) {
                        String delRoad = myCircle.dequeue();
                        roads--;
                        System.out.print("Road named " + delRoad + " was deleted");
                        input.nextLine();
                        input.nextLine();
                    } else {
                        System.out.println("Queue is empty. No more roads can be deleted.");
                        input.nextLine();
                    }
                    break;
                case "3":
                    myT.setSys(true);
                    input.nextLine();
                    input.nextLine();
                    myT.setSys(false);
                    break;
                case "0":
                    menuOut = true;
                    System.out.print("Bye!");
                    break;
                default:
                    System.out.print("Incorrect Option");
                    input.nextLine();
                    input.nextLine();

            }
        }
        input.close();
        myThread.interrupt();
        System.exit(0);

    }
}