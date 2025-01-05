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

public class ncfragsp extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ncfragsp, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnMenuF6N1, btnCuentaF6N1, btnRetornoF6N1, btnEscucharF6N1, btnEmergenciaF6N1, btnGlosarioF6N1;
        btnMenuF6N1 = view.findViewById(R.id.btnMenuF6N1);
        btnMenuF6N1.setOnClickListener(this);
        btnCuentaF6N1 = view.findViewById(R.id.btnCuentaF6N1);
        btnCuentaF6N1.setOnClickListener(this);
        btnRetornoF6N1 = view.findViewById(R.id.btnRetornoF6N1);
        btnRetornoF6N1.setOnClickListener(this);
        btnEscucharF6N1 = view.findViewById(R.id.btnEscucharF6N1);
        btnEscucharF6N1.setOnClickListener(this);
        btnEmergenciaF6N1 = view.findViewById(R.id.btnEmergenciaF6N1);
        btnEmergenciaF6N1.setOnClickListener(this);
        btnGlosarioF6N1 = view.findViewById(R.id.btnGlosarioF6N1);
        btnGlosarioF6N1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF6N1) {
            Intent intentito = new Intent(getActivity(), NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF6N1) {
            Intent intentito = new Intent(getActivity(), NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF6N1) {
            Navigation.findNavController(view).navigate(R.id.ncfraginicio);
        } else if (view.getId() == R.id.btnEscucharF6N1) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF6N1) {
            abrirMarcador("911");
        } else if (view.getId() == R.id.btnGlosarioF6N1) {
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