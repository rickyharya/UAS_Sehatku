package com.rickyhr.utssehatku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.ImageButton;

import static android.view.View.*;

public class mainMenu extends AppCompatActivity implements OnClickListener {
ImageButton btrs;
ImageButton btambulan;
ImageButton btobat;
ImageButton btdokter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        btrs = (ImageButton) findViewById(R.id.hospital);
        btambulan = findViewById(R.id.cal_ambulan);
        btobat = findViewById(R.id.obat);
        btdokter = findViewById(R.id.dokter);
        btrs.setOnClickListener(this);
        btobat.setOnClickListener(this);
        btdokter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hospital:
                Intent rs = new Intent(mainMenu.this, Cekrumahsait.class);
                startActivity(rs);
                break;
            case R.id.obat:
                Intent Iobat = new Intent(mainMenu.this, obat.class);
                startActivity(Iobat);
                break;
            case R.id.dokter:
                Intent Idokter = new Intent(mainMenu.this, schedul_dokter.class);
                startActivity(Idokter);
                break;
        }


    }
}
