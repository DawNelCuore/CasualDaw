package com.rizzi.angelo.casualbabo.characters;

import com.rizzi.angelo.casualbabo.R;

import java.util.Random;

import it.robertolaricchia.interfaces.CharacterInterface;

/**
 * Created by angelo on 04/12/15.
 */
public class DawStani implements CharacterInterface {

    private static  String[] inizia={ "Sì, però", "Bisogna vedere se.."};
    private static  String[] appellativi={"quest'anno andiamo in LegaPro", "falliamo","babo sei l'antigioia", "che schifo Antò! Metti la mano davanti al naso!", "l'Ilva chiude" };
    Random random = new Random();
    private static final int RESOURCE_ID = R.drawable.daw;
    int cas2=random.nextInt(inizia.length);
    int cas3=random.nextInt(appellativi.length);

    @Override
    public String costruisciStringa(){
        String finale = inizia[cas2]+" "+ appellativi[cas3];
        return finale;
    }

    @Override
    public int getImageResource() {
        return RESOURCE_ID;
    }

}
