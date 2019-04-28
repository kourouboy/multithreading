package Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread3 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "、"+i);
        }
    }
}
public class TestScheduledThreadPool {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i <6 ; i++) {
            executorService.submit(myThread3);
        }
        executorService.shutdown();
    }
}
