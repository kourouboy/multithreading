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

    }
}

