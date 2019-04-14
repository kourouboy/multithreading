package TestThread;

class MyThread1 implements Runnable {
        private String title;

    public MyThread1(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            System.out.println(this.title + "、" + i);
        }
    }
}
public class TestRunnable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("A");
        MyThread myThread1 = new MyThread("B");
        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread1);
        thread.start();
        thread1.start();
    }
}
