package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CcGeneracionCita extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu23, btnCuenta23, btnRetorno23, btnEscuchar23, btnEmergencia23, btnGlosario23;
    ImageView googleplayAppImss1, googleplayAppImss2;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_generacion_cita);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        btnMenu23 = findViewById(R.id.btnMenu23);
        btnMenu23.setOnClickListener(this);
        btnCuenta23 = findViewById(R.id.btnCuenta23);
        btnCuenta23.setOnClickListener(this);
        btnRetorno23 = findViewById(R.id.btnRetorno23);
        btnRetorno23.setOnClickListener(this);
        btnEscuchar23 = findViewById(R.id.btnEscuchar23);
        btnEscuchar23.setOnClickListener(this);
        btnEmergencia23 = findViewById(R.id.btnEmergencia23);
        btnEmergencia23.setOnClickListener(this);
        btnGlosario23 = findViewById(R.id.btnGlosario23);
        btnGlosario23.setOnClickListener(this);

        googleplayAppImss1 = findViewById(R.id.googleplayAppImss1);
        googleplayAppImss1.setOnClickListener(this);
        googleplayAppImss2 = findViewById(R.id.googleplayAppImss2);
        googleplayAppImss2.setOnClickListener(this);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta23.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu23) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta23) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno23) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar23) {
            //Nada
        } else if (view.getId() == R.id.btnEmergencia23) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosario23) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.googleplayAppImss1) {
            abrirURL("https://play.google.com/store/apps/details?id=st.android.imsspublico");
        } else if (view.getId() == R.id.googleplayAppImss2) {
            abrirURL("https://play.google.com/store/apps/details?id=st.android.imsspublico");
        }
    }
    private void abrirURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse(url));
        if (intent.resolveActivity(this.getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No hay una aplicación para abrir este enlace", Toast.LENGTH_SHORT).show();
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