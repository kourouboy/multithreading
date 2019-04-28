package Producers_consumers;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Goods goods = new Goods();
        //储存生产、消费者线程
        List<Thread> threadList = new ArrayList<>();
        //10生产者线程
        for (int i = 0; i < 10; i++) {
            Thread producerThread = new Thread(new Producer(goods));
            producerThread.setName("生产者线程" + i);
            threadList.add(producerThread);

        }
        //6个消费者线程
        for (int i = 0; i <6 ; i++) {
            Thread consumerThread = new Thread(new Consumer(goods));
            consumerThread.setName("消费者线程" + i);
            threadList.add(consumerThread);
        }
        //启动所有线程
        for(Thread thread : threadList){
            thread.start();
        }
    }
}