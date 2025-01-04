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

public class CcCerrarSesion extends AppCompatActivity implements View.OnClickListener {
   Button btnMenu15, btnCuenta15, btnEscuchar15, btnCerrarSesion, btnRetorno15, btnEmergencia15, btnGlosario15;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_cerrar_sesion);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu15 = findViewById(R.id.btnMenu15);
        btnMenu15.setOnClickListener(this);
        btnCuenta15 = findViewById(R.id.btnCuenta15);
        btnCuenta15.setOnClickListener(this);
        btnEscuchar15 = findViewById(R.id.btnEscuchar15);
        btnEscuchar15.setOnClickListener(this);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        btnCerrarSesion.setOnClickListener(this);
        btnRetorno15 = findViewById(R.id.btnRetorno15);
        btnRetorno15.setOnClickListener(this);
        btnEmergencia15 = findViewById(R.id.btnEmergencia15);
        btnEmergencia15.setOnClickListener(this);
        btnGlosario15 = findViewById(R.id.btnGlosario15);
        btnGlosario15.setOnClickListener(this);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta15.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu15) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta15) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar15) {
            //Nada
        } else if (view.getId() == R.id.btnCerrarSesion) {
            Apoyo.reiniciarId();
            Apoyo.reiniciarNumFam2();
            Intent intentito = new Intent(this, MainActivity.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno15) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia15) {
            //Nada
        } else if (view.getId() == R.id.btnGlosario15) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        }
    }
}