package com.index.app02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Toats extends AppCompatActivity {

    Button lento, rapido;

    private void loadUI() {
        lento = findViewById(R.id.lento);
        rapido = findViewById(R.id.rapido);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toats);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadUI();

        lento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificar("Lento", true);
            }
        });

        rapido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificar("Rápido", false);
            }
        });
    }


    private void notificar(String mensaje, boolean tiempoExtendido) {
        int duration = (tiempoExtendido) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
        Toast.makeText(getApplicationContext(), mensaje, duration).show();
    }
}