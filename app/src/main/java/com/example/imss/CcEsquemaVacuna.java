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

public class CcEsquemaVacuna extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu19, btnCuenta19, btnRetorno19, btnEscuchar19, btnEmergencia19, btnGlosario19;
    TextView txtVVacuna1, txtVVacuna2, txtVVacuna3, txtVVacuna4, txtVVacuna5, txtVVacuna6, txtVVacuna7, txtVVacuna8;
    int usuarioId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_esquema_vacuna);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        usuarioId = Apoyo.obtenerId();
        if (usuarioId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu19 = findViewById(R.id.btnMenu19);
        btnMenu19.setOnClickListener(this);
        btnCuenta19 = findViewById(R.id.btnCuenta19);
        btnCuenta19.setOnClickListener(this);
        btnRetorno19 = findViewById(R.id.btnRetorno19);
        btnRetorno19.setOnClickListener(this);
        btnEscuchar19 = findViewById(R.id.btnEscuchar19);
        btnEscuchar19.setOnClickListener(this);
        btnEmergencia19 = findViewById(R.id.btnEmergencia19);
        btnEmergencia19.setOnClickListener(this);
        btnGlosario19 = findViewById(R.id.btnGlosario19);
        btnGlosario19.setOnClickListener(this);

        txtVVacuna1 = findViewById(R.id.txtVVacuna1);
        txtVVacuna2 = findViewById(R.id.txtVVacuna2);
        txtVVacuna3 = findViewById(R.id.txtVVacuna3);
        txtVVacuna4 = findViewById(R.id.txtVVacuna4);
        txtVVacuna5 = findViewById(R.id.txtVVacuna5);
        txtVVacuna6 = findViewById(R.id.txtVVacuna6);
        txtVVacuna7 = findViewById(R.id.txtVVacuna7);
        txtVVacuna8 = findViewById(R.id.txtVVacuna8);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(usuarioId)});
        if (fila.moveToFirst()) {
            btnCuenta19.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
        SQLiteDatabase basesita2 = admin.getReadableDatabase();
        String query2 = "SELECT vacuna FROM Vacunas WHERE userId = ?";
        Cursor fila2 = basesita2.rawQuery(query2, new String[]{String.valueOf(usuarioId)});
        TextView[] txtsVacunas = {txtVVacuna1, txtVVacuna2, txtVVacuna3, txtVVacuna4, txtVVacuna5, txtVVacuna6, txtVVacuna7, txtVVacuna8};

        int i = 0;
        while (fila2.moveToNext() && i < txtsVacunas.length) {
            txtsVacunas[i].setText("* " + fila2.getString(0));
            i++;
        }
        fila2.close();
        if (i == 0) {
            Toast.makeText(this, "No se encontraron vacunas para este usuario", Toast.LENGTH_SHORT).show();
        }
        basesita2.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu19) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta19) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno19) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar19) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnEmergencia19) {
            //NAda
        } else if (view.getId() == R.id.btnGlosario19) {
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