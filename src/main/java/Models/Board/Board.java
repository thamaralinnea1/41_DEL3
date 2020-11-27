package Models.Board;

public class Board {
    public Field[] fields = new Field[24];

    {
        fields[0] = new Field(1, " Velkommen til start. Modtag M 2, Når du passerer start", 2, 0, null);
        fields[1] = new Field(2, " Burgerbaren ", 1, 1, " Brun ");
        fields[2] = new Field(3, " Pizzeriaet ", 1, 1, " Brun ");
        fields[3] = new Field(4, " Chance ", 0, 0, null);
        fields[4] = new Field(5, " Slikbuttikken ", 1, 1,  "LyseBlå");
        fields[5] = new Field(6, " Iskiosken ", 1, 1,  " Lyseblå ");
        fields[6] = new Field(7, " På besøg i fængsel ", 0, 0,  null);
        fields[7] = new Field(8, " Museet ", 2, 2, " Violet ");
        fields[8] = new Field(9, " Biblioteket ", 2, 2,  " Violet ");
        fields[9] = new Field(10, " Chance ", 0, 0,  null);
        fields[10] = new Field(11, " Skaterparken ", 2, 2,  " Orange ");
        fields[11] = new Field(12, " Swimmingpoolen ", 2, 2,  " Orange ");
        fields[12] = new Field(13, " Gratis Parkering ", 0, 0,  null);
        fields[13] = new Field(14, " Spillehallen ", 3, 3,  " Rød ");
        fields[14] = new Field(15, " Biografen ", 3, 3,  " Rød ");
        fields[15] = new Field(16, " Chance ", 0, 0,  null);
        fields[16] = new Field(17, " Legetøjsbutikken ", 3, 3,  " Gul ");
        fields[17] = new Field(18, " Dyrehandlen ", 3, 3,  " Gul ");
        fields[18] = new Field(19, " Gå I Fængsel ", 0, 0,  null);
        fields[19] = new Field(20, " Bowlinghallen ", 4, 4, " Grøn ");
        fields[20] = new Field(21, " Zoo ", 4, 4, " Grøn ");
        fields[21] = new Field(22, " Chance ", 0, 0,  null);
        fields[22] = new Field(23, " Vandlandet ", 5, 5,  " Blå ");
        fields[23] = new Field(24, " Strandpromenaden ", 5, 5, " Blå ");



    }

    public Field getField(int index) {
        return fields[index];
    }
}
