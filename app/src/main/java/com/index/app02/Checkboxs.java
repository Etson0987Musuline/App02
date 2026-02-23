package com.index.app02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Checkboxs extends AppCompatActivity {

    EditText etPago, etCalcularPago;

    CheckBox ch01, ch02, ch03;

    Button btnCalcular;

    private void loadUi(){
        etPago = findViewById(R.id.etpago);
        etCalcularPago = findViewById(R.id.etcalcularpago);
        ch01 = findViewById(R.id.ch01);
        ch02 = findViewById(R.id.ch02);
        ch03 = findViewById(R.id.ch03);
        btnCalcular = findViewById(R.id.btncalcular);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkboxs);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadUi();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotalPagar();
            }
        });
    }
    private void calcularTotalPagar(){

        String texto = etPago.getText().toString().trim();

        if(texto.isEmpty()){
            etPago.setError("Ingrese un monto");
            return;
        }

        double totalPagar = Double.parseDouble(texto);

        double bolsa = 0, propina = 0, producto = 0;
        double pagoFinal;

        if (ch01.isChecked()){
            producto = 10;
        }

        if (ch02.isChecked()){
            propina = 5;
        }

        if (ch03.isChecked()){
            bolsa = 2;
        }

        pagoFinal = totalPagar + producto + bolsa + propina;

        etCalcularPago.setText(String.valueOf(pagoFinal));
    }
}