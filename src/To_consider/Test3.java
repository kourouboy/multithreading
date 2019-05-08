package To_consider;


//假设有A，B,C三个账户余额都是200元，我们用两个线程分别执行两个转账操作：
// A 转给 B 100元，（线程1）
// B 转给 C 100元，（线程2）
//最后我们期望的结果应该时A的余额是100元
// B 的余额为200元
// C 的余额为300元

class Account2{
    private int balance;
    //转账
    void transfers(Account2 target ,int money){
        //锁定转出账户
        synchronized (this){
            //锁定转入账户
            synchronized (target){
                if(this.balance > money){
                    this.balance -= money;
                    target.balance += money;
                }
            }
        }
    }
}
//实例1
class Sync{
    public static synchronized void test(){
        System.out.println("tese方法开始，当前线程为： " +Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("tese方法结束，当前线程为： " +Thread.currentThread().getName());
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}
public class Test3 {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            thread.start();
        }
    }
}
