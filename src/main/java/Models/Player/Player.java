package Models.Player;

public class Player {


    private String name;
    private int position;
    private final int MaxPlayers = 4;
    private final int MinPlayers = 2;
   // private Piece piece;
    private Account account;


    public Player(String name, int position, int startBalance) {
        this.name = name;
        this.position = position;
        this.account = new Account(startBalance);

    }
    public void setName(String name){
        this.name = name;

    }
    public String getName(){
        return name;

    }

    public int getPosition(){
        return position;

    }
    //sætter position til hvor meget spiller skal rykke.
    //max 24 felter


    public void movePlayer (int moveAmmount){
        setPosition((getPosition() + moveAmmount)%24);
    }

    public void setPosition(int newPosition){
        this.position = newPosition;
    }

    public Account getAccount(){
        return account;
    }
}

