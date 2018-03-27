package com.example.pafio.ex6v2;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = findViewById(R.id.button);
        Button transferBtn = findViewById(R.id.button2);
        Button removeBtn = findViewById(R.id.button3);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment();
            }
        });

        transferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transferFragment();
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFragment();
            }
        });
    }

    public void addFragment() {
        Random rnd = new Random();
        Integer color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        Bundle args = new Bundle();
        args.putInt("colorVal",color);

        ColorFragment colorFragment = new ColorFragment();
        colorFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, colorFragment).commit();

    }

    public void transferFragment() {
        Fragment colorFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if(colorFragment != null) {
            getSupportFragmentManager().beginTransaction().remove(colorFragment).commit();
            getSupportFragmentManager().executePendingTransactions();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, colorFragment).commit();
        }
    }

    public void removeFragment() {
        Fragment colorFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container2);
        if(colorFragment != null) getSupportFragmentManager().beginTransaction().remove(colorFragment).commit();
    }

}
