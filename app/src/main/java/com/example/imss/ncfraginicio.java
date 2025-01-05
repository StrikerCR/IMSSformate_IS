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
import android.widget.Toast;

public class ncfraginicio extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ncfraginicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnMenuF1N1, btnCuentaF1N1, btnNSSN1, btnNDHN1, btnSCN1, btnSPN1, btnAIN1, btnUCN1, btnEmergenciaF1N1, btnGlosarioF1N1;
        btnMenuF1N1 = view.findViewById(R.id.btnMenuF1N1);
        btnMenuF1N1.setOnClickListener(this);
        btnCuentaF1N1 = view.findViewById(R.id.btnCuentaF1N1);
        btnCuentaF1N1.setOnClickListener(this);
        btnNSSN1 = view.findViewById(R.id.btnNSSN1);
        btnNSSN1.setOnClickListener(this);
        btnNDHN1 = view.findViewById(R.id.btnNDHN1);
        btnNDHN1.setOnClickListener(this);
        btnSCN1 = view.findViewById(R.id.btnSCN1);
        btnSCN1.setOnClickListener(this);
        btnSPN1 = view.findViewById(R.id.btnSPN1);
        btnSPN1.setOnClickListener(this);
        btnAIN1 = view.findViewById(R.id.btnAIN1);
        btnAIN1.setOnClickListener(this);
        btnUCN1 = view.findViewById(R.id.btnUCN1);
        btnUCN1.setOnClickListener(this);
        btnEmergenciaF1N1 = view.findViewById(R.id.btnEmergenciaF1N1);
        btnEmergenciaF1N1.setOnClickListener(this);
        btnGlosarioF1N1 = view.findViewById(R.id.btnGlosarioF1N1);
        btnGlosarioF1N1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF1N1) {
            Intent intentito = new Intent(getActivity(), NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF1N1) {
            Intent intentito = new Intent(getActivity(), NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnNSSN1) {
            Navigation.findNavController(view).navigate(R.id.ncfragnss);
        } else if (view.getId() == R.id.btnNDHN1) {
            Navigation.findNavController(view).navigate(R.id.ncfragndh);
        } else if (view.getId() == R.id.btnSCN1) {
            Navigation.findNavController(view).navigate(R.id.ncfragsc);
        } else if (view.getId() == R.id.btnSPN1) {
            Navigation.findNavController(view).navigate(R.id.ncfragsp);
        } else if (view.getId() == R.id.btnAIN1) {
            Navigation.findNavController(view).navigate(R.id.ncfragai);
        } else if (view.getId() == R.id.btnUCN1) {
            Navigation.findNavController(view).navigate(R.id.ncfraguc);
        } else if (view.getId() == R.id.btnEmergenciaF1N1) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosarioF1N1) {
            Intent intentito = new Intent(getActivity(), NcGlosario.class);
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