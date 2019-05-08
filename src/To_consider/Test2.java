package To_consider;

//进一步思考：保护有关联关系的多个资源

class Account1{
    private int balance1;
    //转账
    synchronized void transfer(Account1 target,int sun){
        if(this.balance1 > sun){
            this.balance1 -= sun;
            target.balance1 += sun;
        }
    }
}
public class Test2 {

    public static void main(String[] args) {

    }
}
