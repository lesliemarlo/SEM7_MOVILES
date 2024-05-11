package com.example.semana07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Aquí declaramos un Spinner que nos servira para seleccionar
    Spinner spnSelector;

    //arreglo
    String[] arreglos = {"Me gusta la milanesa",
            "Quiero un pan con pollito y papitas con su quinua y su emoliente",
            "Quiero chaufa"};


    //--
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

        //enviar un objeto de un activity a otro (en este caso en arreglo)

        //--SEM7

        //-- se inicializa el spn para acceder y manipular al spinner
        spnSelector = findViewById(R.id.spnSelector);

        //asigna el OnItemSelectedListener al Spinner
        spnSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //se crea una instancia / implementación personalizada de la interfaz
            @Override //anula metodos
            //se ejecuta cuando se selecciona un elemento en el Spinner
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //al seleccionar para abrur cada activity
                    case 1: //Orange
                        Intent intent1 = new Intent(MainActivity.this, OrangeActivity.class);
                        //PARA EL ARREGLO
                        intent1.putExtra("DATA_FRASES_CELEBRES",arreglos[0]);
                        startActivity(intent1);

                        break;
                    case 2://Blue
                        Intent intent2 = new Intent(MainActivity.this, BlueActivity.class);
                        //PARA EL ARREGLO
                        intent2.putExtra("DATA_FRASES_CELEBRES",arreglos[1]);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, GreenActivity.class);
                        //PARA EL ARREGLO
                        intent3.putExtra("DATA_FRASES_CELEBRES",arreglos[2]);
                        startActivity(intent3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    //

    //MENSAJES
    public void mensajeAlert(String titulo, String msg) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(msg);
        alertDialog.setTitle(titulo);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    public void mensajeAlert(String msg) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(msg);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    void mensajeToast(String mensaje) {
        Toast toast1 = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG);
        toast1.show();
    }

}