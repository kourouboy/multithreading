package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
    }
}
public class TestFixedThreadPool {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 6; i++) {
            executorService.submit(myThread);
        }
        executorService.shutdown();
    }
}
