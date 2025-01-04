package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.Navigation;

public class CcGlosario extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu22, btnCuenta22, btnRetorno22, btnEscuchar22, btnA2, btnB2, btnC2, btnD2, btnE2,
            btnF2, btnG2, btnH2, btnI2, btnJ2, btnK2, btnL2, btnM2, btnN2, btnÑ2, btnO2, btnP2,
            btnQ2, btnR2, btnS2, btnT2, btnU2, btnV2, btnW2, btnX2, btnY2, btnZ2, btnEmergencia22, btnGlosario22;
    ScrollView scrollView1;
    TextView sectionA2, sectionB2, sectionC2, sectionD2, sectionE2, sectionF2, sectionZ2;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cc_glosario);
        Base admin = new Base(this, "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(this, "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        scrollView1 = findViewById(R.id.scrollView1);
        sectionA2 = findViewById(R.id.sectionA2);
        sectionB2 = findViewById(R.id.sectionB2);
        sectionC2 = findViewById(R.id.sectionC2);
        sectionD2 = findViewById(R.id.sectionD2);
        sectionE2 = findViewById(R.id.sectionE2);
        sectionF2 = findViewById(R.id.sectionF2);
        sectionZ2 = findViewById(R.id.sectionZ2);

        btnMenu22 = findViewById(R.id.btnMenu22);
        btnMenu22.setOnClickListener(this);
        btnCuenta22 = findViewById(R.id.btnCuenta22);
        btnCuenta22.setOnClickListener(this);
        btnRetorno22 = findViewById(R.id.btnRetorno22);
        btnRetorno22.setOnClickListener(this);
        btnEscuchar22 = findViewById(R.id.btnEscuchar22);
        btnEscuchar22.setOnClickListener(this);
        btnA2 = findViewById(R.id.btnA2);
        btnA2.setOnClickListener(this);
        btnB2 = findViewById(R.id.btnB2);
        btnB2.setOnClickListener(this);
        btnC2 = findViewById(R.id.btnC2);
        btnC2.setOnClickListener(this);
        btnD2 = findViewById(R.id.btnD2);
        btnD2.setOnClickListener(this);
        btnE2 = findViewById(R.id.btnE2);
        btnE2.setOnClickListener(this);
        btnF2 = findViewById(R.id.btnF2);
        btnF2.setOnClickListener(this);
        btnG2 = findViewById(R.id.btnG2);
        btnG2.setOnClickListener(this);
        btnH2 = findViewById(R.id.btnH2);
        btnH2.setOnClickListener(this);
        btnI2 = findViewById(R.id.btnI2);
        btnI2.setOnClickListener(this);
        btnJ2 = findViewById(R.id.btnJ2);
        btnJ2.setOnClickListener(this);
        btnK2 = findViewById(R.id.btnK2);
        btnK2.setOnClickListener(this);
        btnL2 = findViewById(R.id.btnL2);
        btnL2.setOnClickListener(this);
        btnM2 = findViewById(R.id.btnM2);
        btnM2.setOnClickListener(this);
        btnN2 = findViewById(R.id.btnN2);
        btnN2.setOnClickListener(this);
        btnÑ2 = findViewById(R.id.btnÑ2);
        btnÑ2.setOnClickListener(this);
        btnO2 = findViewById(R.id.btnO2);
        btnO2.setOnClickListener(this);
        btnP2 = findViewById(R.id.btnP2);
        btnP2.setOnClickListener(this);
        btnQ2 = findViewById(R.id.btnQ2);
        btnQ2.setOnClickListener(this);
        btnR2 = findViewById(R.id.btnR2);
        btnR2.setOnClickListener(this);
        btnS2 = findViewById(R.id.btnS2);
        btnS2.setOnClickListener(this);
        btnT2 = findViewById(R.id.btnT2);
        btnT2.setOnClickListener(this);
        btnU2 = findViewById(R.id.btnU2);
        btnU2.setOnClickListener(this);
        btnV2 = findViewById(R.id.btnV2);
        btnV2.setOnClickListener(this);
        btnW2 = findViewById(R.id.btnW2);
        btnW2.setOnClickListener(this);
        btnX2 = findViewById(R.id.btnX2);
        btnX2.setOnClickListener(this);
        btnY2 = findViewById(R.id.btnY2);
        btnY2.setOnClickListener(this);
        btnZ2 = findViewById(R.id.btnZ2);
        btnZ2.setOnClickListener(this);
        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuenta22.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu22) {
            Intent intentito = new Intent(this, CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta22) {
            Intent intentito = new Intent(this, CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno22) {
            Intent intentito = new Intent(this, MainActivity3.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar22) {
            //Nada
        } else if (view.getId() == R.id.btnA2) {
            scrollToSection(R.id.sectionA2);
        } else if (view.getId() == R.id.btnB2) {
            scrollToSection(R.id.sectionB2);
        } else if (view.getId() == R.id.btnC2) {
            scrollToSection(R.id.sectionC2);
        } else if (view.getId() == R.id.btnD2) {
            scrollToSection(R.id.sectionD2);
        } else if (view.getId() == R.id.btnE2) {
            scrollToSection(R.id.sectionE2);
        } else if (view.getId() == R.id.btnF2) {
            scrollToSection(R.id.sectionF2);
        } else if (view.getId() == R.id.btnG2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnH2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnI2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnJ2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnK2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnL2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnM2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnN2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnÑ2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnO2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnP2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnQ2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnR2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnS2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnT2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnU2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnV2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnW2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnX2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnY2) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnZ2) {
            scrollToSection(R.id.sectionZ2);
        } if (view.getId() == R.id.btnEmergencia22) {
            //Nada
        } if (view.getId() == R.id.btnGlosario22) {
            Intent intentito = new Intent(this, CcGlosario.class);
            startActivity(intentito);
        }
    }

    private void scrollToSection(int sectionId) {
        TextView section = findViewById(sectionId);
        if (section != null) {
            scrollView1.smoothScrollTo(0, section.getTop());
        }
    }
}