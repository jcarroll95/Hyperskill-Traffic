This source accomplishes parts 1-6 of HyperSkill's "Traffic Light Simulator with Java".

Main.java: The initialization and input, menu loop, basic i/o handling. Instantiates a new thread for the system state. 

tClass.java: System State thread via runnable. Counts seconds since program start via .sleep(1000). A silly cascade of nested if's to assist with color coding the currently open road when being printed out. The queue is passed here to facilitate the system state output.

CircularQueue.java: The project demands road storage inside of a circular queue whose size is fixed at initialization, with the ability to enqueue and dequeue. It doesn't really explain this ahead of time, but the only data associated with each road is its name, and the priority is inferred from the queue FIFO structure. Implemented as an object array-backed structure, some getters/setters, and a method to loop through the contents and print them to screen.
