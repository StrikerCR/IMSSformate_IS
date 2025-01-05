package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CcMenu extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu9, btnCuenta9, btnRetorno9, btnEscuchar9, btnSettingsCC, btnHowUseCC, btnContImssCC, btnEmergencia9, btnGlosario9, btnCerrarSCC;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_menu);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu9 = findViewById(R.id.btnMenu9);
        btnMenu9.setOnClickListener(this);
        btnCuenta9 = findViewById(R.id.btnCuenta9);
        btnCuenta9.setOnClickListener(this);
        btnRetorno9 = findViewById(R.id.btnRetorno9);
        btnRetorno9.setOnClickListener(this);
        btnEscuchar9 = findViewById(R.id.btnEscuchar9);
        btnEscuchar9.setOnClickListener(this);
        btnSettingsCC = findViewById(R.id.btnSettingsCC);
        btnSettingsCC.setOnClickListener(this);
        btnHowUseCC = findViewById(R.id.btnHowUseCC);
        btnHowUseCC.setOnClickListener(this);
        btnContImssCC = findViewById(R.id.btnContImssCC);
        btnContImssCC.setOnClickListener(this);
        btnEmergencia9 = findViewById(R.id.btnEmergencia9);
        btnEmergencia9.setOnClickListener(this);
        btnGlosario9 = findViewById(R.id.btnGlosario9);
        btnGlosario9.setOnClickListener(this);
        btnCerrarSCC = findViewById(R.id.btnCerrarSCC);
        btnCerrarSCC.setOnClickListener(this);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta9.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu9) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta9) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno9) {
            Intent intentito = new Intent(this, MainActivity3.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar9) {
            //Nada
        } else if (view.getId() == R.id.btnSettingsCC) {
            Intent intentito = new Intent(this, CcDatosUsuario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnHowUseCC) {
            Intent intentito = new Intent(this, CcAplicacion.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnContImssCC) {
            Intent intentito = new Intent(this, CcContactoImss.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia9) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario9) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCerrarSCC) {
            Intent intentito = new Intent(this, CcCerrarSesion.class);
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