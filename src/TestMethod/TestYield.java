package TestMethod;

class MyThread6 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread.yield();
            System.out.println("当前线程" + Thread.currentThread().getName() + i);
        }
    }
}
public class TestYield {
    public static void main(String[] args) {
        MyThread6 myThread6 = new MyThread6();
        new Thread(myThread6).start();
        new Thread(myThread6).start();
        new Thread(myThread6).start();
    }
}
