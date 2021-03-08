package Models.Player;

public class Account {

    private int Balance;


    //set balance to startbalance
    public Account (int startBalance){
    this.Balance = startBalance;
    }



    public void addPoint(int fieldValue) {
        Balance +=  fieldValue;
    }

    public void setBalance(int balance) {
        this.Balance = balance;
    }

    public int getBalance (){

        return Balance;
    }
}
