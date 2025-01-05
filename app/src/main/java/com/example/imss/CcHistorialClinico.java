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

public class CcHistorialClinico extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu18, btnCuenta18, btnRetorno18, btnEscuchar18, btnBfF, btnEmergencia18, btnGlosario18, btnAgregarRegistroH;
    TextView txtVFecha1, txtVTitulo1, txtVDescripcion1, txtVSolucion1, txtVFecha2, txtVTitulo2,
            txtVDescripcion2, txtVSolucion2, txtVFecha3, txtVTitulo3, txtVDescripcion3,
            txtVSolucion3, txtVFecha4, txtVTitulo4, txtVDescripcion4, txtVSolucion4, txtVFecha5,
            txtVTitulo5, txtVDescripcion5, txtVSolucion5, txtVFecha6, txtVTitulo6, txtVDescripcion6,
            txtVSolucion6, txtVFecha7, txtVTitulo7, txtVDescripcion7, txtVSolucion7, txtVFecha8,
            txtVTitulo8, txtVDescripcion8, txtVSolucion8, txtVFecha9, txtVTitulo9, txtVDescripcion9,
            txtVSolucion9;
    LinearLayout layoutH1, layoutH2, layoutH3, layoutH4, layoutH5, layoutH6, layoutH7, layoutH8, layoutH9;
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
        btnAgregarRegistroH = findViewById(R.id.btnAgregarRegistroH);
        btnAgregarRegistroH.setOnClickListener(this);

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
        txtVFecha6 = findViewById(R.id.txtVFecha6);
        txtVTitulo6 = findViewById(R.id.txtVTitulo6);
        txtVDescripcion6 = findViewById(R.id.txtVDescripcion6);
        txtVSolucion6 = findViewById(R.id.txtVSolucion6);
        txtVFecha7 = findViewById(R.id.txtVFecha7);
        txtVTitulo7 = findViewById(R.id.txtVTitulo7);
        txtVDescripcion7 = findViewById(R.id.txtVDescripcion7);
        txtVSolucion7 = findViewById(R.id.txtVSolucion7);
        txtVFecha8 = findViewById(R.id.txtVFecha8);
        txtVTitulo8 = findViewById(R.id.txtVTitulo8);
        txtVDescripcion8 = findViewById(R.id.txtVDescripcion8);
        txtVSolucion8 = findViewById(R.id.txtVSolucion8);
        txtVFecha9 = findViewById(R.id.txtVFecha9);
        txtVTitulo9 = findViewById(R.id.txtVTitulo9);
        txtVDescripcion9 = findViewById(R.id.txtVDescripcion9);
        txtVSolucion9 = findViewById(R.id.txtVSolucion9);

        layoutH1 = findViewById(R.id.layoutH1);
        layoutH2 = findViewById(R.id.layoutH2);
        layoutH3 = findViewById(R.id.layoutH3);
        layoutH4 = findViewById(R.id.layoutH4);
        layoutH5 = findViewById(R.id.layoutH5);
        layoutH6 = findViewById(R.id.layoutH6);
        layoutH7 = findViewById(R.id.layoutH7);
        layoutH8 = findViewById(R.id.layoutH8);
        layoutH9 = findViewById(R.id.layoutH9);

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
        TextView[] fechas = {txtVFecha1, txtVFecha2, txtVFecha3, txtVFecha4, txtVFecha5, txtVFecha6, txtVFecha7, txtVFecha8, txtVFecha9};
        TextView[] titulos = {txtVTitulo1, txtVTitulo2, txtVTitulo3, txtVTitulo4, txtVTitulo5, txtVTitulo6, txtVTitulo7, txtVTitulo8, txtVTitulo9};
        TextView[] descripciones = {txtVDescripcion1, txtVDescripcion2, txtVDescripcion3, txtVDescripcion4, txtVDescripcion5, txtVDescripcion6, txtVDescripcion7, txtVDescripcion8, txtVDescripcion9};
        TextView[] soluciones = {txtVSolucion1, txtVSolucion2, txtVSolucion3, txtVSolucion4, txtVSolucion5, txtVSolucion6, txtVSolucion7, txtVSolucion8, txtVSolucion9};
        LinearLayout[] layouts = {layoutH1, layoutH2, layoutH3, layoutH4, layoutH5, layoutH6, layoutH7, layoutH8, layoutH9};
        for (LinearLayout layout : layouts) {
            layout.setVisibility(View.GONE);
        }
        int i = 0;
        while (fila2.moveToNext() && i < layouts.length) {
            // Formatear la fecha
            String fecha = fila2.getInt(0) + "/" + fila2.getInt(1) + "/" + fila2.getInt(2); // dia/mes/año
            fechas[i].setText(fecha);
            titulos[i].setText(fila2.getString(3));
            descripciones[i].setText(fila2.getString(4));
            soluciones[i].setText(fila2.getString(5));

            // Mostrar el layout correspondiente
            layouts[i].setVisibility(View.VISIBLE);
            i++;
        }
        fila2.close();
        basesita2.close();
        if (i == 0) {
            Toast.makeText(this, "No se encontraron registros para este usuario", Toast.LENGTH_SHORT).show();
        }
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
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario18) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnAgregarRegistroH) {
            Intent intentito = new Intent(this, CcAgregaHistorial.class);
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