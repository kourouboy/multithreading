package TestMethod;


import java.util.Map;

class MyThread5 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程" + Thread.currentThread().getName() + i);
        }
    }
}
public class TestSleep {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        Thread thread = new Thread(myThread5);
        Thread thread1 = new Thread(myThread5);
        Thread thread2 = new Thread(myThread5);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
