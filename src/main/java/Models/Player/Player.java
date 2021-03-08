package Models.Player;

public class Player {


    private String Name;
    private int Position;
    private final int MaxPlayers = 4;
    private final int MinPlayers = 2;
   // private Piece piece;
    private final Account account;


    public Player(String name, int position, int startBalance) {
        this.Name = name;
        this.Position = position;
        this.account = new Account(startBalance);


    }
    public void setName(String name){
        this.Name = name;

    }
    public String getName(){
        return Name;

    }

    public int getPosition(){
        return Position;

    }
    //sætter position til hvor meget spiller skal rykke.
    //max 24 felter


    public void movePlayer (int moveAmmount){
        setPosition((getPosition() + moveAmmount)%24);
    }

    public void setPosition(int newPosition){
        this.Position = newPosition;
    }

    public Account getAccount(){
        return account;
    }
}

