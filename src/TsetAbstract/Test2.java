package TsetAbstract;

abstract class A{
    public abstract void fun();
    public abstract void print();
}
class A1 extends A{ //A1把A中的两个抽象方法都重写了
                    //A1类不再时抽象类
    @Override
    public void fun() {
        System.out.println("fun()方法");
    }

    @Override
    public void print() {

    }
}
abstract class A2 extends A{//含有抽象方法的类一定是抽象类
    @Override
    public void fun() {

    }
}
public class Test2 {
    public static void main(String[] args) {
        A a = new A1();//实例化子类，向上转型
        a.fun();//被子类覆写的方法

    }
}
