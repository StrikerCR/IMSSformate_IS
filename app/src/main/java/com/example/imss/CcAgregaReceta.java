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

public class CcAgregaReceta extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu26, btnCuenta26, btnRetorno26, btnEscuchar26, btnEmergencia26, btnGlosario26, btnagregarRBD;
    EditText txtDiaReceta, txtMesReceta, txtAnoReceta, txtMedicamentoReceta, txtDosisReceta;
    int userId, numeroV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_agrega_receta);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu26 = findViewById(R.id.btnMenu26);
        btnMenu26.setOnClickListener(this);
        btnCuenta26 = findViewById(R.id.btnCuenta26);
        btnCuenta26.setOnClickListener(this);
        btnRetorno26 = findViewById(R.id.btnRetorno26);
        btnRetorno26.setOnClickListener(this);
        btnEscuchar26 = findViewById(R.id.btnEscuchar26);
        btnEscuchar26.setOnClickListener(this);
        btnEmergencia26 = findViewById(R.id.btnEmergencia26);
        btnEmergencia26.setOnClickListener(this);
        btnGlosario26 = findViewById(R.id.btnGlosario26);
        btnGlosario26.setOnClickListener(this);
        btnagregarRBD = findViewById(R.id.btnagregarRBD);
        btnagregarRBD.setOnClickListener(this);

        txtDiaReceta = findViewById(R.id.txtDiaReceta);
        txtMesReceta = findViewById(R.id.txtMesReceta);
        txtAnoReceta = findViewById(R.id.txtAnoReceta);
        txtMedicamentoReceta = findViewById(R.id.txtMedicamentoReceta);
        txtDosisReceta = findViewById(R.id.txtDosisReceta);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta26.setText(fila.getString(0));
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
        if (view.getId() == R.id.btnMenu26) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta26) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno26) {
            Intent intentito = new Intent(this, CcReceta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar26) {
            //Nada
        } else if (view.getId() == R.id.btnagregarRBD) {
            String dia = txtDiaReceta.getText().toString().trim();
            String mes = txtMesReceta.getText().toString().trim();
            String ano = txtAnoReceta.getText().toString().trim();
            String medicamento = txtMedicamentoReceta.getText().toString().trim();
            String dosis = txtDosisReceta.getText().toString().trim();
            if (dia.isEmpty() || mes.isEmpty() || ano.isEmpty() || medicamento.isEmpty() || dosis.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!dia.matches("\\d+") || !mes.matches("\\d+") || !ano.matches("\\d+")) {
                Toast.makeText(this, "Por favor, ingresa valores numéricos válidos para la fecha", Toast.LENGTH_SHORT).show();
                return;
            }
            int diaInt = Integer.parseInt(dia);
            int mesInt = Integer.parseInt(mes);
            int anoInt = Integer.parseInt(ano);
            if (diaInt < 1 || diaInt > 31 || mesInt < 1 || mesInt > 12 || anoInt < 1900 || anoInt > 2100) {
                Toast.makeText(this, "Por favor, ingresa una fecha válida", Toast.LENGTH_SHORT).show();
                return;
            }
            Base admin = new Base(this, "IMSSdbF", null, 1);
            SQLiteDatabase basesita = admin.getWritableDatabase();
            try {
                String countQuery = "SELECT COUNT(*) FROM Recetas WHERE userId = ?";
                Cursor cursor = basesita.rawQuery(countQuery, new String[]{String.valueOf(userId)});
                cursor.moveToFirst();
                int recordCount = cursor.getInt(0);
                cursor.close();
                if (recordCount >= 9) {
                    Toast.makeText(this, "No puedes agregar más de 9 recetas", Toast.LENGTH_SHORT).show();
                    return;
                }
                String insertQuery = "INSERT INTO Recetas(userId, dia, mes, año, medicamento, dosis) VALUES (?, ?, ?, ?, ?, ?)";
                basesita.execSQL(insertQuery, new Object[]{userId, diaInt, mesInt, anoInt, medicamento, dosis});
                txtDiaReceta.setText("");
                txtMesReceta.setText("");
                txtAnoReceta.setText("");
                txtMedicamentoReceta.setText("");
                txtDosisReceta.setText("");
                Toast.makeText(this, "Receta agregada correctamente", Toast.LENGTH_SHORT).show();
                Intent intentito = new Intent(this, CcReceta.class);
                startActivity(intentito);
            } finally {
                basesita.close();
            }
        } else if (view.getId() == R.id.btnEmergencia26) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario26) {
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