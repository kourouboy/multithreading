package Producers_consumers;

class Goods{
    //商品名称
    private String goodsName;
    //商品库存
    private  int count;
    //生产方法
    public synchronized void set(String goodsName){
        this.goodsName = goodsName;
        this.count = count + 1;
        System.out.println(toString());
    }
    //消费方法
    public synchronized void get(){
        //每次消费一个商品
        this.count = this.count - 1;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}
