package Producers_consumers;

class Goods {
    //商品名称
    private String goodsName;
    //商品库存
    private  int count;
    //生产方法
    public synchronized void set(String goodsName) throws InterruptedException {
        //此时还有商品没被消费，等待消费者消费
        while (this.count > 0){
//            System.out.println("还有库存哦，等待顾客...");
            wait();
        }
        this.goodsName = goodsName;
        this.count = count + 1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("生产"+toString());
        System.out.println("------------------------------");
        //生产完商品后通知消费者线程可以消费
        notifyAll();
    }
    //消费方法
    public synchronized void get() throws InterruptedException {
        //此时还没有商品，等待生产者生产商品
        while (this.count == 0){
//            System.out.println("商品卖完了，请您等一等");
            wait();
        }
        //每次消费一个商品
        this.count = this.count - 1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("消费" + toString());
        System.out.println("----------------------------");
        //消费完告诉生产者线程可以继续生产了
        notify();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}
