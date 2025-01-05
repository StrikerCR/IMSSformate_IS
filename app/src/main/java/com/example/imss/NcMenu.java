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

public class NcMenu extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu2, btnCuenta2, btnEscuchar2, btnRetorno2, btnHowUseNC, btnContImssNC, btnEmergencia2, btnGlosario2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nc_menu);
        btnMenu2 = findViewById(R.id.btnMenu2);
        btnMenu2.setOnClickListener(this);
        btnCuenta2 = findViewById(R.id.btnCuenta2);
        btnCuenta2.setOnClickListener(this);
        btnEscuchar2 = findViewById(R.id.btnEscuchar2);
        btnEscuchar2.setOnClickListener(this);
        btnRetorno2 = findViewById(R.id.btnRetorno2);
        btnRetorno2.setOnClickListener(this);
        btnHowUseNC = findViewById(R.id.btnHowUseNC);
        btnHowUseNC.setOnClickListener(this);
        btnContImssNC = findViewById(R.id.btnContImssNC);
        btnContImssNC.setOnClickListener(this);
        btnEmergencia2 = findViewById(R.id.btnEmergencia2);
        btnEmergencia2.setOnClickListener(this);
        btnGlosario2 = findViewById(R.id.btnGlosario2);
        btnGlosario2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu2) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta2) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar2) {
            //Nada
        } else if (view.getId() == R.id.btnRetorno2) {
            Intent intentito = new Intent(this, MainActivity2.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnHowUseNC) {
            Intent intentito = new Intent(this, MainActivity.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnContImssNC) {
            Intent intentito = new Intent(this, NcContactoImss.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia2) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario2) {
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