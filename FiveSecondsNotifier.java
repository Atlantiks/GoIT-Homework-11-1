package homework11;

public class FiveSecondsNotifier implements Runnable{
    Thread t;
    private volatile int secondsPassed = 0;

    FiveSecondsNotifier() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        int secondsRequired = 5;
        while(true) {
            if (secondsPassed >= secondsRequired) {
                System.out.println("Прошло " + secondsRequired + " секунд, сгенерировано потоком: " + t);
                secondsPassed = 0;
            } else {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    synchronized void incSecondsPassed () {
        secondsPassed++;
        notify();
    }
}
