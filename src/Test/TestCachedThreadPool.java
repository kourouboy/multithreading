package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
    }
}
public class TestCachedThreadPool {
    public static void main(String[] args) throws InterruptedException {

        MyThread2 myThread2  = new MyThread2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread.sleep(1000);
        for (int i = 0; i < 6; i++) {
            executorService.submit(myThread2);
        }
        executorService.shutdown();
    }
}
