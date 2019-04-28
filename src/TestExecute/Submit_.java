package TestExecute;

import java.util.concurrent.*;

class  CallableThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        for (int i = 0; i <50 ; i++) {
            System.out.println(Thread.currentThread().getName() + "、" + i);
        }
        return Thread.currentThread().getName() + "任务执行完毕";
    }
}
public class Submit_ {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableThread callableThread = new CallableThread();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,5,2000,TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
        for (int j = 0; j <5 ; j++) {

            Future<String> future = threadPoolExecutor.submit(callableThread);
            //当调用Future接口的get方法会阻塞其他线程，直到取得当前线程执行完毕后的返回值。
            String string = future.get();
            System.out.println(string);


            //获取当前设备的CPU个数
            System.out.println(Runtime.getRuntime().availableProcessors());
        }
        //关闭线程池
          threadPoolExecutor.shutdown();
    }
}
