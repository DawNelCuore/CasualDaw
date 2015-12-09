package com.rizzi.angelo.casualbabo.characters;

import android.graphics.Bitmap;

import com.rizzi.angelo.casualbabo.R;

import java.util.Random;

import it.robertolaricchia.interfaces.CharacterInterface;

/**
 * Created by angelo on 04/12/15.
 */

public class Babo implements CharacterInterface {
    private static String[] frasi={"Buona notte degli oscar a tutti", "Ho solo bisogno di segarmi", "Perlomeno mi considera", "De gustibus"};
    private static String[] di={"do", "daw", "si", "fo"};
    private static  String[] inizia={"Oh", "Pronto?","Lo sapevo", "imadò" , "Sì?", "No!"};
    private static  String[] appellativi={"sei un coglionazzo", "sei deviato", "pensa a tua sorella","tu sei una ciola", "tu non sei normale","questo è pazzo uagnu", "te la sei fatta una vita?"};

    private static final int RESOURCE_ID = R.drawable.nicola;

    Random random = new Random();
    int casual= random.nextInt(2);
    int cas1= random.nextInt(di.length);
    int cas2=random.nextInt(inizia.length);
    int cas3=random.nextInt(appellativi.length);
    int cas4=random.nextInt(frasi.length);

    @Override
    public String costruisciStringa(){
        String finale="";
        if(casual<1){
            finale +=frasi[cas4];
        }else {
            finale += inizia[cas2] + " " + di[cas1] + " stà " + appellativi[cas3];
        }
        return finale;
    }

    @Override
    public int getImageResource() {
        return RESOURCE_ID;
    }
}
