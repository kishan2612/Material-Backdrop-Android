package com.evolve.backdrop;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.animation.LinearInterpolator;

import com.evolve.backdroplibrary.BackdropContainer;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BackdropContainer backdropContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.testToolbar);

        backdropContainer =(BackdropContainer)findViewById(R.id.backdropcontainer);


        int height= this.getResources().getDimensionPixelSize(R.dimen.sneek_height);
        backdropContainer.attachToolbar(toolbar)
                .dropInterpolator(new LinearInterpolator())
                .dropHeight(height)
                .build();



    }
}
