package Models.Board;

public class Die {

    public final int MAX = 6; // terning har 6 sider
    private int facevalue;


    public Die() {
        this.facevalue = 1;
    }
    public  int roll() {
        facevalue = (int)(Math.random()*MAX) + 1;
        return facevalue;
    }
    public int getFaceValue () {
        return facevalue;
    }

    public String toString () {

        return Integer.toString(facevalue);
    }
}
