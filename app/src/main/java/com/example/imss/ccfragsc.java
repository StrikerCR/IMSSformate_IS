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

public class ccfragsc extends Fragment implements View.OnClickListener {
    Button btnMenuF4N2, btnCuentaF4N2, btnEscucharF4N2, btnEmergenciaF4N2, btnGlosarioF4N2, btnRetornoF4N2;
    int userId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ccfragsc, container, false);
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
        btnMenuF4N2 = view.findViewById(R.id.btnMenuF4N2);
        btnMenuF4N2.setOnClickListener(this);
        btnCuentaF4N2 = view.findViewById(R.id.btnCuentaF4N2);
        btnCuentaF4N2.setOnClickListener(this);
        btnEscucharF4N2 = view.findViewById(R.id.btnEscucharF4N2);
        btnEscucharF4N2.setOnClickListener(this);
        btnEmergenciaF4N2 = view.findViewById(R.id.btnEmergenciaF4N2);
        btnEmergenciaF4N2.setOnClickListener(this);
        btnGlosarioF4N2 = view.findViewById(R.id.btnGlosarioF4N2);
        btnGlosarioF4N2.setOnClickListener(this);
        btnRetornoF4N2 = view.findViewById(R.id.btnRetornoF4N2);
        btnRetornoF4N2.setOnClickListener(this);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuentaF4N2.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF4N2) {
            Intent intentito = new Intent(getActivity(), CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF4N2) {
            Intent intent = new Intent(requireContext(), CcCuenta.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnEscucharF4N2) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF4N2) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosarioF4N2) {
            Intent intentito = new Intent(getActivity(), CcGlosario.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF4N2) {
            Navigation.findNavController(view).navigate(R.id.ccfraginicio);
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