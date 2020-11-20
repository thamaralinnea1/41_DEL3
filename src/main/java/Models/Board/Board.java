package Models.Board;

public class Board {
    public Field[] field = new Field[24];

    {
        field[0] = new Field(1, " Velkommen til start. Modtag M 2, Når du passerer start", 2, 0, null);
        field[1] = new Field(2, " Burgerbaren ", 1, 1, " Brun ");
        field[2] = new Field(3, " Pizzeriaet ", 1, 1, " Brun ");
        field[3] = new Field(4, " Chance ", 0, 0, null);
        field[4] = new Field(5, " Slikbuttikken ", 1, 1,  "LyseBlå");
        field[5] = new Field(6, " Iskiosken ", 1, 1,  " Lyseblå ");
        field[6] = new Field(7, " På besøg i fængsel ", 0, 0,  null);
        field[7] = new Field(8, " Museet ", 2, 2, " Violet ");
        field[8] = new Field(9, " Biblioteket ", 2, 2,  " Violet ");
        field[9] = new Field(10, " Chance ", 0, 0,  null);
        field[10] = new Field(11, " Skaterparken ", 2, 2,  " Orange ");
        field[11] = new Field(12, " Swimmingpoolen ", 2, 2,  " Orange ");
        field[12] = new Field(13, " Gratis Parkering ", 0, 0,  null);
        field[13] = new Field(14, " Spillehallen ", 3, 3,  " Rød ");
        field[14] = new Field(15, " Biografen ", 3, 3,  " Rød ");
        field[15] = new Field(16, " Chance ", 0, 0,  null);
        field[16] = new Field(17, " Legetøjsbutikken ", 3, 3,  " Gul ");
        field[17] = new Field(18, " Dyrehandlen ", 3, 3,  " Gul ");
        field[18] = new Field(19, " Gå I Fængsel ", 0, 0,  null);
        field[19] = new Field(20, " Bowlinghallen ", 4, 4, " Grøn ");
        field[20] = new Field(21, " Zoo ", 4, 4, " Grøn ");
        field[21] = new Field(22, " Chance ", 0, 0,  null);
        field[22] = new Field(23, " Vandlandet ", 5, 5,  " Blå ");
        field[23] = new Field(24, " Strandpromenaden ", 5, 5, " Blå ");



    }


}
