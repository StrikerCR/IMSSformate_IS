package com.example.imss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NcContactoImss extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu4, btnCuenta4, btnEscuchar4, btnRetorno4, btnEmergencia4, btnGlosario4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nc_contacto_imss);
        btnMenu4 = findViewById(R.id.btnMenu4);
        btnMenu4.setOnClickListener(this);
        btnCuenta4 = findViewById(R.id.btnCuenta4);
        btnCuenta4.setOnClickListener(this);
        btnEscuchar4 = findViewById(R.id.btnEscuchar4);
        btnEscuchar4.setOnClickListener(this);
        btnRetorno4 = findViewById(R.id.btnRetorno4);
        btnRetorno4.setOnClickListener(this);
        btnEmergencia4 = findViewById(R.id.btnEmergencia4);
        btnEmergencia4.setOnClickListener(this);
        btnGlosario4 = findViewById(R.id.btnGlosario4);
        btnGlosario4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu4) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta4) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar4) {
            //Nada
        } else if (view.getId() == R.id.btnRetorno4) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia4) {
            //Nada
        } else if (view.getId() == R.id.btnGlosario4) {
            Intent intentito = new Intent(this, NcGlosario.class);
            startActivity(intentito);
        }
    }
}