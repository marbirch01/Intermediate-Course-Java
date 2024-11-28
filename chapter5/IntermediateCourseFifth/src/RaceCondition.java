import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i<100; i++){
            executor.submit(() -> counter.increase());
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(counter.getCount());
    }

}

class Counter {
//    int count = 0;
//     synchronized public void increase(){  /* First example */
//         count++;
//     }

//    public void increase(){  /* Second example */
//        System.out.println("something");
//        System.out.println("something2");
//        synchronized (this){
//            count++;
//        }
//        System.out.println("something3");
//    }

    private AtomicInteger count = new AtomicInteger(0); /* Third example */
    public void increase(){  /* First example */
        count.getAndIncrement();
    }
     public int getCount(){
         return count.get();
     }
}
