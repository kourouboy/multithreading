package TsetAbstract;

/**
 * 需求描述:
 *
 * 某IT公司有多名员工，按照员工负责的工作不同，进行了部门的划分（研发部员工、维护部员工）。
 * 研发部根据所需研发的内容不同，又分为JavaEE工程师、Android工程师；
 * 维护部根据所需维护的内容不同，又分为网络维护工程师、硬件维护工程师。
 * 公司的每名员工都有他们自己的员工编号、姓名，并要做它们所负责的工作。
 * 工作内容:
 *
 * JavaEE工程师：员工号为xxx的 xxx员工，正在研发淘宝网站
 * Android工程师：员工号为xxx的 xxx员工，正在研发淘宝手机客户端软件
 * 网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
 * 硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机
 */
abstract class Employee{
    private Integer id;//员工编号
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract void Work();
}
abstract class Develop extends Employee{

}
class javaEE extends Develop{

    @Override
    public void Work() {
        System.out.println("名字为：" + getName() + "工号为：" + getId()
        + "的javaEE工程师正在开发淘宝");
    }
}
class Android extends Develop{

    @Override
    public void Work() {
        System.out.println("名字为："+getName() + "工号为：" +getId()
                + "Android正在研发安卓客户端");
    }
}

abstract class Maintenance extends Employee{

}
class Network extends Maintenance{

    @Override
    public void Work() {
        System.out.println("名字为："+getName() + "工号为：" +getId()
        + "的网络工程师正在检查网络是否流畅");
    }
}
class  HardWare extends Maintenance{

    @Override
    public void Work() {
        System.out.println("名字为："+getName() +"工号为：" + getId()
        + "的维护工程师正在修复网络");
    }
}
public class Test5 {
    public static void main(String[] args) {


       javaEE javaee = new javaEE();
       javaee.setId(123  );
       javaee.setName("张三  ");
       javaee.Work();
       Android android = new Android();
       android.setName("李四  ");
       android.setId(223  );
       android.Work();
       Network network = new Network();
       network.setName("王五  ");
       network.setId(333  );
       network.Work();
       HardWare hardWare = new HardWare();
       hardWare.setName("猪猪  ");
       hardWare.setId(423  );
       hardWare.Work();
    }
}
