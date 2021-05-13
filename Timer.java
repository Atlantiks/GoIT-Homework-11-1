package homework11;

public class Timer {

    public static void main(String[] args) {

        FiveSecondsNotifier fsn = new FiveSecondsNotifier();
        while (true) {
            fsn.incSecondsPassed(); // оповещаем второй поток
            System.out.println("Прошла секунда, сгенерировано потоком " + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
