package com.example.imss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu1, btnCuenta1, btnEscuchar1, btnInicio1, btnEmergencia1, btnGlosario1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnMenu1 = findViewById(R.id.btnMenu1);
        btnMenu1.setOnClickListener(this);
        btnCuenta1 = findViewById(R.id.btnCuenta1);
        btnCuenta1.setOnClickListener(this);
        btnEscuchar1 = findViewById(R.id.btnEscuchar1);
        btnEscuchar1.setOnClickListener(this);
        btnInicio1 = findViewById(R.id.btnInicio1);
        btnInicio1.setOnClickListener(this);
        btnEmergencia1 = findViewById(R.id.btnEmergencia1);
        btnEmergencia1.setOnClickListener(this);
        btnGlosario1 = findViewById(R.id.btnGlosario1);
        btnGlosario1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu1) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta1) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar1) {
            //Nada xd
        } else if (view.getId() == R.id.btnInicio1) {
            Intent intentito = new Intent(this, MainActivity2.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia1) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario1) {
            Intent intentito = new Intent(this, NcGlosario.class);
            startActivity(intentito);
        }
    }
    private void abrirMarcador(String numero) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(android.net.Uri.parse("tel:" + numero));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No hay una aplicación para realizar llamadas", Toast.LENGTH_SHORT).show();
        }
    }
}