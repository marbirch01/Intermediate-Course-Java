import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek aplikaji: " + Thread.currentThread().getName());

        //Thread thread = new MyThread("My-Thread-1");
        //Thread secondThread = new MyThread("My-Thread-2");a
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

//        ExecutorService executorService = Executors.newSingleThreadExecutor();  /*EXECUTOR LESSON 1*/

//        Runnable countdown = () -> {
//            try {
//                System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
//                for (int i = 0; i <= 10; i++) {
//                    System.out.println(i);
//                    TimeUnit.MILLISECONDS.sleep(200);
//                    //Thread.sleep(1000);
//                }
//            } catch(InterruptedException e){
//                throw new RuntimeException(e);
//            }
//        };
//
//        Runnable blastOff = () -> {
//            System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
//            System.out.println("Blast off!");
//        };
//        executorService.submit(countdown);
//        executorService.submit(blastOff);
//
//        executorService.shutdown();
//       executorService.shutdownNow();

//       Thread countdownThread = new Thread(countdown, "Countdowns");
//       Thread blastOffThread = new Thread(blastOff, "BlastOff");
//
//        countdownThread.start();
//
//        countdownThread.join();
//        System.out.println("Główny wątek aplikaji: " + Thread.currentThread().getName());
//        blastOffThread.start();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);  /*EXECUTOR LESSON 2*/
//
//        Runnable worker1 = () -> {
//            try {
//                System.out.println("Robotnik 1 - Aktualny wątek aplikaji: " + Thread.currentThread().getName());
//                System.out.println("Laduje butle z tlenem");
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//
//        Runnable worker2 = () -> {
//            try {
//                System.out.println("Robotnik 2 - Aktualny wątek aplikaji: " + Thread.currentThread().getName());
//                System.out.println("Laduje zapas pożywienia");
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//
//        Runnable worker3 = () -> {
//            try {
//                System.out.println("Robotnik 3 - Aktualny wątek aplikaji: " + Thread.currentThread().getName());
//                System.out.println("Laduje paliwo");
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//
//        executorService.submit(worker1);
//        executorService.submit(worker2);
//        executorService.submit(worker3);
//
//        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);  /*EXECUTOR LESSON 3*/

        Runnable worker1 = () -> {
            try {
                System.out.println("Robotnik 1 - Aktualny wątek aplikaji: " + Thread.currentThread().getName());
                System.out.println("Laduje butle z tlenem");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable worker2 = () -> {
            try {
                System.out.println("Robotnik 2 - Aktualny wątek aplikaji: " + Thread.currentThread().getName());
                System.out.println("Laduje zapas pożywienia");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable worker3 = () -> {
            try {
                System.out.println("Robotnik 3 - Aktualny wątek aplikaji: " + Thread.currentThread().getName());
                System.out.println("Laduje paliwo");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        //scheduledExecutorService.schedule(worker1, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(worker3, 2, 6, TimeUnit.SECONDS);

        //scheduledExecutorService.shutdown();

    }
}