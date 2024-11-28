import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService executorService = Executors.newFixedThreadPool(2); /*Lesson Callable and Future*/
//
//        Callable<Integer> answerToEverything = () -> {
//            TimeUnit.SECONDS.sleep(10);
//            return 42;
//        };
//
//        Future<Integer> result = executorService.submit(answerToEverything);
//
//        Integer x = result.get();
//
//        System.out.println(x);
//
//        executorService.shutdown();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2); /*Lesson Future*/
//
//        Callable<Integer> answerToEverything = () -> {
//            TimeUnit.SECONDS.sleep(10);
//            return 42;
//        };
//
//        Future<Integer> result = executorService.submit(answerToEverything);
//
//       while(!result.isDone()){
//            System.out.println("Brak wyniku");
//            TimeUnit.SECONDS.sleep(2);
//        }
//
//        Integer x = null;
//        try {
//            x = result.get(4, TimeUnit.SECONDS);
//            System.out.println(x);
//        } catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        }
//
//        executorService.shutdown();


//        ExecutorService executorService = Executors.newFixedThreadPool(5); /*Lesson invokeAll(), invokeAny()*/
//
//        Callable<Integer> answerToEverything = () -> {
//            TimeUnit.SECONDS.sleep(10);
//            return 42;
//        };
//        Callable<Integer> anotherAnswerToEverything = () -> {
//            TimeUnit.SECONDS.sleep(13);
//            return 43;
//        };
//        Callable<Integer> finalAnswerToEverything = () -> {
//            TimeUnit.SECONDS.sleep(5);
//            return 44;
//        };
//
//        List<Callable<Integer>> callableList = Arrays.asList(answerToEverything, anotherAnswerToEverything, finalAnswerToEverything);
//
//        List<Future<Integer>> futures = executorService.invokeAll(callableList);
//
//        Integer x = executorService.invokeAny(callableList);
//        System.out.println(x);
//
//        for (Future<Integer> f : futures){
//            System.out.println(f.get());
//        }
//
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newFixedThreadPool(5); /*Lesson Completable Future*/
//
//        CompletableFuture.runAsync(
//                () -> System.out.println("Wątek: " + Thread.currentThread().getName()), executorService
//        );
//
//        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return 42;
//        },executorService);
//
//        System.out.println(result.get());
//
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newFixedThreadPool(5); /*Lesson Completable Future - nieblokujące wywołanie*/
//
//        CompletableFuture.runAsync(
//                () -> System.out.println("Wątek: " + Thread.currentThread().getName()), executorService
//        );
//
//        CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return 42;
//        },executorService).thenApply(r -> {
//            System.out.println("*2 " + Thread.currentThread().getName());
//            return r*2;
//        }).thenApply( r -> {
//            System.out.println("+1 " + Thread.currentThread().getName());
//            return r+1;
//        }).thenAccept( r -> {
//            System.out.println("sout " + Thread.currentThread().getName());
//            System.out.println(r);
//        });
//
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newFixedThreadPool(5); /*Lesson Completable Future - łączenie wywołań*/

//        CompletableFuture<Long> userIdFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return getUserId();
//        });

//        CompletableFuture<Void> future = userIdFuture.thenCompose(userId -> CompletableFuture.supplyAsync(() -> getUserDiscount(userId))).thenAccept(
//                discount -> System.out.println(discount)
//        );

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        CompletableFuture<Long> cfuture1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return 32L;
//        });
//
//        CompletableFuture<Long> cfuture2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return 2L;
//        });
//
//        CompletableFuture<Long> longCompletableFuture = cfuture1.thenCombine(cfuture2, (result1, result2) -> result1 * result2);
//        Long aLong = longCompletableFuture.get();
//
//        System.out.println(aLong);
//
//        executorService.shutdown();

        ExecutorService executorService = Executors.newFixedThreadPool(5); /*Lesson Completable Future - obsługa błędów*/

        final boolean err = true;

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()), executorService
        );

        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (err){
                throw new IllegalArgumentException("Wrong argument");
            }
            return 42;
        },executorService).exceptionally(exception -> {
            System.out.println("Error!!" + exception.getMessage());
            return 2;
        }).thenApply(r -> {
            System.out.println("*2 " + Thread.currentThread().getName());
            return r*2;
        }).thenApply( r -> {
            System.out.println("+1 " + Thread.currentThread().getName());
            return r+1;
        }).thenAccept( r -> {
            System.out.println("sout " + Thread.currentThread().getName());
            System.out.println(r);
        });

        executorService.shutdown();

    }
//    public static Long getUserId(){
//        return 324L;
//    }
//    public static Double getUserDiscount (Long userId){
//        return 0.15;
//    }
}