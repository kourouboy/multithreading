package practice;

import sun.net.NetworkServer;

class MyThread1 implements Runnable{

    private boolean flag;
    private Object obj;

    public MyThread1(boolean flag, Object obj) {
        this.flag = flag;
        this.obj = obj;
    }
    public void waitMethod1(){
        synchronized (obj){
            while(true){
                System.out.println("wait方法开始" + Thread.currentThread().getName());
                try {
                    obj.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait方法结束" + Thread.currentThread().getName());
                return;
            }
        }
    }
    public void notifyAllMethod(){
        synchronized (obj){
            System.out.println("notifyAll()方法开始" + Thread.currentThread().getName());
            obj.notifyAll();
            System.out.println("notifyAll()方法结束" + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        if(flag){
            this.waitMethod1();
        }else{
            this.notifyAllMethod();
        }
    }
}
public class TestNotifyAll {
    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();
        MyThread1 myThread1 = new MyThread1(true,object);
        MyThread1 myThread2 = new MyThread1(true,object);
        MyThread1 myThread3 = new MyThread1(true,object);
        MyThread1 notifyThread = new MyThread1(false,object);
        Thread thread = new Thread(myThread1,"wait线程A");
        Thread thread1 = new Thread(myThread2,"wait线程B");
        Thread thread2 = new Thread(myThread3,"wait线程C");
        Thread thread3 = new Thread(notifyThread,"notify线程");
        thread.start();
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
        System.out.println("main方法结束");
    }
}
