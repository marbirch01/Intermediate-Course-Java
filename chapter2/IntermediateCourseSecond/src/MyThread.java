import java.util.stream.IntStream;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        //IntStream.rangeClosed(1,20).forEach( i -> System.out.println(i + " | Wykonywany wątek: " + Thread.currentThread().getName()));
        System.out.println("Wykonywany wątek: " + Thread.currentThread().getName());
    }
}
