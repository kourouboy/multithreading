package Producers_consumers;

/**
 * 生产者类
 */
class Producer implements Runnable{

    private Goods goods;

    public Producer(Goods goods) {
        super();
        this.goods = goods;
    }

    @Override
    public void run() {

        while (true) {
            try {
                this.goods.set("拿铁一杯");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * 消费者类
 */
class Consumer implements Runnable {

    private Goods goods;

    public Consumer(Goods goods) {
        super();
        this.goods = goods;
    }

    @Override
    public void run() {

        while (true) {
            try {
                this.goods.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
