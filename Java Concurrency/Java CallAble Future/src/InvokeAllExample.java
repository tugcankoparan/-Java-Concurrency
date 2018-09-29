import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
            return "Result of Task3";
        };

        List<Callable<String>> taskList = Arrays.asList(task1, task2, task3);

        List<Future<String>> futures = executorService.invokeAll(taskList);

        for(Future<String> future: futures) {
            System.out.println(future.get());
        }

	executorService.shutdown();
    }
}
