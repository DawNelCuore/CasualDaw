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
                int crandom= classRandom.nextInt(2);
                switch (crandom){
                    case 0:
                        Babo babo= new Babo();
                        textView.setText(babo.costruisciStringa());
                        imageView.setImageResource(R.drawable.nicola);
                        break;
                    case 1:

                        DawStani dawStani= new DawStani();
                        textView.setText(dawStani.costruisciStringa());
                        imageView.setImageResource(R.drawable.daw);
                        break;
                }
            }
        });

        //Log.w("Numero classi", new CharacterFactory().getCharactersNumber()+"");
        //Toast.makeText(this, new CharacterFactory().getNomeClassi(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, new CharacterFactory(this).getCount()+"", Toast.LENGTH_LONG).show();
    }
}
