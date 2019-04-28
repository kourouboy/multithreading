package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "、"+i);
        }
    }
}
public class TestSingleThreadExecutor {
    public static void main(String[] args) {
       MyThread1 myThread1 = new MyThread1();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i <6 ; i++) {
            executorService.submit(myThread1);
        }
        executorService.shutdown();
    }
}
