package TestThread;

/**
 * 使用Thread 模拟卖票
 */
//class MyThread2 extends Thread {
//        private String title ;
//        private int ticket = 10;
//
//    @Override
//    public void run() {
//        for (int i = 0; i <10 ; i++) {
//            System.out.println(this.title + "还剩下"+ ticket-- + "张票" );
//        }
//    }
//
//    public MyThread2( String title) {
//        this.title = title;
//    }
//}
//public class Thread_Runnable {
//    public static void main(String[] args) {
//        Thread thread = new MyThread2("A");
//        Thread thread1 = new MyThread2("B");
//        Thread thread2 = new MyThread2("C");
//        thread.start();;
//        thread1.start();
//        thread2.start();
//    }
//}
//使用Thread 发现三个人都有十张票加起来三十张票，重合了，所以不行。Runnable更好的资源共享。

/**
 * 使用Runnable 模拟卖票
 */

class MyThread3 implements Runnable{

        private int ticket = 10;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println( "还剩下"+ ticket-- + "张票");
        }
    }
}
public class Thread_Runnable{
    public static void main(String[] args) {
        MyThread3 mt = new MyThread3();
        Thread thread  = new Thread(mt);
        Thread thread1 = new Thread(mt);
        Thread thread2= new Thread(mt);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

