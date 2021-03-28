package com.example.conmonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Convtempact extends AppCompatActivity {


    private RadioButton cToF, fToC;
    private EditText entree_tmp;
    private TextView sortie_tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convtempact);


        fToC = (RadioButton) findViewById(R.id.rdbtn12);
        cToF = (RadioButton) findViewById(R.id.rdbtn22);

        entree_tmp = (EditText) findViewById(R.id.aconv2);

        sortie_tmp = (TextView) findViewById(R.id.espaceres2);
    }

    private float fToc(float valeurF) {
        return (float) (valeurF - 32) * (5 / 9);
    }

    private float cToF(float valeurC) {
        return (float) (valeurC * (9 / 5)) + 32;
    }

    public void convertir_tmp(View v) {

        Float rez = null;
        String s = entree_tmp.getText().toString();
        Float valeur = Float.parseFloat(s);

        if (cToF.isChecked()) {
            rez = cToF(valeur);
            sortie_tmp.setText(String.valueOf(rez) + " °F");
        }

        if (fToC.isChecked()) {
            rez = fToc(valeur);
            sortie_tmp.setText(String.valueOf(rez) + " °C");
        }

    }
}