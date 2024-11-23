import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek aplikaji: " + Thread.currentThread().getName());

        //Thread thread = new MyThread("My-Thread-1");
        //Thread secondThread = new MyThread("My-Thread-2");
        //thread.start();

        /*
        secondThread.start();
        Runnable runnable = new MyRunnable();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Wykonywany wątek (runnable): " + Thread.currentThread().getName());
                    }
                };
        */

        Runnable countdown = () -> {
            try {
                System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
                for (int i = 0; i <= 10; i++) {
                    System.out.println(i);
                    TimeUnit.MILLISECONDS.sleep(200);
                    //Thread.sleep(1000);
                }
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        };

        Runnable blastOff = () -> {
            System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
            System.out.println("Blast off!");
        };

        Thread countdownThread = new Thread(countdown, "Countdowns");
        Thread blastOffThread = new Thread(blastOff, "BlastOff");

        countdownThread.start();

        countdownThread.join();
        System.out.println("Główny wątek aplikaji: " + Thread.currentThread().getName());
        blastOffThread.start();
    }
}