package TsetAbstract;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 模板设计模式：（基于抽象类）
 * 模板模式超类
 *
 */


abstract class CaffeineBeverage{
    final void preparRecipe(){
        boilWater();
        brew();
        pourInCup();
        //如果顾客想要饮料我们才调用加料方法
        if(custumerWantCondiments()){
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater(){
        System.out.println("Boiling water");
    }
    void pourInCup(){
        System.out.println("Pouring into cup");
    }

    /**
     * 钩子方法：
     * 超类中通常是可以默认实现的
     * 子类可以选择性的覆写此方法
     * @return
     */
    boolean custumerWantCondiments(){
        return true;
    }

}

class Tea extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {

        System.out.println("Addig Lemon");
    }
}

class Coffee extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("Dripping Coffee through Classese");
    }

    @Override
    void addCondiments() {

        System.out.println("Adding Sugar and Milk");
    }
    /**
     * 子类覆写了钩子函数，实现自定义功能
     */
    public boolean custumerWantCondiments(){
        String answer = getUserInput();
        if(answer.equals("yes")){
            return true;
        }else {
            return false;
        }
    }
    private String getUserInput(){
        String answer = null;
        System.out.println("您想要加牛奶或者糖吗？（yes/no）");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}
public class Test4 {
    public static void main(String[] args) {

        CaffeineBeverage tea = new Tea();
        CaffeineBeverage coffee = new Coffee();

        System.out.println("making a cup of tea...\nyes");
        tea.preparRecipe();

        System.out.println("making a cup of coffee...");
        coffee.preparRecipe();
    }

}
