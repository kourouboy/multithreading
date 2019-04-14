package TestThread;


class MyThread extends Thread{
    private String title;

    public MyThread( String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.title + "、" + i);
        }
    }
}
public class TestThread1 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("A");
        MyThread thread2 = new MyThread("B");
        MyThread thread3 = new MyThread("C");
        //直接调用run就相当于调了一个普通方法
//        thread1.run();
//        thread2.run();
//        thread3.run();
        //Thread提供的start()；
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
