package com.rizzi.angelo.casualbabo;

import java.util.Random;

/**
 * Created by angelo on 04/12/15.
 */
public class Babo {
    private static String[] frasi={"Buona notte degli oscar a tutti", "Ho solo bisogno di segarmi", "Perlomeno mi considera"};
    private static String[] di={"do", "daw", "si", "fo"};
    private static  String[] inizia={"Oh", "Pronto?","Lo sapevo", "imadò" , "Sì?", "No!"};
    private static  String[] appellativi={"sei un coglionazzo", "sei deviato", "pensa a tua sorella","tu sei una ciola", "tu non sei normale","questo è pazzo uagnu"};

    Random random = new Random();
    int casual= random.nextInt(2);
    int cas1= random.nextInt(di.length);
    int cas2=random.nextInt(inizia.length);
    int cas3=random.nextInt(appellativi.length);
    int cas4=random.nextInt(frasi.length);

    public String costruisciStringa(){
        String finale="";
        if(casual<1){
            finale +=frasi[cas4];
        }else {
            finale += inizia[cas2] + " " + di[cas1] + " stà " + appellativi[cas3];
        }
        return finale;
    }
}
