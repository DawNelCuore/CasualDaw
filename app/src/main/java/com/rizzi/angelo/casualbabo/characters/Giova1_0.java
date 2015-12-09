package com.rizzi.angelo.casualbabo.characters;

import com.rizzi.angelo.casualbabo.R;

import it.robertolaricchia.interfaces.CharacterInterface;


import java.util.Random;

/**
 * Created by angelo on 09/12/15.
 */
public class Giova1_0 implements CharacterInterface{
    String [] frasi={"OK fì", "Io non lo voglio il pene",  "Robbino ino ino miraccomando tienimelo","top top TOOP!"};
    String bacino = new String(Character.toChars(0x1F618));
    String baci="baci, bacini, bacetti" + bacino + bacino + bacino;
    Random random = new Random();
    private static final int RESOURCE_ID = R.drawable.giova;

    int casual= random.nextInt(2);
    int cas1= random.nextInt(frasi.length);



    public String costruisciStringa(){
        String finale="";
        if(casual<1){
            finale +=frasi[cas1];
        }else {
            finale += baci;

        }

        return finale;
    }
    @Override
    public int getImageResource() {
        return RESOURCE_ID;
    }
}
