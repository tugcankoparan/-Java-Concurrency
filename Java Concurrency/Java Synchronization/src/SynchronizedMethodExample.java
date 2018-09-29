import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
	System.out.println(Thread.currentThread().getName());
        count = count + 1;
    }
    public int getCount() {
        return count;
    }
}
public class SynchronizedMethodExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        for(int i = 0; i <10; i++) {
            executorService.submit(() -> synchronizedCounter.increment());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final count is : " + synchronizedCounter.getCount());
    }
}
