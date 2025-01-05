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

public class CcAgregaHistorial extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu25, btnCuenta25, btnRetorno25, btnEscuchar25, btnEmergencia25, btnGlosario25, btnagregarHBD;
    TextView txtDiaHistorial, txtMesHistorial, txtAnoHistorial, txtTituloHistorial, txtDescripcionHistorial, txtSolucionHistorial;
    int userId, numeroV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_agrega_historial);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu25 = findViewById(R.id.btnMenu25);
        btnMenu25.setOnClickListener(this);
        btnCuenta25 = findViewById(R.id.btnCuenta25);
        btnCuenta25.setOnClickListener(this);
        btnRetorno25 = findViewById(R.id.btnRetorno25);
        btnRetorno25.setOnClickListener(this);
        btnEscuchar25 = findViewById(R.id.btnEscuchar25);
        btnEscuchar25.setOnClickListener(this);
        btnEmergencia25 = findViewById(R.id.btnEmergencia25);
        btnEmergencia25.setOnClickListener(this);
        btnGlosario25 = findViewById(R.id.btnGlosario25);
        btnGlosario25.setOnClickListener(this);
        btnagregarHBD = findViewById(R.id.btnagregarHBD);
        btnagregarHBD.setOnClickListener(this);
        txtDiaHistorial = findViewById(R.id.txtDiaHistorial);
        txtMesHistorial = findViewById(R.id.txtMesHistorial);
        txtAnoHistorial = findViewById(R.id.txtAnoHistorial);
        txtTituloHistorial = findViewById(R.id.txtTituloHistorial);
        txtDescripcionHistorial = findViewById(R.id.txtDescripcionHistorial);
        txtSolucionHistorial = findViewById(R.id.txtSolucionHistorial);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta25.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        userId = Apoyo.obtenerId();
        numeroV = Apoyo.obtenerNumVacunas();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        if (view.getId() == R.id.btnMenu25) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta25) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno25) {
            Intent intentito = new Intent(this, CcHistorialClinico.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar25) {
            //Nada
        } else if (view.getId() == R.id.btnagregarHBD) {
            String dia = txtDiaHistorial.getText().toString().trim();
            String mes = txtMesHistorial.getText().toString().trim();
            String ano = txtAnoHistorial.getText().toString().trim();
            String titulo = txtTituloHistorial.getText().toString().trim();
            String descripcion = txtDescripcionHistorial.getText().toString().trim();
            String solucion = txtSolucionHistorial.getText().toString().trim();
            if (dia.isEmpty() || mes.isEmpty() || ano.isEmpty() || titulo.isEmpty() || descripcion.isEmpty() || solucion.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            if (dia.matches("\\d+") && mes.matches("\\d+") && ano.matches("\\d+")) {
                int diaInt = Integer.parseInt(dia);
                int mesInt = Integer.parseInt(mes);
                int anoInt = Integer.parseInt(ano);

                if (diaInt < 1 || diaInt > 31 || mesInt < 1 || mesInt > 12 || anoInt < 1900 || anoInt > 2100) {
                    Toast.makeText(this, "Por favor, ingresa una fecha válida", Toast.LENGTH_SHORT).show();
                    return;
                }
            } else {
                Toast.makeText(this, "Por favor, ingresa valores numéricos válidos para la fecha", Toast.LENGTH_SHORT).show();
                return;
            }
            Base admin = new Base(this, "IMSSdbF", null, 1);
            SQLiteDatabase basesita = admin.getReadableDatabase();
            String countQuery = "SELECT COUNT(*) FROM HistorialClinico WHERE userId = ?";
            Cursor cursor = basesita.rawQuery(countQuery, new String[]{String.valueOf(userId)});
            int count = 0;
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            cursor.close();
            if (count >= 9) {
                Toast.makeText(this, "No puedes agregar más de 9 registros en el historial clínico.", Toast.LENGTH_SHORT).show();
                basesita.close();
                return;
            }
            SQLiteDatabase writableDB = admin.getWritableDatabase();
            String query = "INSERT INTO HistorialClinico(userId, dia, mes, año, titulo, descripcion, solucion) VALUES (?, ?, ?, ?, ?, ?, ?)";
            writableDB.execSQL(query, new Object[]{userId, Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(ano), titulo, descripcion, solucion});
            writableDB.close();
            Toast.makeText(this, "Historial agregado correctamente", Toast.LENGTH_SHORT).show();
            txtDiaHistorial.setText("");
            txtMesHistorial.setText("");
            txtAnoHistorial.setText("");
            txtTituloHistorial.setText("");
            txtDescripcionHistorial.setText("");
            txtSolucionHistorial.setText("");
            Intent intentito = new Intent(this, CcHistorialClinico.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia25) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario25) {
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