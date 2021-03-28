package com.example.conmonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText ed1;
private TextView ed2,lck;
private RadioGroup rd;
private Button btn;
private RadioButton eurotodinar,dinartoeuro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.aconv);
        ed2=(TextView)findViewById(R.id.espaceres);
        lck=(TextView)findViewById(R.id.lck);

        rd=(RadioGroup)findViewById(R.id.radiogrp);
        eurotodinar=(RadioButton)findViewById(R.id.rdbtn1);
        dinartoeuro=(RadioButton)findViewById(R.id.rdbtn2);
        btn=(Button)findViewById(R.id.btn);


        lck.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return true;
            }
        });

        lck.setOnCreateContextMenuListener(this);

            }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,1,0,"€ TO DT");
        menu.add(0,2,0,"DT TO €");
        menu.add(0,3,0,"F TO C");
        menu.add(0,4,0,"C TO F");
        menu.add(0,5,0,"EXIT");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "0.31", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this, "3.1", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Intent intent_1 = new Intent(MainActivity.this, Convtempact.class);
                startActivity(intent_1);
                break;
            case 4:
                Intent intent_2 = new Intent(MainActivity.this, Convtempact.class);
                startActivity(intent_2);
                break;
            case 5:
                this.finish();
                break;

        }
        return super.onContextItemSelected(item);
    }

    private float euroToDinar (float valeurEuro) {
        return (float) (valeurEuro * 3.1);
    }

    private float dinarsToEuro (float valeurDinar) {
        return (float) (valeurDinar * 0.31);
    }

    public void convertir (View v) {

        Float rez = null;
        String s = ed1.getText().toString();
        Float valeur = Float.parseFloat(s);

        if (eurotodinar.isChecked()) {
            rez = euroToDinar(valeur);
            ed2.setText(String.valueOf(rez)+ " TND");
        }

        if (dinartoeuro.isChecked()) {
            rez = dinarsToEuro(valeur);
            ed2.setText(String.valueOf(rez) + " €");
        }
    }

}