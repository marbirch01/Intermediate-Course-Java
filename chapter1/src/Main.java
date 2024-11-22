public class Main {
    public static void main(String[] args) {
        System.out.println("Główny wątek aplikaji: " + Thread.currentThread().getName());

        Thread thread = new MyThread("My-Thread-1");
        //Thread secondThread = new MyThread("My-Thread-2");

        thread.start();
        //secondThread.start();

        //Runnable runnable = new MyRunnable();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Wykonywany wątek (runnable): " + Thread.currentThread().getName());
            }
        };

        Thread anotherThread = new Thread(runnable, "My-Runnable-1");

        anotherThread.start();
    }
}