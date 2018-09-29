import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

 
public class InvokeAnyExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(1000);
            return "Result of Task3";
        };

        String result = executorService.invokeAny(Arrays.asList(task1, task2, task3));

        System.out.println(result);

	executorService.shutdown();
    }
}
