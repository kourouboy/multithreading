package TestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyThread7 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("主线程睡眠前的时间");
            TestJoin.printTime();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("睡眠时间结束");
            TestJoin.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {

        MyThread7 myThread7 = new MyThread7();
        Thread thread = new Thread(myThread7,"子线程");
        thread.start();
        System.out.println(Thread.currentThread().getName());
        thread.join();
        System.out.println("代码结束");
    }
    public static void printTime(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd  HH:mm:ss");
        String time = dateFormat.format(date);
        System.out.println(time);
    }
}
