package TsetAbstract;

/**
 * 适配器设计模式
 * 抽象类中可以定义非抽象方法，不让该类创建对象，
 * 方法可以直接被调用
 */

abstract class Animal{
    public void eat(){
        System.out.println("吃东西");
    }
}
class Cat extends  Animal{

}

public class Test3 {
    public static void main(String[] args) {

        new Cat().eat();
    }
}
