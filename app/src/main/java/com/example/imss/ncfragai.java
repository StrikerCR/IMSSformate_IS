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

public class ncfragai extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ncfragai, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnMenuF5N1, btnCuentaF5N1, btnRetornoF5N1, btnEscucharF5N1, btnEmergenciaF5N1, btnGlosarioF5N1;
        btnMenuF5N1 = view.findViewById(R.id.btnMenuF5N1);
        btnMenuF5N1.setOnClickListener(this);
        btnCuentaF5N1 = view.findViewById(R.id.btnCuentaF5N1);
        btnCuentaF5N1.setOnClickListener(this);
        btnRetornoF5N1 = view.findViewById(R.id.btnRetornoF5N1);
        btnRetornoF5N1.setOnClickListener(this);
        btnEscucharF5N1 = view.findViewById(R.id.btnEscucharF5N1);
        btnEscucharF5N1.setOnClickListener(this);
        btnEmergenciaF5N1 = view.findViewById(R.id.btnEmergenciaF5N1);
        btnEmergenciaF5N1.setOnClickListener(this);
        btnGlosarioF5N1 = view.findViewById(R.id.btnGlosarioF5N1);
        btnGlosarioF5N1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF5N1) {
            Intent intentito = new Intent(getActivity(), NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF5N1) {
            Intent intentito = new Intent(getActivity(), NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF5N1) {
            Navigation.findNavController(view).navigate(R.id.ncfraginicio);
        } else if (view.getId() == R.id.btnEscucharF5N1) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF5N1) {
            //Nada
        } else if (view.getId() == R.id.btnGlosarioF5N1) {
            Intent intentito = new Intent(getActivity(), NcGlosario.class);
            startActivity(intentito);
        }
    }
}