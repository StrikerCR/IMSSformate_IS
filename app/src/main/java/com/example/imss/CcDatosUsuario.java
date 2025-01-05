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

public class CcDatosUsuario extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu11, btnCuenta11, btnRetorno11, btnEscuchar11, btnEditarDatos, btnEmergencia11, btnGlosario11;
    TextView txtVDCCNom, txtVDCCNSS, txtVDCCCURP, txtVDCCNumFam, txtVDCCNumFam2;
    int userId, verNumFam2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_datos_usuario);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        verNumFam2 = Apoyo.obtenerNumFam2();
        btnMenu11 = findViewById(R.id.btnMenu11);
        btnMenu11.setOnClickListener(this);
        btnCuenta11 = findViewById(R.id.btnCuenta11);
        btnCuenta11.setOnClickListener(this);
        btnRetorno11 = findViewById(R.id.btnRetorno11);
        btnRetorno11.setOnClickListener(this);
        btnEscuchar11 = findViewById(R.id.btnEscuchar11);
        btnEscuchar11.setOnClickListener(this);
        btnEditarDatos = findViewById(R.id.btnEditarDatos);
        btnEditarDatos.setOnClickListener(this);
        btnEmergencia11 = findViewById(R.id.btnEmergencia11);
        btnEmergencia11.setOnClickListener(this);
        btnGlosario11 = findViewById(R.id.btnGlosario11);

        txtVDCCNom = findViewById(R.id.txtVDCCNom);
        txtVDCCNSS = findViewById(R.id.txtVDCCNSS);
        txtVDCCCURP = findViewById(R.id.txtVDCCCURP);
        txtVDCCNumFam = findViewById(R.id.txtVDCCNumFam);
        txtVDCCNumFam2 = findViewById(R.id.txtVDCCNumFam2);
        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta11.setText(fila.getString(0));
            String temporal = fila.getString(0) + " " + fila.getString(1);
            txtVDCCNom.setText("Nombre: " + temporal);
            txtVDCCNSS.setText("NSS: " + fila.getString(2));
            txtVDCCCURP.setText("CURP: " + fila.getString(3));
            txtVDCCNumFam.setText("Num. Familiar 1: "+fila.getString(4));
            if (verNumFam2 == 1) {
                txtVDCCNumFam2.setText("Num. Familiar 2: " + fila.getString(5));
            } else {
                txtVDCCNumFam2.setText("");
                txtVDCCNumFam2.setVisibility(View.GONE);
            }
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu11) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta11) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno11) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar11) {
            //Nada
        } else if (view.getId() == R.id.btnEditarDatos) {
            Intent intentito = new Intent(this, CcEditarDatos.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia11) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario11) {
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