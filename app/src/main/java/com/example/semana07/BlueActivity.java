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

public class BlueActivity extends AppCompatActivity {

    //declarar
    Button btnRegresarBlue;

    TextView txtDataBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blue);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //inicializamos el boton

        btnRegresarBlue = findViewById(R.id.btnRegresarBlue);

        btnRegresarBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BlueActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //arreglo - investigar
        Bundle extras = getIntent().getExtras(); //e utiliza para obtener los datos extras pasados a una actividad a través de un Intent.
        String txt = extras.getString("DATA_FRASES_CELEBRES");  //recibir la data

        txtDataBlue = findViewById(R.id.txtDataBlue);
        txtDataBlue.setText(txt);


    }
}