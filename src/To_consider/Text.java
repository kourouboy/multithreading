package To_consider;

//思考:如何保护没有关联关系的多个资源?不同资源使用不同的锁即可


import java.util.Timer;

class  Account{
    //账户余额
    private Integer balance;
    //账户密码
    private String password;
    //余额锁，保护balance
    private final Object balanceLock = new Object();
    //密码锁
    private final Object pwdLock = new Object();

    //取款

    void withdraw (Integer amt){ //取款金额
        synchronized (balanceLock){
            if(this.balance > amt){
                this.balance -= amt;
            }
        }
    }
    //查看余额
    Integer getBalance(){
        synchronized (balanceLock){
            return balance;
        }
    }
    //更改密码
    void updatePassword(String newpwd){
        synchronized (pwdLock){
            this.password = newpwd;
        }
    }
    //查看密码
    String getPassword(){
        synchronized (pwdLock){
            return password;
        }
    }
}



public class Text {
    public static void main(String[] args) {

    }
}
