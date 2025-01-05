package com.example.imss;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu8, btnCuenta8, btnEscuchar8, btnRetorno8, btnEmergencia8, btnGlosario8, btnEnvIS;
    EditText isNSS, isCURP;
    RadioGroup radGroSatisfaccion;
    RadioButton muyfeliz, feliz, normal, triste, muytriste;
    String nssTemp, curpTemp;
    int emocion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion);
        btnMenu8 = findViewById(R.id.btnMenu8);
        btnMenu8.setOnClickListener(this);
        btnCuenta8 = findViewById(R.id.btnCuenta8);
        btnCuenta8.setOnClickListener(this);
        btnEscuchar8 = findViewById(R.id.btnEscuchar8);
        btnEscuchar8.setOnClickListener(this);
        btnRetorno8 = findViewById(R.id.btnRetorno8);
        btnRetorno8.setOnClickListener(this);
        btnEmergencia8 = findViewById(R.id.btnEmergencia8);
        btnEmergencia8.setOnClickListener(this);
        btnGlosario8 = findViewById(R.id.btnGlosario8);
        btnGlosario8.setOnClickListener(this);
        btnEnvIS = findViewById(R.id.btnEnvIS);
        btnEnvIS.setOnClickListener(this);

        isNSS = findViewById(R.id.isNSS);
        isCURP = findViewById(R.id.isCURP);

        radGroSatisfaccion = findViewById(R.id.radGroSatisfaccion);
        muyfeliz = findViewById(R.id.muyfeliz);
        feliz = findViewById(R.id.feliz);
        normal = findViewById(R.id.normal);
        triste = findViewById(R.id.triste);
        muytriste = findViewById(R.id.muytriste);
    }

    @Override
    public void onClick(View view) {
        Base admin = new Base(this, "IMSSdbF", null, 1);
        if (view.getId() == R.id.btnMenu8) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta8) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar8) {
            //Nada
        } else if (view.getId() == R.id.btnRetorno8) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia8) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario8) {
            Intent intentito = new Intent(this, NcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEnvIS) {
            nssTemp = isNSS.getText().toString().trim();
            curpTemp = isCURP.getText().toString().trim();
            if (nssTemp.isEmpty() || curpTemp.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            SQLiteDatabase basesita = admin.getReadableDatabase();
            String query = "SELECT id, nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE nss = ? AND curp = ?";
            Cursor fila = basesita.rawQuery(query, new String[]{nssTemp, curpTemp});
            if (fila.moveToFirst()) {
                Toast.makeText(this, "Inicio de Sesión Exitoso", Toast.LENGTH_SHORT).show();
                if (muyfeliz.isChecked()) emocion = 1;
                else if (feliz.isChecked()) emocion = 2;
                else if (normal.isChecked()) emocion = 3;
                else if (triste.isChecked()) emocion = 4;
                else if (muytriste.isChecked()) emocion = 5;
                SQLiteDatabase basesitaWritable = admin.getWritableDatabase();
                ContentValues satisfaccionValues = new ContentValues();
                satisfaccionValues.put("satisfac", emocion);
                basesitaWritable.insert("Satisfaccion", null, satisfaccionValues);
                basesitaWritable.close();
                String numId = fila.getString(0);
                Apoyo.modificarId(Integer.parseInt(numId));
                Intent intentito = new Intent(this, MainActivity3.class);
                startActivity(intentito);
            } else {
                Toast.makeText(this, "El NSS o CURP no es correcto o no se encontró en la base de datos", Toast.LENGTH_SHORT).show();
            }
            fila.close();
            basesita.close();
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