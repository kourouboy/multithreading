package TestThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread4 implements Callable<String>{
        private int ticket = 10;
    @Override
    public String call() throws Exception {
        for (int i = 0; i <10 ; i++) {
            System.out.println("还剩下 + ticket--" + "张票");
        }
        return "票卖完了，客官明天见";
    }
}
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyThread4();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
