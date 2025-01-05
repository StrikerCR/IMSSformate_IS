package com.example.imss;

import android.content.Intent;
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

public class NcGlosario extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu7, btnCuenta7, btnRetorno7, btnEscuchar7, btnA, btnB, btnC, btnD, btnE, btnF,
            btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnÑ, btnO, btnP, btnQ, btnR, btnS,
            btnT, btnU, btnV, btnW, btnX, btnY, btnZ;
    ScrollView scrollView;
    TextView sectionA, sectionB, sectionC, sectionD, sectionE, sectionF, sectionZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nc_glosario);
        scrollView = findViewById(R.id.scrollView);
        sectionA = findViewById(R.id.sectionA);
        sectionB = findViewById(R.id.sectionB);
        sectionC = findViewById(R.id.sectionC);
        sectionD = findViewById(R.id.sectionD);
        sectionE = findViewById(R.id.sectionE);
        sectionF = findViewById(R.id.sectionF);
        sectionZ = findViewById(R.id.sectionZ);

        btnMenu7 = findViewById(R.id.btnMenu7);
        btnMenu7.setOnClickListener(this);
        btnCuenta7 = findViewById(R.id.btnCuenta7);
        btnCuenta7.setOnClickListener(this);
        btnRetorno7 = findViewById(R.id.btnRetorno7);
        btnRetorno7.setOnClickListener(this);
        btnEscuchar7 = findViewById(R.id.btnEscuchar7);
        btnEscuchar7.setOnClickListener(this);
        btnA = findViewById(R.id.btnA);
        btnA.setOnClickListener(this);
        btnB = findViewById(R.id.btnB);
        btnB.setOnClickListener(this);
        btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(this);
        btnD = findViewById(R.id.btnD);
        btnD.setOnClickListener(this);
        btnE = findViewById(R.id.btnE);
        btnE.setOnClickListener(this);
        btnF = findViewById(R.id.btnF);
        btnF.setOnClickListener(this);
        btnG = findViewById(R.id.btnG);
        btnG.setOnClickListener(this);
        btnH = findViewById(R.id.btnH);
        btnH.setOnClickListener(this);
        btnI = findViewById(R.id.btnI);
        btnI.setOnClickListener(this);
        btnJ = findViewById(R.id.btnJ);
        btnJ.setOnClickListener(this);
        btnK = findViewById(R.id.btnK);
        btnK.setOnClickListener(this);
        btnL = findViewById(R.id.btnL);
        btnL.setOnClickListener(this);
        btnM = findViewById(R.id.btnM);
        btnM.setOnClickListener(this);
        btnN = findViewById(R.id.btnN);
        btnN.setOnClickListener(this);
        btnÑ = findViewById(R.id.btnÑ);
        btnÑ.setOnClickListener(this);
        btnO = findViewById(R.id.btnO);
        btnO.setOnClickListener(this);
        btnP = findViewById(R.id.btnP);
        btnP.setOnClickListener(this);
        btnQ = findViewById(R.id.btnQ);
        btnQ.setOnClickListener(this);
        btnR = findViewById(R.id.btnR);
        btnR.setOnClickListener(this);
        btnS = findViewById(R.id.btnS);
        btnS.setOnClickListener(this);
        btnT = findViewById(R.id.btnT);
        btnT.setOnClickListener(this);
        btnU = findViewById(R.id.btnU);
        btnU.setOnClickListener(this);
        btnV = findViewById(R.id.btnV);
        btnV.setOnClickListener(this);
        btnW = findViewById(R.id.btnW);
        btnW.setOnClickListener(this);
        btnX = findViewById(R.id.btnX);
        btnX.setOnClickListener(this);
        btnY = findViewById(R.id.btnY);
        btnY.setOnClickListener(this);
        btnZ = findViewById(R.id.btnZ);
        btnZ.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu7) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta7) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetorno7) {
            Intent intentito = new Intent(this, MainActivity2.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar7) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnA) {
            scrollToSection(R.id.sectionA);
        } else if (view.getId() == R.id.btnB) {
            scrollToSection(R.id.sectionB);
        } else if (view.getId() == R.id.btnC) {
            scrollToSection(R.id.sectionC);
        } else if (view.getId() == R.id.btnD) {
            scrollToSection(R.id.sectionD);
        } else if (view.getId() == R.id.btnE) {
            scrollToSection(R.id.sectionE);
        } else if (view.getId() == R.id.btnF) {
            scrollToSection(R.id.sectionF);
        } else if (view.getId() == R.id.btnG) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnH) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnI) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnJ) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnK) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnL) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnM) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnN) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnÑ) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnO) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnP) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnQ) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnR) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnS) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnT) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnU) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnV) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnW) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnX) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnY) {
            Toast.makeText(this, "No existe ninguna palabra con esa letra", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnZ) {
            scrollToSection(R.id.sectionZ);
        }
    }
    //Método para desplazarse a una sección específica
    private void scrollToSection(int sectionId) {
        TextView section = findViewById(sectionId);
        if (section != null) {
            scrollView.smoothScrollTo(0, section.getTop());
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