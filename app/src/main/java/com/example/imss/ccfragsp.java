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
import android.widget.Toast;

public class ccfragsp extends Fragment implements View.OnClickListener {
    Button btnMenuF6N2, btnCuentaF6N2, btnEscucharF6N2, btnEmergenciaF6N2, btnGlosarioF6N2, btnRetornoF6N2;
    int userId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ccfragsp, container, false);
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
        btnMenuF6N2 = view.findViewById(R.id.btnMenuF6N2);
        btnMenuF6N2.setOnClickListener(this);
        btnCuentaF6N2 = view.findViewById(R.id.btnCuentaF6N2);
        btnCuentaF6N2.setOnClickListener(this);
        btnEscucharF6N2 = view.findViewById(R.id.btnEscucharF6N2);
        btnEscucharF6N2.setOnClickListener(this);
        btnEmergenciaF6N2 = view.findViewById(R.id.btnEmergenciaF6N2);
        btnEmergenciaF6N2.setOnClickListener(this);
        btnGlosarioF6N2 = view.findViewById(R.id.btnGlosarioF6N2);
        btnGlosarioF6N2.setOnClickListener(this);
        btnRetornoF6N2 = view.findViewById(R.id.btnRetornoF6N2);
        btnRetornoF6N2.setOnClickListener(this);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuentaF6N2.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF6N2) {
            Intent intentito = new Intent(getActivity(), CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF6N2) {
            Intent intent = new Intent(requireContext(), CcCuenta.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnEscucharF6N2) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF6N2) {
            //Nada
        } else if (view.getId() == R.id.btnGlosarioF6N2) {
            Intent intentito = new Intent(getActivity(), CcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF6N2) {
            Navigation.findNavController(view).navigate(R.id.ccfraginicio);
        }
    }
}