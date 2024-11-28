public class MyRunnable implements Runnable{
    @Override
    public void run() {
        //IntStream.rangeClosed(1,20).forEach(i -> System.out.println(i + " | Wykonywany wątek (runnable): " + Thread.currentThread().getName()));
        System.out.println("Wykonywany wątek (runnable): " + Thread.currentThread().getName());
    }
}
