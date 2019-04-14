package TestMethod;


import java.security.PublicKey;

class MyThread9 implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {

        int i = 1;
        while(flag){
            try {

                /**
                 * 这里阻塞之后，线程被调用了interrupte（）方法；
                 *清除中断标志，就会抛出一个异常
                 * java.lang.ImterruptedException
                 */
                Thread.sleep(2000);
                boolean bool = Thread.currentThread().isInterrupted();
                if(bool){
                    System.out.println("非阻塞情况下执行该操作。。。线程状态" + bool);
                    break;
                }
                System.out.println("第"+ i + "次执行,线程名称为：" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                System.out.println("退出了");
                /**
                 * 这里退出阻塞状态，且中断标志会被系统自动清除
                 * 并且重新设置为false，所以此处bool为false
                 */
                boolean bool = Thread.currentThread().isInterrupted();
                System.out.println(bool);
                //退出run方法，中断进程
                return;
            }
        }


    }
}
public class TestInterrupt {
    public static void main(String[] args) {

    }
}
