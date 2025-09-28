package traffic;

public class CircularQueue {
    private int front = 0;
    private int size = 0;
    private int capacity = 0;
    private Object[] myArray;

    public CircularQueue(int arraySize) {
        // circular queue is FIFO. this.front is a pointer to the oldest element.
        // first + size (wrapping around array length so % capacity) should be
        // the most recently added
        this.myArray = new Object[arraySize];
        this.front = 0;
        this.size = 0;              // this is how many items have been stored
        this.capacity = arraySize;  // this is how many items will fit into the array
    }

    public CircularQueue() {
        this(10);
    }

    public int getFront() {
        return this.front;
    }
    public int getSize() {
        return this.size;
    }

    public <T> T getData(int element) {
        return (T) this.myArray[element];
    }

    public <T> void enqueue(T dataIn) {
        if (this.size == this.capacity) {
            // queue is full
            System.out.println("Queue is full");
            return;
        } else {
            int next = (this.front + this.size) % this.capacity;
            this.myArray[next] = dataIn;
            this.size++;
            return;
        }
    }

    public <T> T dequeue() {
        if (this.size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        T dataOut = (T) this.myArray[this.front];
        this.myArray[this.front] = null;
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return dataOut;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.size == this.capacity) {
            return true;
        } else {
            return false;
        }
    }

    // we'll have an interval of 3s
    // we'll have 10 roads
    // every 3 sleeps we'll increment the open road
    // front + increment % capacity
    // print myArray[closed]
    // print myArray[openroad]
    public void printRoads(int openRoad) {
        for (int i = 0; i < this.size; i++) {
            if (((this.front + i) % this.capacity) == openRoad) {
                System.out.println("\u001B[32m" + this.myArray[(this.front + i) % this.capacity] + "\u001B[0m");
            } else {
                System.out.println("\u001B[31m" + this.myArray[(this.front + i) % this.capacity] + "\u001B[0m");
            }
        }
    }
}
