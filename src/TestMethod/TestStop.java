package TestMethod;


class MyThread8 implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {
        int i = 1;
        while(flag){
            try {
                Thread.sleep(1000);
                System.out.println("第"+ i + "次执行,线程名称为：" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
}

public class TestStop {
    public static void main(String[] args) throws InterruptedException {
        MyThread8 myThread8 = new MyThread8();
        Thread thread = new Thread(myThread8,"子线程");
        thread.start();
        Thread.sleep(2000);
        myThread8.setFlag(false);
//        thread.stop();    //此方法不安全，已被废弃
        System.out.println("代码结束");
    }
}
