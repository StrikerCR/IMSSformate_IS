package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CcCambioClinica extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu21, btnCuenta21, btnRetorno21, btnEscuchar21, btnEmergencia21, btnGlosario21;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_cambio_clinica);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu21 = findViewById(R.id.btnMenu21);
        btnMenu21.setOnClickListener(this);
        btnCuenta21 = findViewById(R.id.btnCuenta21);
        btnCuenta21.setOnClickListener(this);
        btnRetorno21 = findViewById(R.id.btnRetorno21);
        btnRetorno21.setOnClickListener(this);
        btnEscuchar21 = findViewById(R.id.btnEscuchar21);
        btnEscuchar21.setOnClickListener(this);
        btnEmergencia21 = findViewById(R.id.btnEmergencia21);
        btnEmergencia21.setOnClickListener(this);
        btnGlosario21 = findViewById(R.id.btnGlosario21);
        btnGlosario21.setOnClickListener(this);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta21.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu21) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta21) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno21) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar21) {
            //Nada
        } else if (view.getId() == R.id.btnEmergencia21) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario21) {
            Intent intentito = new Intent(this, CcGlosario.class);
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