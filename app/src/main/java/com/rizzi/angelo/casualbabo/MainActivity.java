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

import it.robertolaricchia.interfaces.CharacterInterface;

public class MainActivity extends Activity {


    private CharacterFactory factory;
    private Random classRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        factory = new CharacterFactory(MainActivity.this);

        setContentView(R.layout.activity_main);
        Button button= (Button)findViewById(R.id.btn1);
        final TextView textView= (TextView)findViewById(R.id.txt);
        final ImageView imageView=(ImageView)findViewById(R.id.img);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int crandom= classRandom.nextInt(factory.getCount());
                try {
                    CharacterInterface characterInterface = factory.getCharacter(crandom);
                    textView.setText(characterInterface.costruisciStringa());
                    imageView.setImageResource(characterInterface.getImageResource());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }
        });

        //Log.w("Numero classi", new CharacterFactory().getCharactersNumber()+"");
        //Toast.makeText(this, new CharacterFactory().getNomeClassi(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, new CharacterFactory(this).getCount()+"", Toast.LENGTH_LONG).show();
    }
}
