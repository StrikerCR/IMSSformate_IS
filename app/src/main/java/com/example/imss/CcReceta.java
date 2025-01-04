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

public class CcReceta extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu20, btnCuenta20, btnRetorno20, btnEscuchar20, btnEmergencia20, btnGlosario20;
    TextView txtVFechaR1, txtVMedic1, txtVDosis1, txtVFechaR2, txtVMedic2, txtVDosis2, txtVFechaR3,
            txtVMedic3, txtVDosis3, txtVFechaR4, txtVMedic4, txtVDosis4, txtVFechaR5, txtVMedic5,
            txtVDosis5;
    int usuarioId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_receta);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        usuarioId = Apoyo.obtenerId();
        if (usuarioId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu20 = findViewById(R.id.btnMenu20);
        btnMenu20.setOnClickListener(this);
        btnCuenta20 = findViewById(R.id.btnCuenta20);
        btnCuenta20.setOnClickListener(this);
        btnRetorno20 = findViewById(R.id.btnRetorno20);
        btnRetorno20.setOnClickListener(this);
        btnEscuchar20 = findViewById(R.id.btnEscuchar20);
        btnEscuchar20.setOnClickListener(this);
        btnEmergencia20 = findViewById(R.id.btnEmergencia20);
        btnEmergencia20.setOnClickListener(this);
        btnGlosario20 = findViewById(R.id.btnGlosario20);
        btnGlosario20.setOnClickListener(this);

        txtVFechaR1 = findViewById(R.id.txtVFechaR1);
        txtVMedic1 = findViewById(R.id.txtVMedic1);
        txtVDosis1 = findViewById(R.id.txtVDosis1);
        txtVFechaR2 = findViewById(R.id.txtVFechaR2);
        txtVMedic2 = findViewById(R.id.txtVMedic2);
        txtVDosis2 = findViewById(R.id.txtVDosis2);
        txtVFechaR3 = findViewById(R.id.txtVFechaR3);
        txtVMedic3 = findViewById(R.id.txtVMedic3);
        txtVDosis3 = findViewById(R.id.txtVDosis3);
        txtVFechaR4 = findViewById(R.id.txtVFechaR4);
        txtVMedic4 = findViewById(R.id.txtVMedic4);
        txtVDosis4 = findViewById(R.id.txtVDosis4);
        txtVFechaR5 = findViewById(R.id.txtVFechaR5);
        txtVMedic5 = findViewById(R.id.txtVMedic5);
        txtVDosis5 = findViewById(R.id.txtVDosis5);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(usuarioId)});
        if (fila.moveToFirst()) {
            btnCuenta20.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
        SQLiteDatabase basesita2 = admin.getReadableDatabase();
        String query2 = "SELECT dia, mes, año, medicamento, dosis FROM Recetas WHERE userId = ?";
        Cursor fila2 = basesita2.rawQuery(query2, new String[]{String.valueOf(usuarioId)});
        TextView[] fechas = {txtVFechaR1, txtVFechaR2, txtVFechaR3, txtVFechaR4, txtVFechaR5};
        TextView[] medicamentos = {txtVMedic1, txtVMedic2, txtVMedic3, txtVMedic4, txtVMedic5};
        TextView[] dosis = {txtVDosis1, txtVDosis2, txtVDosis3, txtVDosis4, txtVDosis5};
        int i = 0;
        while (fila2.moveToNext() && i < fechas.length) {
            String fecha = (fila2.getInt(0) + "/" + fila2.getInt(1) + "/" + fila2.getInt(2));
            fechas[i].setText(fecha);
            medicamentos[i].setText(fila2.getString(3));
            dosis[i].setText(fila2.getString(4));
            i++;
        }
        fila2.close();
        basesita2.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu20) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta20) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno20) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar20) {
            //Nada
        } else if (view.getId() == R.id.btnEmergencia20) {
            //Nada
        } else if (view.getId() == R.id.btnGlosario20) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        }
    }
}