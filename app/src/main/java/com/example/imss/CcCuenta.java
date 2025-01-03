package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CcCuenta extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu17, btnCuenta17, btnRetorno17, btnEscuchar17, btnHC, btnEV, btnCC, btnGC, btnEmergencia4, btnGlosario4;
    TextView txtVCNom, txtVCNSS, txtVCCURP, txtVCNumFam, txtVCNumFam2;
    int userId, verNumFam2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_cuenta);
        Base admin = new Base(this, "IMSSdbF", null, 1);

        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        verNumFam2 = Apoyo.obtenerNumFam2();
        btnMenu17 = findViewById(R.id.btnMenu17);
        btnMenu17.setOnClickListener(this);
        btnCuenta17 = findViewById(R.id.btnCuenta17);
        btnCuenta17.setOnClickListener(this);
        btnRetorno17 = findViewById(R.id.btnRetorno17);
        btnRetorno17.setOnClickListener(this);
        btnEscuchar17 = findViewById(R.id.btnEscuchar17);
        btnEscuchar17.setOnClickListener(this);
        btnHC = findViewById(R.id.btnHC);
        btnHC.setOnClickListener(this);
        btnEV = findViewById(R.id.btnEV);
        btnEV.setOnClickListener(this);
        btnCC = findViewById(R.id.btnCC);
        btnCC.setOnClickListener(this);
        btnGC = findViewById(R.id.btnGC);
        btnGC.setOnClickListener(this);
        btnEmergencia4 = findViewById(R.id.btnEmergencia4);
        btnEmergencia4.setOnClickListener(this);
        btnGlosario4 = findViewById(R.id.btnGlosario4);
        btnGlosario4.setOnClickListener(this);

        txtVCNom = findViewById(R.id.txtVCNom);
        txtVCNSS = findViewById(R.id.txtVCNSS);
        txtVCCURP = findViewById(R.id.txtVCCURP);
        txtVCNumFam = findViewById(R.id.txtVCNumFam);
        txtVCNumFam2 = findViewById(R.id.txtVCNumFam2);
        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta17.setText(fila.getString(0));
            txtVCNom.setText(fila.getString(0));
            txtVCNSS.setText(fila.getString(2));
            txtVCCURP.setText(fila.getString(3));
            txtVCNumFam.setText(fila.getString(4));
            if (verNumFam2 == 1) {
                txtVCNumFam2.setText(fila.getString(5));
            } else {
                txtVCNumFam2.setText("");
                txtVCNumFam2.setVisibility(View.GONE);
            }
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu17) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta17) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno17) {
            Intent intentito = new Intent(this, MainActivity3.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar17) {
            //Nada
        } else if (view.getId() == R.id.btnHC) {
            //Nada
        } else if (view.getId() == R.id.btnEV) {
            //Nada
        } else if (view.getId() == R.id.btnCC) {
            //Nada
        } else if (view.getId() == R.id.btnGC) {
            //Nada
        } else if (view.getId() == R.id.btnEmergencia4) {
            //Nada
        } else if (view.getId() == R.id.btnGlosario4) {
            //Nada
        }
    }
}