package Review5_12;


class Mythread extends Thread{//线程主体类
    private String title;
    public Mythread(String title){
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(this.title + ", i = " + i);
        }
    }
}
public class Test_Thread {
    public static void main(String[] args) {
        Mythread mythread = new Mythread("thread1");
        Mythread mythread1 = new Mythread("thread2");
        Mythread mythread2 = new Mythread("thread3");
        Mythread mythread3 = new Mythread("thread4");
        //直接调用run()方法，这个时候只是做了一个顺序打印，和多线程一点关系都没有

//       mythread.run();
//       mythread1.run();
//       mythread2.run();
        //正确启用多线程的方式是调用Thread类中的start()方法
        mythread.start();
        mythread1.start();
        mythread2.start();
        mythread3.start();
    }
}
