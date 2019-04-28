package Producers_consumers;


public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();
        Thread producerThread = new Thread(new Producer(goods),"生产者线程");
        Thread consumersThread = new Thread(new Consumer(goods),"消费者线程");
        //启动消费者
        consumersThread.start();
        //生产者启动
        producerThread.start();
    }
}
