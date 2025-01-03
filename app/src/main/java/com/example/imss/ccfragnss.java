package com.example.imss;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ccfragnss extends Fragment implements View.OnClickListener {
    Button btnMenuF2N2, btnCuentaF2N2, btnRetornoF2N2, btnEscucharF2N2, btnEmergenciaF2N2, btnGlosarioF2N2;
    TextView txtVTramite;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ccfragnss, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnMenuF2N2 = view.findViewById(R.id.btnMenuF2N2);
        btnMenuF2N2.setOnClickListener(this);
        btnCuentaF2N2 = view.findViewById(R.id.btnCuentaF2N2);
        btnCuentaF2N2.setOnClickListener(this);
        btnRetornoF2N2 = view.findViewById(R.id.btnRetornoF2N2);
        btnRetornoF2N2.setOnClickListener(this);
        btnEscucharF2N2 = view.findViewById(R.id.btnEscucharF2N2);
        btnEscucharF2N2.setOnClickListener(this);
        btnEmergenciaF2N2 = view.findViewById(R.id.btnEmergenciaF2N2);
        btnEmergenciaF2N2.setOnClickListener(this);
        btnGlosarioF2N2 = view.findViewById(R.id.btnGlosarioF2N2);
        btnGlosarioF2N2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF2N1) {
            Intent intentito = new Intent(getActivity(), CcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF2N1) {
            Intent intentito = new Intent(getActivity(), CcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF2N1) {
            //
        } else if (view.getId() == R.id.btnEscucharF2N1) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF2N1) {
            //Nada
        } else if (view.getId() == R.id.btnGlosarioF2N1) {
            //Intent intentito = new Intent(getActivity(), CcGlosario.class);
            //startActivity(intentito);
        }
    }
}