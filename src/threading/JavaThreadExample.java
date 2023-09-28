package threading;


class Printer1 {
    Boolean isoddTurn = true;
    int count = 1;
    int max = 20;
    private static Object lock = new Object();
    public Printer1(int max) {
        this.max = max;
    }

    public void printEven() throws InterruptedException {
        synchronized (lock) {
            while (count < max) {
                while (isoddTurn) {
                    lock.wait();
                }
                System.out.println("even - "+count);
                count++;
                isoddTurn = true;
                lock.notify();
            }

        }
    }

    public void printOdd() throws InterruptedException {
        synchronized (lock) {
            while (count < max) {
                while (!isoddTurn) {
                    lock.wait();
                }
                System.out.println("odd - "+count);
                count++;
                isoddTurn = false;
                lock.notify();
            }

        }
    }

}


public class JavaThreadExample {

    public static void main(String[] args) throws InterruptedException {

        Printer1 printer = new Printer1(20);
        Thread eT = new Thread(()->{
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread oT = new Thread(()->{
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        eT.start();
        oT.start();
        System.out.println("babab");
    }
}