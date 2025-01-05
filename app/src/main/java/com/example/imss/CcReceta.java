package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CcReceta extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu20, btnCuenta20, btnRetorno20, btnEscuchar20, btnEmergencia20, btnGlosario20, btnAgregarRegistroR;
    TextView txtVFechaR1, txtVMedic1, txtVDosis1, txtVFechaR2, txtVMedic2, txtVDosis2, txtVFechaR3,
            txtVMedic3, txtVDosis3, txtVFechaR4, txtVMedic4, txtVDosis4, txtVFechaR5, txtVMedic5,
            txtVDosis5, txtVFechaR6, txtVMedic6, txtVDosis6, txtVFechaR7, txtVMedic7, txtVDosis7,
            txtVFechaR8, txtVMedic8, txtVDosis8, txtVFechaR9, txtVMedic9, txtVDosis9;
    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9;
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
        btnAgregarRegistroR = findViewById(R.id.btnAgregarRegistroR);
        btnAgregarRegistroR.setOnClickListener(this);

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
        txtVFechaR6 = findViewById(R.id.txtVFechaR6);
        txtVMedic6 = findViewById(R.id.txtVMedic6);
        txtVDosis6 = findViewById(R.id.txtVDosis6);
        txtVFechaR7 = findViewById(R.id.txtVFechaR7);
        txtVMedic7 = findViewById(R.id.txtVMedic7);
        txtVDosis7 = findViewById(R.id.txtVDosis7);
        txtVFechaR8 = findViewById(R.id.txtVFechaR8);
        txtVMedic8 = findViewById(R.id.txtVMedic8);
        txtVDosis8 = findViewById(R.id.txtVDosis8);
        txtVFechaR9 = findViewById(R.id.txtVFechaR9);
        txtVMedic9 = findViewById(R.id.txtVMedic9);
        txtVDosis9 = findViewById(R.id.txtVDosis9);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        layout6 = findViewById(R.id.layout6);
        layout7 = findViewById(R.id.layout7);
        layout8 = findViewById(R.id.layout8);
        layout9 = findViewById(R.id.layout9);

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
        TextView[] fechas = {txtVFechaR1, txtVFechaR2, txtVFechaR3, txtVFechaR4, txtVFechaR5, txtVFechaR6, txtVFechaR7, txtVFechaR8, txtVFechaR9};
        TextView[] medicamentos = {txtVMedic1, txtVMedic2, txtVMedic3, txtVMedic4, txtVMedic5, txtVMedic6, txtVMedic7, txtVMedic8, txtVMedic9};
        TextView[] dosis = {txtVDosis1, txtVDosis2, txtVDosis3, txtVDosis4, txtVDosis5, txtVDosis6, txtVDosis7, txtVDosis8, txtVDosis9};
        LinearLayout[] layouts = {layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9};
        for (LinearLayout layout : layouts) {
            layout.setVisibility(View.GONE);
        }
        int i = 0;
        while (fila2.moveToNext() && i < layouts.length) {
            String fecha = fila2.getInt(0) + "/" + fila2.getInt(1) + "/" + fila2.getInt(2);
            fechas[i].setText(fecha);
            medicamentos[i].setText(fila2.getString(3));
            dosis[i].setText(fila2.getString(4));
            layouts[i].setVisibility(View.VISIBLE);
            i++;
        }
        fila2.close();
        basesita2.close();
        if (i == 0) {
            Toast.makeText(this, "No se encontraron recetas para este usuario", Toast.LENGTH_SHORT).show();
        }
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
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario20) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnAgregarRegistroR) {
            Intent intentito = new Intent(this, CcAgregaReceta.class);
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