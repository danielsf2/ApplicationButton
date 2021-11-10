package com.example.applicationbutton;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnSecond;
    Button btnFirst;
    byte exist = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void initialize(){

        btnFirst = findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(v -> {
            createButton(); }
        );
    }//void initialize

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createButton(){

        if(exist == 1){
            Toast.makeText(MainActivity.this,"O Botão já existe!", Toast.LENGTH_SHORT).show();
            return;
        }


        exist = 1;

        btnSecond = new Button(this);
        btnSecond.setText("Second Button");
        btnSecond.setVisibility(View.VISIBLE);
        btnSecond.setTextColor(Color.WHITE);
        btnSecond.setBackgroundColor(Color.RED);
        btnSecond.setPadding(10,0,10,0);

        try {
            LinearLayout.LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            lp.topMargin = 150;
            lp.leftMargin = 380;
            this.addContentView(btnSecond, lp);
        }catch (Exception e){
            e.printStackTrace();
        }

        btnSecond.setOnClickListener(v -> {
            v.setVisibility(View.INVISIBLE);
            exist = 0;
        });

        btnSecond.setOnLongClickListener(v -> {
            Toast.makeText(MainActivity.this,"Hoje é " + LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt","BR")) + "!", Toast.LENGTH_LONG).show();
            return true;
        });

    }//createButton
}//class MainActivity