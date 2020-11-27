package Models.Player;

public class Account {

    private int balance;


    //set balance to startbalance
    public Account (int startBalance){
        this.balance = startBalance;

    }

    public void setAccount(int account){
        this.balance =balance;
    }

    public void addPoint(int fieldValue) {
        balance +=  fieldValue;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance (){

        return balance;
    }
}
