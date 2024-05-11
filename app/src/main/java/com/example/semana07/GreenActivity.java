package com.example.semana07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GreenActivity extends AppCompatActivity {

    //declarar
    Button btnRegresarGreen;

    //ARREGLO
    TextView txtDataGreen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_green);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //inicializa el boton
        btnRegresarGreen = findViewById(R.id.btnRegresarGreen);

        ///para cuando le des clicl al boton y se ejecutara el OnClick
        btnRegresarGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //arreglo
        //arreglo - investigar
        Bundle extras = getIntent().getExtras(); //e utiliza para obtener los datos extras pasados a una actividad a través de un Intent.
        String txt = extras.getString("DATA_FRASES_CELEBRES"); //recibir la data

        txtDataGreen = findViewById(R.id.txtDataGreen);
        txtDataGreen.setText(txt);


    }


}