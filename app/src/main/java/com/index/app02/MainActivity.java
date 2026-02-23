package com.index.app02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnButton, btnCheckBox, btnDialog, btnRadioButton, btnRViews, btnSwitch, btnToat;

    private void LoadUI() {
        btnButton = findViewById(R.id.btnButton);
        btnCheckBox = findViewById(R.id.btnCheckBox);
        btnDialog = findViewById(R.id.btnDialog);
        btnRadioButton = findViewById(R.id.btnRadioButton);
        btnRViews = findViewById(R.id.btnRViews);
        btnSwitch = findViewById(R.id.btnSwitchs);
        btnToat = findViewById(R.id.btnToat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.LoadUI();


        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Buttons.class);
                startActivity(intent);
            }
        });


        btnCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Checkboxs.class);
                startActivity(intent);
            }
        });


        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dialog.class);
                startActivity(intent);
            }
        });


        btnRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RadioButons.class);
                startActivity(intent);
            }
        });


        btnRViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViews.class);
                startActivity(intent);
            }
        });


        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Switchs.class);
                startActivity(intent);
            }
        });


        btnToat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Toats.class);
                startActivity(intent);
            }
        });

    }
}