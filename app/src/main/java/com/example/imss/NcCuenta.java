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

public class NcCuenta extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu5, btnCuenta5, btnEscuchar5, btnRetorno5, btnEmergencia5, btnGlosario5, btnRegisRedir, btnISRedir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nc_cuenta);
        btnMenu5 = findViewById(R.id.btnMenu5);
        btnMenu5.setOnClickListener(this);
        btnCuenta5 = findViewById(R.id.btnCuenta5);
        btnCuenta5.setOnClickListener(this);
        btnEscuchar5 = findViewById(R.id.btnEscuchar5);
        btnEscuchar5.setOnClickListener(this);
        btnRetorno5 = findViewById(R.id.btnRetorno5);
        btnRetorno5.setOnClickListener(this);
        btnEmergencia5 = findViewById(R.id.btnEmergencia5);
        btnEmergencia5.setOnClickListener(this);
        btnGlosario5 = findViewById(R.id.btnGlosario5);
        btnGlosario5.setOnClickListener(this);
        btnRegisRedir = findViewById(R.id.btnRegisRedir);
        btnRegisRedir.setOnClickListener(this);
        btnISRedir = findViewById(R.id.btnISRedir);
        btnISRedir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu5) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta5) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar5) {
            //Nada
        } else if (view.getId() == R.id.btnRetorno5) {
            Intent intentito = new Intent(this, MainActivity2.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia5) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario5) {
            Intent intentito = new Intent(this, NcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRegisRedir) {
            Intent intentito = new Intent(this, RegistroUsuario.class);
            intentito.putExtra("nombre", "");
            intentito.putExtra("apellidos", "");
            intentito.putExtra("nss", "");
            intentito.putExtra("curp", "");
            intentito.putExtra("numFam", "");
            startActivity(intentito);
        } else if (view.getId() == R.id.btnISRedir) {
            Intent intentito = new Intent(this, InicioSesion.class);
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