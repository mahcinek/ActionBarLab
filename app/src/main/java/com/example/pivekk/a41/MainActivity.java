package com.example.pivekk.a41;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnWyborOpcjiListener {


    Fragment11 f11;
    Fragment12 f12;
    Fragment13 f13;
    FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intencja3 = new Intent(this,Tabs.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(intencja3);

        f11 = new Fragment11();
        f12 = new Fragment12();
        f13 = new Fragment13();

        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener, f12);
        transakcja.detach(f12);
        transakcja.add(R.id.kontener, f13);
        transakcja.detach(f13);
        transakcja.commit();



        Button b3=(Button) findViewById(R.id.button);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intencja3);
            }
        } );

    }


    public void onWyborOpcji(int opcja){
        FragmentTransaction transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.detach(f11);
        transakcja.detach(f12);
        transakcja.detach(f13);

        switch(opcja){
            case 1:{
                transakcja.attach(f11);
                break;
            }
            case 2:{
                transakcja.attach(f12);
                break;
            }
            case 3:{
                transakcja.attach(f13);
                break;
            }
        }

        transakcja.commit();
    }



    public void onBtn(View view){
        startActivity(new Intent(this, Tabs.class));
    }

}



