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

public class CcContactoImss extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu14, btnCuenta14, btnRetorno14, btnEscuchar14, btnEmergencia14, btnGlosario14;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_contacto_imss);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu14 = findViewById(R.id.btnMenu14);
        btnMenu14.setOnClickListener(this);
        btnCuenta14 = findViewById(R.id.btnCuenta14);
        btnCuenta14.setOnClickListener(this);
        btnRetorno14 = findViewById(R.id.btnRetorno14);
        btnRetorno14.setOnClickListener(this);
        btnEscuchar14 = findViewById(R.id.btnEscuchar14);
        btnEscuchar14.setOnClickListener(this);
        btnEmergencia14 = findViewById(R.id.btnEmergencia14);
        btnEmergencia14.setOnClickListener(this);
        btnGlosario14 = findViewById(R.id.btnGlosario14);
        btnGlosario14.setOnClickListener(this);
        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta14.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu14) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta14) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno14) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar14) {
            //Nada
        } else if (view.getId() == R.id.btnEmergencia14) {
            //Nada
        } else if (view.getId() == R.id.btnGlosario14) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        }
    }
}