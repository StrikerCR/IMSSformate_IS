package com.example.imss;

import android.content.Intent;
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

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener {
    Button btnMenu6, btnCuenta6, btnEscuchar6, btnRetorno6, btnEmergencia6, btnGlosario6, btnFinRg;
    EditText rgNombre, rgApellidos, rgNSS, rgCURP, rgNumFam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_usuario);
        btnMenu6 = findViewById(R.id.btnMenu6);
        btnMenu6.setOnClickListener(this);
        btnCuenta6 = findViewById(R.id.btnCuenta6);
        btnCuenta6.setOnClickListener(this);
        btnEscuchar6 = findViewById(R.id.btnEscuchar6);
        btnEscuchar6.setOnClickListener(this);
        btnRetorno6 = findViewById(R.id.btnRetorno6);
        btnRetorno6.setOnClickListener(this);
        btnEmergencia6 = findViewById(R.id.btnEmergencia6);
        btnEmergencia6.setOnClickListener(this);
        btnGlosario6 = findViewById(R.id.btnGlosario6);
        btnGlosario6.setOnClickListener(this);
        btnFinRg = findViewById(R.id.btnFinRg);
        btnFinRg.setOnClickListener(this);

        rgNombre = findViewById(R.id.rgNombre);
        rgApellidos = findViewById(R.id.rgApellidos);
        rgNSS = findViewById(R.id.rgNSS);
        rgCURP = findViewById(R.id.rgCURP);
        rgNumFam = findViewById(R.id.rgNumFam);
        if (!getIntent().getStringExtra( "nombre").isEmpty() || !getIntent().getStringExtra("apellidos").isEmpty() || !getIntent().getStringExtra("nss").isEmpty() || !getIntent().getStringExtra("curp").isEmpty() || !getIntent().getStringExtra("numFam").isEmpty()){
            if (!getIntent().getStringExtra("nombre").isEmpty()) {
                rgNombre.setText(getIntent().getStringExtra("nombre"));
                if (!getIntent().getStringExtra("apellidos").isEmpty()) {
                    rgApellidos.setText(getIntent().getStringExtra("apellidos"));
                    if (!getIntent().getStringExtra("nss").isEmpty()) {
                        rgNSS.setText(getIntent().getStringExtra("nss"));
                        if (!getIntent().getStringExtra("curp").isEmpty()) {
                            rgCURP.setText(getIntent().getStringExtra("curp"));
                            if (!getIntent().getStringExtra("numFam").isEmpty()) {
                                rgNumFam.setText(getIntent().getStringExtra("numFam"));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenu6) {
            Intent intentito = new Intent(this, NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuenta6) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEscuchar6) {
            //Nada
        } else if (view.getId() == R.id.btnRetorno6) {
            Intent intentito = new Intent(this, NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnEmergencia6) {
            //Nada
        } else if (view.getId() == R.id.btnGlosario6) {
            Intent intentito = new Intent(this, NcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnFinRg) {
            String nombre = rgNombre.getText().toString().trim();
            String apellidos = rgApellidos.getText().toString().trim();
            String nss = rgNSS.getText().toString().trim();
            String curp = rgCURP.getText().toString().trim();
            String numFam = rgNumFam.getText().toString().trim();
            if (nombre.isEmpty() || apellidos.isEmpty() || nss.isEmpty() || curp.isEmpty() || numFam.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intentito = new Intent(this, ConfirmaRegistro.class);
            intentito.putExtra("nombre", rgNombre.getText().toString());
            intentito.putExtra("apellidos", rgApellidos.getText().toString());
            intentito.putExtra("nss", rgNSS.getText().toString());
            intentito.putExtra("curp", rgCURP.getText().toString());
            intentito.putExtra("numFam", rgNumFam.getText().toString());
            startActivity(intentito);
        }
    }
}