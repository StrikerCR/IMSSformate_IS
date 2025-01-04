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

public class CcAplicacion extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu13, btnCuenta13, btnInicio13, btnRetorno13, btnEmergencia13, btnGlosario13, btnEscuchar13;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_aplicacion);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu13 = findViewById(R.id.btnMenu13);
        btnMenu13.setOnClickListener(this);
        btnCuenta13 = findViewById(R.id.btnCuenta13);
        btnCuenta13.setOnClickListener(this);
        btnInicio13 = findViewById(R.id.btnInicio13);
        btnInicio13.setOnClickListener(this);
        btnRetorno13 = findViewById(R.id.btnRetorno13);
        btnRetorno13.setOnClickListener(this);
        btnEmergencia13 = findViewById(R.id.btnEmergencia13);
        btnEmergencia13.setOnClickListener(this);
        btnGlosario13 = findViewById(R.id.btnGlosario13);
        btnGlosario13.setOnClickListener(this);
        btnEscuchar13 = findViewById(R.id.btnEscuchar13);
        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta13.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu13) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta13) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnInicio13) {
            Intent intentito = new Intent(this, MainActivity3.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno13) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar13) {
            //Nada
        } else if (view.getId() == R.id.btnEmergencia13) {
            //Nada
        } else if (view.getId() == R.id.btnGlosario13) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        }
    }
}