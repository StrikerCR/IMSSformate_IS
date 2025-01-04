package com.example.imss;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ccfraginicio extends Fragment implements View.OnClickListener {
    Button btnMenuF1N2, btnCuentaF1N2, btnEscucharF1N2, btnNSSN2, btnNDHN2, btnSCN2, btnSPN2, btnAIN2, btnUCN2, btnEmergenciaF1N2, btnGlosarioF1N2;
    int userId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ccfraginicio, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Base admin = new Base(requireContext(), "IMSSdbF", null, 1);
        userId = Apoyo.obtenerId();
        if (userId == 0) {
            Toast.makeText(requireContext(), "No se recibió el ID del usuario", Toast.LENGTH_SHORT).show();
            return;
        }

        btnMenuF1N2 = view.findViewById(R.id.btnMenuF1N2);
        btnMenuF1N2.setOnClickListener(this);
        btnCuentaF1N2 = view.findViewById(R.id.btnCuentaF1N2);
        btnCuentaF1N2.setOnClickListener(this);
        btnEscucharF1N2 = view.findViewById(R.id.btnEscucharF1N2);
        btnEscucharF1N2.setOnClickListener(this);
        btnNSSN2 = view.findViewById(R.id.btnNSSN2);
        btnNSSN2.setOnClickListener(this);
        btnNDHN2 = view.findViewById(R.id.btnNDHN2);
        btnNDHN2.setOnClickListener(this);
        btnSCN2 = view.findViewById(R.id.btnSCN2);
        btnSCN2.setOnClickListener(this);
        btnSPN2 = view.findViewById(R.id.btnSPN2);
        btnSPN2.setOnClickListener(this);
        btnAIN2 = view.findViewById(R.id.btnAIN2);
        btnAIN2.setOnClickListener(this);
        btnUCN2 = view.findViewById(R.id.btnUCN2);
        btnUCN2.setOnClickListener(this);
        btnEmergenciaF1N2 = view.findViewById(R.id.btnEmergenciaF1N2);
        btnEmergenciaF1N2.setOnClickListener(this);
        btnGlosarioF1N2 = view.findViewById(R.id.btnGlosarioF1N2);
        btnGlosarioF1N2.setOnClickListener(this);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuentaF1N2.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF1N2) {
            Intent intentito = new Intent(getActivity(), CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF1N2) {
            Intent intent = new Intent(requireContext(), CcCuenta.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnEscucharF1N2) {
            //Nada
        } else if (view.getId() == R.id.btnNSSN2) {
            Navigation.findNavController(view).navigate(R.id.ccfragnss);
        } else if (view.getId() == R.id.btnNDHN2) {
            Navigation.findNavController(view).navigate(R.id.ccfragndh);
        } else if (view.getId() == R.id.btnSCN2) {
            Navigation.findNavController(view).navigate(R.id.ccfragsc);
        } else if (view.getId() == R.id.btnSPN2) {
            Navigation.findNavController(view).navigate(R.id.ccfragsp);
        } else if (view.getId() == R.id.btnAIN2) {
            Navigation.findNavController(view).navigate(R.id.ccfragai);
        } else if (view.getId() == R.id.btnUCN2) {
            Navigation.findNavController(view).navigate(R.id.ccfraguc);
        } else if (view.getId() == R.id.btnEmergenciaF1N2) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosarioF1N2) {
            Intent intentito = new Intent(getActivity(), CcGlosario.class);
            startActivity(intentito);
        }
    }
    private void abrirMarcador(String numero) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(android.net.Uri.parse("tel:" + numero));
        if (intent.resolveActivity(requireContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(requireContext(), "No hay una aplicación para realizar llamadas", Toast.LENGTH_SHORT).show();
        }
    }
}