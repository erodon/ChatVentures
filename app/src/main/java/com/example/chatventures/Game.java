package com.example.chatventures;

import android.content.Intent;

public class Game {
    private String[][] kerdesek; // [id][kerdes, valasz1, valasz2, jmpvalasz1, jmpvalasz2]
    private boolean user;
    MessageAdapter messageAdapter;
    private String item;
    private String power;
    private String toughness;
    private String dmg;
    private int i;



    public Game(MessageAdapter messageAdapter) {
        this.item = "Még nincs semmi fegyvered.";
        kerdesek = new String[9][5];
        setKerdesek();
        this.i = 0;
        this.user = false;
        this.messageAdapter = messageAdapter;
    }

    public void kerdestFeltesz() {
        messageAdapter.add(new Message(kerdesek[i][0], user));
    }

    public void valaszEllenorzes(String valasz) {

        if (valasz.equals(kerdesek[i][1])) {
            i = Integer.parseInt(kerdesek[i][3]);
        } else if (valasz.equals(kerdesek[i][2])) {
            i = Integer.parseInt(kerdesek[i][4]);
        } else if (valasz.equals("Item")){
            messageAdapter.add(new Message(item, user));
        }else {
            messageAdapter.add(new Message("Nincs ilyen lehetőség.", user));
        }
        if(i == 99){
            item = "Kard";
            i = 2;
        } else if(i == 98){
            item = "Pajzs";
            i = 2;
        }
        kerdestFeltesz();
    }

    public void setKerdesek() {
        this.kerdesek[0][0] = "A feladatod megkeresni egy varázsgyűrűt a labirintusban, majd kijutni vele élve. Készen állsz? (Igen)";
        this.kerdesek[0][1] = "Igen";
        this.kerdesek[0][2] = null;
        this.kerdesek[0][3] = "1";
        this.kerdesek[0][4] = "1";

        this.kerdesek[1][0] = "Mielőtt bemennél a labirintusba, választhatsz magadnak egy fegyvert: (Kard/Pajzs)";
        this.kerdesek[1][1] = "Kard";
        this.kerdesek[1][2] = "Pajzs";
        this.kerdesek[1][3] = "99";
        this.kerdesek[1][4] = "98";

        this.kerdesek[2][0] = "Belépsz a labirintusba. Merre indulsz? (Jobbra/Balra)";
        this.kerdesek[2][1] = "Balra";
        this.kerdesek[2][2] = "Jobbra";
        this.kerdesek[2][3] = "3";
        this.kerdesek[2][4] = "3";

        this.kerdesek[3][0] = "Egy ideig kanyarogsz a labirintusban, amikor egy jól elrejtett ajtóra bukkansz a falban. Belépsz? (Igen/Nem)";
        this.kerdesek[3][1] = "Igen";
        this.kerdesek[3][2] = "Nem";
        this.kerdesek[3][3] = "4";
        this.kerdesek[3][4] = "6";

        this.kerdesek[4][0] = "Belépsz az ajtón és egy hosszú folyosót látsz. Ahogy haladsz előre egy óriás pókkal találkozol(2/2). Medküzdesz vele? (Igen/Nem)";
        this.kerdesek[4][1] = "Igen";
        this.kerdesek[4][2] = "Nem";
        this.kerdesek[4][3] = "5";
        this.kerdesek[4][4] = "8";

        this.kerdesek[5][0] = "Legyőzted a pókot. A földön megtalálod egy elesett lovag sisakját(+0/+1). Felveszed, majd kiérsz a titkos folyosóról. Merre indulsz? (Jobbra/Balra)";
        this.kerdesek[5][1] = "Jobbra";
        this.kerdesek[5][2] = "Balra";
        this.kerdesek[5][3] = "6";
        this.kerdesek[5][4] = "8";

        this.kerdesek[6][0] = "Megtaláltad a gyűrűt! Nyertél! (Szuper)";
        this.kerdesek[6][1] = "Szuper";
        this.kerdesek[6][2] = null;
        this.kerdesek[6][3] = "0";
        this.kerdesek[6][4] = null;

        this.kerdesek[8][0] = "Kiérsz a labirintusbúl, de még nem találtad meg a gyűrűt. Vissza kell menned, de csak ott tudsz, ahol az elején is bementél. (OK)";
        this.kerdesek[8][1] = "OK";
        this.kerdesek[8][2] = null;
        this.kerdesek[8][3] = "2";
        this.kerdesek[8][4] = null;

    }

}
