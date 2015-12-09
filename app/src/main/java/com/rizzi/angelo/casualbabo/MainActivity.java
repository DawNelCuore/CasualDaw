package com.rizzi.angelo.casualbabo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rizzi.angelo.casualbabo.characters.Babo;
import com.rizzi.angelo.casualbabo.characters.DawStani;

import java.util.Random;

import com.rizzi.angelo.casualbabo.characters.CharacterFactory;
import com.rizzi.angelo.casualbabo.characters.Giova1_0;
import com.rizzi.angelo.casualbabo.characters.Ruta;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button)findViewById(R.id.btn1);
        final TextView textView= (TextView)findViewById(R.id.txt);
        final ImageView imageView=(ImageView)findViewById(R.id.img);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random classRandom = new Random();
                int crandom= classRandom.nextInt(4);
                switch (crandom){
                    case 0:
                        Babo babo= new Babo();
                        textView.setText(babo.costruisciStringa());
                        imageView.setImageResource(babo.getImageResource());
                        break;
                    case 1:

                        DawStani dawStani= new DawStani();
                        textView.setText(dawStani.costruisciStringa());
                        imageView.setImageResource(dawStani.getImageResource());
                        break;
                    case 2:
                        Giova1_0 giova1_0 = new Giova1_0();
                        textView.setText(giova1_0.costruisciStringa());
                        imageView.setImageResource(giova1_0.getImageResource());
                        break;
                    case 3:
                        Ruta ruta= new Ruta();
                        textView.setText(ruta.costruisciStringa());
                        imageView.setImageResource(ruta.getImageResource());
                }
            }
        });

        //Log.w("Numero classi", new CharacterFactory().getCharactersNumber()+"");
        //Toast.makeText(this, new CharacterFactory().getNomeClassi(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, new CharacterFactory(this).getCount()+"", Toast.LENGTH_LONG).show();
    }
}
