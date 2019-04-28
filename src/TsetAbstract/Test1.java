package TsetAbstract;

/**
 *抽象类的定义格式
 *public sbstract 返回值类型 方法名（参数）
 *
 * 例：public abstract class 类名{
 *
 * }
 */


/**
 * 定义类老师：
 *      数学老师 ： 工作
 *      语文老师 :  工作
 *
 *      根据共性进行抽取，然后形成一个父类：老师：Teacher
 *      定义方法，工作 ： 然后则么工作，具体干什么的
 *
 *      抽象类，不能实例化对象，（不能 new）
 *      不能new（创建对象）的原因 ：如果真的调用了，对象调用抽象方法
 *      然鹅抽象方法就没有主体，根本就不能运行
 *
 *      使用方法：定义类继承抽象类，将抽象方法进行重写，创建子类的对象
 *
 *
 */

abstract class Teacher{

    /**
     * 定义工作方法，但是怎么工作，就说不清楚，所以不说
     * 方法没有主体的方法，必须使用abstract进行修饰
     *  抽象的方法必须存在抽象的类中，类也必须用abstract修饰
     */
    public abstract void Work();
}

/**
 * 定义类，数学老师
 * 继承抽象类Teacher，重写抽象的方法
 */
class MathTeacher extends Teacher{

    @Override
    public void Work() {
        System.out.println("数学老师正在给高一同学上课");
    }
}
class ChineseTeacher extends Teacher{

    @Override
    public void Work() {
        System.out.println("语文老师正在给高三同学讲作业");
    }
}
public class Test1{
    public static void main(String[] args) {
        MathTeacher mathTeacher = new MathTeacher();
        mathTeacher.Work();

        ChineseTeacher chineseTeacher = new ChineseTeacher();
        chineseTeacher.Work();
    }
    /**
     * 总结：
     *      所有抽象类必须有子类
     *      子类必须覆写抽象类的所有方法
     *      抽象类不能直接创建实例化对象，需要通过子类向上转型为其实例化
     *
     */
}