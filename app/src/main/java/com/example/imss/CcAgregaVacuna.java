package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CcAgregaVacuna extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu24, btnCuenta24, btnRetorno24, btnEscuchar24, btnagregarBD, btnEmergencia24, btnGlosario24;
    EditText txtNombreVacuna;
    int userId, numeroV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_agrega_vacuna);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu24 = findViewById(R.id.btnMenu24);
        btnMenu24.setOnClickListener(this);
        btnCuenta24 = findViewById(R.id.btnCuenta24);
        btnCuenta24.setOnClickListener(this);
        btnRetorno24 = findViewById(R.id.btnRetorno24);
        btnRetorno24.setOnClickListener(this);
        btnEscuchar24 = findViewById(R.id.btnEscuchar24);
        btnEscuchar24.setOnClickListener(this);
        btnagregarBD = findViewById(R.id.btnagregarBD);
        btnagregarBD.setOnClickListener(this);
        btnEmergencia24 = findViewById(R.id.btnEmergencia24);
        btnEmergencia24.setOnClickListener(this);
        btnGlosario24 = findViewById(R.id.btnGlosario24);
        btnGlosario24.setOnClickListener(this);
        txtNombreVacuna = findViewById(R.id.txtNombreVacuna);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta24.setText(fila.getString(0));
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
        if (view.getId() == R.id.btnMenu24) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta24) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno24) {
            Intent intentito = new Intent(this, CcEsquemaVacuna.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar24) {
            //Nada
        } else if (view.getId() == R.id.btnagregarBD) {
            Base admin = new Base(this, "IMSSdbF", null, 1);
            SQLiteDatabase basesita = admin.getWritableDatabase();
            String nombreVacuna = txtNombreVacuna.getText().toString().trim();
            if (nombreVacuna.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa el nombre de la vacuna", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                String countQuery = "SELECT COUNT(*) FROM Vacunas WHERE userId = ?";
                Cursor cursor = basesita.rawQuery(countQuery, new String[]{String.valueOf(userId)});
                int count = 0;
                if (cursor.moveToFirst()) {
                    count = cursor.getInt(0);
                }
                cursor.close();
                if (count < 8) {
                    String query = "INSERT INTO Vacunas(userId, vacuna) VALUES (?, ?)";
                    basesita.execSQL(query, new Object[]{userId, nombreVacuna});
                    Toast.makeText(this, "Vacuna agregada correctamente!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Lo sentimos, hasta ahora solo podemos tener 4 vacunas", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Error al agregar la vacuna: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            } finally {
                basesita.close();
            }
            Intent intentito = new Intent(this, CcEsquemaVacuna.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia24) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario24) {
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