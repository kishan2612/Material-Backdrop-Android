package com.evolve.backdrop;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.animation.LinearInterpolator;

import com.evolve.backdroplibrary.BackdropContainer;
import com.evolve.backdroplibrary.BackdropStateListener;

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

        backdropContainer.setOnStateListener(new BackdropStateListener() {
            @Override
            public void onStateChange(boolean dropped) {
                Log.e("BackdropStateListener","Dropped: " + dropped);
            }
        });

    }
}
