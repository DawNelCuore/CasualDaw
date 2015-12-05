package com.rizzi.angelo.casualbabo;

import java.util.Random;

/**
 * Created by angelo on 04/12/15.
 */
public class DawStani {

    private static  String[] inizia={ "Sì, però", "Bisogna vedere se.."};
    private static  String[] appellativi={"quest'anno andiamo in LegaPro", "falliamo","babo sei l'antigioia", "che schifo Antò! Metti la mano davanti al naso!", "l'Ilva chiude" };
    Random random = new Random();

    int cas2=random.nextInt(inizia.length);
    int cas3=random.nextInt(appellativi.length);

    public String costruisciStringa(){
        String finale = inizia[cas2]+" "+ appellativi[cas3];
        return finale;
    }

}
