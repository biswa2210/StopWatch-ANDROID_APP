package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class stopwatch extends AppCompatActivity {
    Button btnstart,btnstop;
    ImageView icanchor;
    Animation roundinglone;
    Chronometer timehere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        btnstart=findViewById(R.id.button1);
        btnstop=findViewById(R.id.button2);
        timehere=findViewById(R.id.timehere);
        btnstop.setAlpha(0);
        icanchor=findViewById(R.id.icanchor);
        roundinglone= AnimationUtils.loadAnimation(this,R.anim.roundinglone);
        Typeface mmfont=Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");
        btnstart.setTypeface(mmfont);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation(roundinglone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                timehere.setBase(SystemClock.elapsedRealtime());
                timehere.start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.setAnimation(null);
                btnstop.animate().alpha(0).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(1).setDuration(300).start();
                timehere.stop();
            }
        });
    }
}