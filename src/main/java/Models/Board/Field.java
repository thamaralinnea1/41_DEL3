package Models.Board;

import Models.Player.Player;

public class Field {


    protected int fieldId;
    private final String title;
    private final int price,payRent;
    Player propertyOwner;
    private final String colour;



    public Field(int fieldId, String title, int price, int payRent, String colour) {
        this.fieldId = fieldId;
        this.title = title;
        this.price = price;
        this.payRent = payRent;
        this.propertyOwner = null;
        this.colour = colour;
    }






    public int getPrice() {
        return price;
    }




    public Player getPropertyOwner() {
        return this.propertyOwner;
    }

    public void setPropertyOwner(Player propertyOwner) {
        this.propertyOwner = propertyOwner;
    }



//    public String toString() {
//   return "Field{"+ fieldId + "\n" + colour + "\n" + title + "\n" + price + "\n" + payRent + "\n" + propertyOwner;
//    }



    // den bare for at ved at toString metod kommer fra en klass som er oprettet i java klasser
   @Override
    public String toString() {
        return
                " title = " + title + '\'' +
                ",\n price = " + price +
                ", payRent = " + payRent +
                ",\n propertyOwner = " + propertyOwner +
                ",\n colour = " + colour;
    }
}
