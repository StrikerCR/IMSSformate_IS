package com.example.imss;

import android.content.ContentValues;
import android.content.Intent;
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

public class ConfirmaRegistro extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu7, btnCuenta7, btnEscuchar7, btnRetorno7, btnEmergencia7, btnGlosario7, btnConfReg;
    TextView txtVDtNom, txtVDtNSS, txtVDtCURP, txtVDtNumFam;
    String nombre, apellidos, nomCompleto, nss, curp, numFam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirma_registro);
        btnMenu7 = findViewById(R.id.btnMenu7);
        btnMenu7.setOnClickListener(this);
        btnCuenta7 = findViewById(R.id.btnCuenta7);
        btnCuenta7.setOnClickListener(this);
        btnEscuchar7 = findViewById(R.id.btnEscuchar7);
        btnEscuchar7.setOnClickListener(this);
        btnRetorno7 = findViewById(R.id.btnRetorno7);
        btnRetorno7.setOnClickListener(this);
        btnEmergencia7 = findViewById(R.id.btnEmergencia7);
        btnEmergencia7.setOnClickListener(this);
        btnGlosario7 = findViewById(R.id.btnGlosario7);
        btnGlosario7.setOnClickListener(this);
        btnConfReg = findViewById(R.id.btnConfReg);
        btnConfReg.setOnClickListener(this);

        txtVDtNom = findViewById(R.id.txtVDtNom);
        txtVDtNSS = findViewById(R.id.txtVDtNSS);
        txtVDtCURP = findViewById(R.id.txtVDtCURP);
        txtVDtNumFam = findViewById(R.id.txtVDtNumFam);

        nombre = getIntent().getStringExtra("nombre");
        apellidos = getIntent().getStringExtra("apellidos");
        nss = getIntent().getStringExtra("nss");
        curp = getIntent().getStringExtra("curp");
        numFam = getIntent().getStringExtra("numFam");
        nomCompleto = nombre + " " + apellidos;
        txtVDtNom.setText("Nombre: " + nomCompleto);
        txtVDtNSS.setText("NSS: " + nss);
        txtVDtCURP.setText("CURP: " + curp);
        txtVDtNumFam.setText("Num. Familia: " + numFam);
    }

    @Override
    public void onClick(View view) {
        Base admin = new Base(this, "IMSSdbF", null, 1);
        if (view.getId() == R.id.btnMenu7) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta7) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar7) {
            //Nada
        } else if (view.getId() == R.id.btnRetorno7) {
            Intent intentito = new Intent(this, RegistroUsuario.class);
            intentito.putExtra("nombre", nombre);
            intentito.putExtra("apellidos", apellidos);
            intentito.putExtra("nss", nss);
            intentito.putExtra("curp", curp);
            intentito.putExtra("numFam", numFam);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia7) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario7) {
            Intent intentito = new Intent(this, NcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnConfReg) {
            SQLiteDatabase basesita = admin.getWritableDatabase();
            if (nomCompleto.isEmpty() || nss.isEmpty() || curp.isEmpty()){
                Toast.makeText(this, "Falta completar alguno de los campos: nombre, apellido, NSS o CURP", Toast.LENGTH_SHORT).show();
            } else {
                ContentValues registro = new ContentValues();
                registro.put("nombre", nombre);
                registro.put("apellidos", apellidos);
                registro.put("nss", nss);
                registro.put("curp", curp);
                registro.put("numFam1", Long.parseLong(numFam));
                registro.put("numFam2", 0L);
                Apoyo.reiniciarNumFam2();
                long resultado = basesita.insert("Usuarios", null, registro);
                if (resultado != -1) {
                    Toast.makeText(this, "¡Se registró el perfil!", Toast.LENGTH_SHORT).show();
                    txtVDtNom.setText("");
                    txtVDtNSS.setText("");
                    txtVDtCURP.setText("");
                    txtVDtNumFam.setText("");
                    nombre = "";
                    apellidos = "";
                    nss = "";
                    curp = "";
                    numFam = "";
                    nomCompleto = "";
                    Intent intentito = new Intent(this, NcCuenta.class);
                    startActivity(intentito);
                } else {
                    Toast.makeText(this, "Error al registrar el perfil. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
                }
            }
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