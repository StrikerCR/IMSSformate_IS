package com.example.imss;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CcEditarDatos extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu12, btnCuenta12, btnRetorno12, btnEscuchar12, btnEmergencia12, btnGlosario12, btnAgregNum, btnGuardarDatos;
    EditText txtNomEdit, txtNumEdit, txtNumEdit2;
    TextView txtVNumFam2;
    int userId, verNumFam2;
    int contLocal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_editar_datos);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        verNumFam2 = Apoyo.obtenerNumFam2();
        btnMenu12 = findViewById(R.id.btnMenu12);
        btnMenu12.setOnClickListener(this);
        btnCuenta12 = findViewById(R.id.btnCuenta12);
        btnCuenta12.setOnClickListener(this);
        btnRetorno12 = findViewById(R.id.btnRetorno12);
        btnRetorno12.setOnClickListener(this);
        btnEscuchar12 = findViewById(R.id.btnEscuchar12);
        btnEscuchar12.setOnClickListener(this);
        btnEmergencia12 = findViewById(R.id.btnEmergencia12);
        btnEmergencia12.setOnClickListener(this);
        btnGlosario12 = findViewById(R.id.btnGlosario12);
        btnGlosario12.setOnClickListener(this);
        btnAgregNum = findViewById(R.id.btnAgregNum);
        btnAgregNum.setOnClickListener(this);
        btnGuardarDatos = findViewById(R.id.btnGuardarDatos);
        btnGuardarDatos.setOnClickListener(this);

        txtNomEdit = findViewById(R.id.txtNomEdit);
        txtNumEdit = findViewById(R.id.txtNumEdit);
        txtNumEdit2 = findViewById(R.id.txtNumEdit2);
        txtNumEdit2.setVisibility(View.GONE);

        txtVNumFam2 = findViewById(R.id.txtVNumFam2);
        txtVNumFam2.setVisibility(View.GONE);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta12.setText(fila.getString(0));
            txtNomEdit.setText(fila.getString(0));
            txtNumEdit.setText(fila.getString(4));
            if (verNumFam2 == 1) {
                txtVNumFam2.setVisibility(View.VISIBLE);
                txtNumEdit2.setText(fila.getString(5));
                btnAgregNum.setText("Eliminar Num.2");
                contLocal = 1;
            }
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (view.getId() == R.id.btnMenu12) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta12) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno12) {
            Intent intentito = new Intent(this, CcDatosUsuario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar12) {
            //Nada
        } else if (view.getId() == R.id.btnAgregNum) {
            if (contLocal == 0){
                txtNumEdit2.setVisibility(View.VISIBLE);
                txtVNumFam2.setVisibility(View.VISIBLE);
                btnAgregNum.setText("Eliminar Num.2");
                contLocal = 1;
            } else if (contLocal == 1) {
                txtVNumFam2.setVisibility(View.GONE);
                txtNumEdit2.setVisibility(View.GONE);
                btnAgregNum.setText("AGREGAR OTRO NÚMERO");
                contLocal = 0;
            }
        } else if (view.getId() == R.id.btnGuardarDatos) {
            SQLiteDatabase basesita = admin.getWritableDatabase();
            ContentValues valores = new ContentValues();
            String nuevoNombre = txtNomEdit.getText().toString().trim();
            String nuevoNumFam1 = txtNumEdit.getText().toString().trim();
            String nuevoNumFam2 = txtNumEdit2.getText().toString().trim();
            if (nuevoNombre.isEmpty() || nuevoNumFam1.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos requeridos", Toast.LENGTH_SHORT).show();
                return;
            }
            valores.put("nombre", nuevoNombre);
            valores.put("numFam1", Long.parseLong(nuevoNumFam1));
            if (contLocal == 1 && !nuevoNumFam2.isEmpty()) {
                valores.put("numFam2", Long.parseLong(nuevoNumFam2));
                Apoyo.incrementarNumFam2();
            } else {
                valores.put("numFam2", 0);
                Apoyo.reiniciarNumFam2();
            }
            int filasAfectadas = basesita.update("Usuarios", valores, "id = ?", new String[]{String.valueOf(userId)});
            if (filasAfectadas > 0) {
                Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al actualizar los datos", Toast.LENGTH_SHORT).show();
            }
            basesita.close();
            Intent intentito = new Intent(this, CcDatosUsuario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia12) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario12) {
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