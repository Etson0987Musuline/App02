package com.index.app02;

import android.os.Bundle;
import android.view.TextureView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class RadioButons extends AppCompatActivity {

    RadioButton i3, i5, i7;
    RadioButton m8, m16, m32;
    RadioButton gi, gin;
    Button calcular;

    TextView idcpu, idmemoria, idgrafica, total;

    private void loadUI() {
        i3 = findViewById(R.id.i3);
        i5 = findViewById(R.id.i5);
        i7 = findViewById(R.id.i7);
        m8 = findViewById(R.id.m8);
        m16 = findViewById(R.id.m16);
        m32 = findViewById(R.id.m32);
        gi = findViewById(R.id.gi);
        gin = findViewById(R.id.gin);
        idcpu = findViewById(R.id.idcpu);
        idmemoria = findViewById(R.id.idmemoria);
        idgrafica = findViewById(R.id.idgrafica);
        total = findViewById(R.id.total);
        calcular = findViewById(R.id.calcular);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_butons);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadUI();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularPago();
            }
        });
    }

    private void calcularPago() {

        int cpu = 0, memoria = 0, grafica = 0;

        if (i3.isChecked()) {
            cpu = 500;
        } else if (i5.isChecked()) {
            cpu = 800;
        } else if (i7.isChecked()) {
            cpu = 1500;
        }

        if (m8.isChecked()) {
            memoria = 100;
        } else if (m16.isChecked()) {
            memoria = 300;
        } else if (m32.isChecked()) {
            memoria = 600;
        }

        if (gi.isChecked()) {
            grafica = 2000;
        } else if (gin.isChecked()) {
            grafica = 4000;
        }

        idcpu.setText("Precio  $" + cpu);
        idmemoria.setText("Precio  $" + memoria);
        idgrafica.setText("Precio  $" + grafica);

        int sumaTotal = cpu + memoria + grafica;

        total.setText("Precio total: $" + sumaTotal);
    }
}