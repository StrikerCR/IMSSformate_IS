package com.example.imss;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ncfragnss extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ncfragnss, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnMenuF2N1, btnCuentaF2N1, btnRetornoF2N1, btnEscucharF2N1, btnEmergenciaF2N1, btnGlosarioF2N1;
        btnMenuF2N1 = view.findViewById(R.id.btnMenuF2N1);
        btnMenuF2N1.setOnClickListener(this);
        btnCuentaF2N1 = view.findViewById(R.id.btnCuentaF2N1);
        btnCuentaF2N1.setOnClickListener(this);
        btnRetornoF2N1 = view.findViewById(R.id.btnRetornoF2N1);
        btnRetornoF2N1.setOnClickListener(this);
        btnEscucharF2N1 = view.findViewById(R.id.btnEscucharF2N1);
        btnEscucharF2N1.setOnClickListener(this);
        btnEmergenciaF2N1 = view.findViewById(R.id.btnEmergenciaF2N1);
        btnEmergenciaF2N1.setOnClickListener(this);
        btnGlosarioF2N1 = view.findViewById(R.id.btnGlosarioF2N1);
        btnGlosarioF2N1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF2N1) {
            Intent intentito = new Intent(getActivity(), NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF2N1) {
            Intent intentito = new Intent(getActivity(), NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF2N1) {
            Navigation.findNavController(view).navigate(R.id.ncfraginicio);
        } else if (view.getId() == R.id.btnEscucharF2N1) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF2N1) {
            //Nada
        } else if (view.getId() == R.id.btnGlosarioF2N1) {
            Intent intentito = new Intent(getActivity(), NcGlosario.class);
            startActivity(intentito);
        }
    }
}