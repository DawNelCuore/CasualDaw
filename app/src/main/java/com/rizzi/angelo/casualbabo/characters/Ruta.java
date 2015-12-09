package com.rizzi.angelo.casualbabo.characters;



import com.rizzi.angelo.casualbabo.R;

import java.util.Random;

import it.robertolaricchia.interfaces.CharacterInterface;

/**
 * Created by angelo on 09/12/15.
 */
public class Ruta implements CharacterInterface {
    private String [] frasi={"OK M.R", "Stai piombissimo in Java"};
    private static final int RESOURCE_ID = R.drawable.ruta;
    Random random = new Random();

    int cas1= random.nextInt(frasi.length);



    public String costruisciStringa(){
        String finale=frasi[cas1];



        return finale;
    }

    @Override
    public int getImageResource() {
        return RESOURCE_ID;
    }
}
