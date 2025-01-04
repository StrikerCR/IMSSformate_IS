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

public class CcHistorialClinico extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu18, btnCuenta18, btnRetorno18, btnEscuchar18, btnBfF, btnEmergencia18, btnGlosario18;
    TextView txtVFecha1, txtVTitulo1, txtVDescripcion1, txtVSolucion1, txtVFecha2, txtVTitulo2,
            txtVDescripcion2, txtVSolucion2, txtVFecha3, txtVTitulo3, txtVDescripcion3,
            txtVSolucion3, txtVFecha4, txtVTitulo4, txtVDescripcion4, txtVSolucion4, txtVFecha5,
            txtVTitulo5, txtVDescripcion5, txtVSolucion5;
    int usuarioId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_historial_clinico);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        usuarioId = Apoyo.obtenerId();
        if (usuarioId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu18 = findViewById(R.id.btnMenu18);
        btnMenu18.setOnClickListener(this);
        btnCuenta18 = findViewById(R.id.btnCuenta18);
        btnCuenta18.setOnClickListener(this);
        btnRetorno18 = findViewById(R.id.btnRetorno18);
        btnRetorno18.setOnClickListener(this);
        btnEscuchar18 = findViewById(R.id.btnEscuchar18);
        btnEscuchar18.setOnClickListener(this);
        btnBfF = findViewById(R.id.btnBfF);
        btnBfF.setOnClickListener(this);
        btnEmergencia18 = findViewById(R.id.btnEmergencia18);
        btnEmergencia18.setOnClickListener(this);
        btnGlosario18 = findViewById(R.id.btnGlosario18);
        btnGlosario18.setOnClickListener(this);

        txtVFecha1 = findViewById(R.id.txtVFecha1);
        txtVTitulo1 = findViewById(R.id.txtVTitulo1);
        txtVDescripcion1 = findViewById(R.id.txtVDescripcion1);
        txtVSolucion1 = findViewById(R.id.txtVSolucion1);
        txtVFecha2 = findViewById(R.id.txtVFecha2);
        txtVTitulo2 = findViewById(R.id.txtVTitulo2);
        txtVDescripcion2 = findViewById(R.id.txtVDescripcion2);
        txtVSolucion2 = findViewById(R.id.txtVSolucion2);
        txtVFecha3 = findViewById(R.id.txtVFecha3);
        txtVTitulo3 = findViewById(R.id.txtVTitulo3);
        txtVDescripcion3 = findViewById(R.id.txtVDescripcion3);
        txtVSolucion3 = findViewById(R.id.txtVSolucion3);
        txtVFecha4 = findViewById(R.id.txtVFecha4);
        txtVTitulo4 = findViewById(R.id.txtVTitulo4);
        txtVDescripcion4 = findViewById(R.id.txtVDescripcion4);
        txtVSolucion4 = findViewById(R.id.txtVSolucion4);
        txtVFecha5 = findViewById(R.id.txtVFecha5);
        txtVTitulo5 = findViewById(R.id.txtVTitulo5);
        txtVDescripcion5 = findViewById(R.id.txtVDescripcion5);
        txtVSolucion5 = findViewById(R.id.txtVSolucion5);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(usuarioId)});
        if (fila.moveToFirst()) {
            btnCuenta18.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
        SQLiteDatabase basesita2 = admin.getReadableDatabase();
        String query2 = "SELECT dia, mes, año, titulo, descripcion, solucion FROM HistorialClinico WHERE userId = ?";
        Cursor fila2 = basesita2.rawQuery(query2, new String[]{String.valueOf(usuarioId)});
        TextView[] fechas = {txtVFecha1, txtVFecha2, txtVFecha3, txtVFecha4, txtVFecha5};
        TextView[] titulos = {txtVTitulo1, txtVTitulo2, txtVTitulo3, txtVTitulo4, txtVTitulo5};
        TextView[] descripciones = {txtVDescripcion1, txtVDescripcion2, txtVDescripcion3, txtVDescripcion4, txtVDescripcion5};
        TextView[] soluciones = {txtVSolucion1, txtVSolucion2, txtVSolucion3, txtVSolucion4, txtVSolucion5};
        int i = 0;
        while (fila2.moveToNext() && i < fechas.length) {
            String fecha = fila2.getInt(0) + "/" + fila2.getInt(1) + "/" + fila2.getInt(2); // dia/mes/año
            fechas[i].setText(fecha);
            titulos[i].setText(fila2.getString(3));
            descripciones[i].setText(fila2.getString(4));
            soluciones[i].setText(fila2.getString(5));
            i++;
        }
        fila2.close();
        basesita2.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu18) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta18) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno18) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar18) {
            //Nada
        } else if (view.getId() == R.id.btnBfF) {
            //Aun nada
        } else if (view.getId() == R.id.btnEmergencia18) {
            //NAda
        } else if (view.getId() == R.id.btnGlosario18) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        }
    }
}