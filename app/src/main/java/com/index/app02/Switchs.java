package com.index.app02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Switchs extends AppCompatActivity {

    Button btnContinuar;
    SwitchCompat switchTerminos;

    private void loadUI(){
        switchTerminos = findViewById(R.id.switchTerminos);
        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setAlpha(0.5f); // apariencia deshabilitada al inicio
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_switchs);

        // Ajuste de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadUI();

        // Cambiar apariencia del botón según switch
        switchTerminos.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                btnContinuar.setAlpha(1f); // apariencia habilitada
            } else {
                btnContinuar.setAlpha(0.5f); // apariencia deshabilitada
            }
        });

        // Click del botón
        btnContinuar.setOnClickListener(v -> {
            if (switchTerminos.isChecked()) {
                Toast.makeText(this, "Gracias por aceptar los términos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Debe aceptar los términos para continuar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}