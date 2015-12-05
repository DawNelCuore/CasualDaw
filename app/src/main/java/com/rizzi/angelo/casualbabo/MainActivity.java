package com.rizzi.angelo.casualbabo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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

    }
}
