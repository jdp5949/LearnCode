package threading;

class Printer {
    int count = 1;
    int max = 10;
    private static Object lock = new Object();
    private int threadIdToPrint = 1;

    public Printer(int max) {
        this.max = max;
    }

    public void printNumber(int threadId) throws InterruptedException {
        synchronized (lock) {
            while (count <= max) {
                while (threadId != threadIdToPrint) {
                    lock.wait();
                }

                System.out.println("Thread-" + threadId + ": " + count);
                count++;

                threadIdToPrint = (threadIdToPrint % 3) + 1;
                lock.notifyAll();
            }
        }
    }
}

public class PrintNumberUsingThreads {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer(10);

        Thread t1 = new Thread(() -> {
            try {
                printer.printNumber(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printer.printNumber(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                printer.printNumber(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
