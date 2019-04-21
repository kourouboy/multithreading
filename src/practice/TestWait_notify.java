package practice;


import java.security.PublicKey;

class MyThread implements Runnable{

    private boolean flag;
    private  Object obj;

    public MyThread(boolean flag, Object obj) {
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod()  {
        synchronized (obj){
            while (true){
                System.out.println("wait（）方法开始 " + Thread.currentThread().getName());
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait（）方法结束 " + Thread.currentThread().getName() );
                return;
            }
        }
    }
    public void notifyMethod(){
        synchronized (obj){
            System.out.println("notify()方法开始" + Thread.currentThread().getName());
            obj.notify();
            System.out.println("notify()方法结束" + Thread.currentThread().getName());
        }
    }
    @Override
    public void run() {
        if (flag){
            this.waitMethod();
        }else{
            this.notifyMethod();
        }
    }
}
public class TestWait_notify {
    public static void main(String[] args) throws InterruptedException {
//        Object object = new Object();
//        synchronized (object){
//            System.out.println("等待中...");
//            object.wait();
//            System.out.println("等待已过...");
//        }
//
//        System.out.println("main方法结束");
        Object object = new Object();
        MyThread waitThread = new MyThread(true,object);
        MyThread notifyThread = new MyThread(false,object);
        Thread thread = new Thread(waitThread,"wait线程");
        Thread thread1 = new Thread(notifyThread,"notify线程");
        thread.start();
        Thread.sleep(1000);
        thread1.start();
        System.out.println("main方法结束！！");
    }
}