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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ncfraguc extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnMenuF7N1, btnCuentaF7N1, btnRetornoF7N1, btnEscucharF7N1, btnEmergenciaF7N1, btnGlosarioF7N1;
    TextView txtVCP, txtVDir;
    ImageView imgMapa;
    Spinner spnOpc;
    String [] nombresImg = {"SELECIONA OPCION", "UNIDAD DE MEDICINA FAMILIAR (UMF) 10",
            "UMF MAGDALENA DE LAS SALINAS HOSPITAL", "UMF 11 PERALVILLO CLÍNICA",
            "UMF CONJUNTO COLONIA HOSPITAL", "UNIDAD DE MEDICINA FAMILIAR (UMF) 7",
            "HOSPITAL GENERAL DE ZONA (HGZ) 1-A", "HOSPITAL GENERAL DE ZONA (HGZ) 2-A",
            "HOSPITAL GENERAL DE ZONA (HGZ) 8", "HOSPITAL GENERAL DE ZONA (HGZ) 30",
            "HOSPITAL GENERAL DE ZONA (HGZ) 47", "UNIDAD DE MEDICINA FAMILIAR (UMF) 9",
            "UMF 14 AEROPUERTO CLÍNICA", "CSS MERCED CENTRO DE SEGURIDAD SOCIAL",
            "HGZ 48 SAN PEDRO XALPA HOSPITAL", "HGZ 27 TLATELOLCO HOSPITAL",
            "UMF 3 LA JOYA CLÍNICA", "UMF 40 AZCAPOTZALCO CLÍNICA", "UMF 33 ROSARIO CLÍNICA",
            "UMF 94 SAN JUAN ARAGÓN CLÍNICA", "HGP 3A MAGDALENA SALINAS HOSPITAL"};
    ArrayAdapter adaptadito;
    int numeritoImg = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ncfraguc, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnMenuF7N1 = view.findViewById(R.id.btnMenuF7N1);
        btnMenuF7N1.setOnClickListener(this);
        btnCuentaF7N1 = view.findViewById(R.id.btnCuentaF7N1);
        btnCuentaF7N1.setOnClickListener(this);
        btnRetornoF7N1 = view.findViewById(R.id.btnRetornoF7N1);
        btnRetornoF7N1.setOnClickListener(this);
        btnEscucharF7N1 = view.findViewById(R.id.btnEscucharF7N1);
        btnEscucharF7N1.setOnClickListener(this);
        btnEmergenciaF7N1 = view.findViewById(R.id.btnEmergenciaF7N1);
        btnEmergenciaF7N1.setOnClickListener(this);
        btnGlosarioF7N1 = view.findViewById(R.id.btnGlosarioF7N1);
        btnGlosarioF7N1.setOnClickListener(this);

        txtVCP = view.findViewById(R.id.txtVCP);
        txtVDir = view.findViewById(R.id.txtVDir);

        spnOpc = view.findViewById(R.id.spnOpc);
        adaptadito = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, nombresImg);
        imgMapa = view.findViewById(R.id.imgMapa);
        imgMapa.setOnClickListener(this);
        spnOpc.setOnItemSelectedListener(this);
        spnOpc.setAdapter(adaptadito);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF7N1) {
            Intent intentito = new Intent(getActivity(), NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF7N1) {
            Intent intentito = new Intent(getActivity(), NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF7N1) {
            Navigation.findNavController(view).navigate(R.id.ncfraginicio);
        } else if (view.getId() == R.id.btnEscucharF7N1) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF7N1) {
            //Nada
        } else if (view.getId() == R.id.btnGlosarioF7N1) {
            Intent intentito = new Intent(getActivity(), NcGlosario.class);
            startActivity(intentito);
        }  else if (view.getId() == R.id.imgMapa) {
            if (numeritoImg == 1){
                abrirMapa("https://maps.app.goo.gl/tcn5SGFFqBR95RK57");
            } else if (numeritoImg == 2) {
                abrirMapa("https://maps.app.goo.gl/fsVm54hrdywTkSxb7");
            } else if (numeritoImg == 3) {
                abrirMapa("https://maps.app.goo.gl/2ezZ4S3muQknUtKz6");
            } else if (numeritoImg == 4) {
                abrirMapa("https://maps.app.goo.gl/HsUCQo3CtvozG1UCA");
            } else if (numeritoImg == 5) {
                abrirMapa("https://maps.app.goo.gl/8yXvykHYS46MzD3z8");
            } else if (numeritoImg == 6) {
                abrirMapa("https://maps.app.goo.gl/12m13dahj3mYENgeA");
            } else if (numeritoImg == 7) {
                abrirMapa("https://maps.app.goo.gl/pUa5mR48JrsbNySi6");
            } else if (numeritoImg == 8) {
                abrirMapa("https://maps.app.goo.gl/PT5jWuqzQLTuiCq99");
            } else if (numeritoImg == 9) {
                abrirMapa("https://maps.app.goo.gl/6dk85QSCdmwLDWun6");
            } else if (numeritoImg == 10) {
                abrirMapa("https://maps.app.goo.gl/biJFnXRaLbgENMkT6");
            } else if (numeritoImg == 11) {
                abrirMapa("https://maps.app.goo.gl/oKKwh5g3jaREX7SbA");
            } else if (numeritoImg == 12) {
                abrirMapa("https://maps.app.goo.gl/FmyUAwDu1eo9B9dL6");
            } else if (numeritoImg == 13) {
                abrirMapa("https://maps.app.goo.gl/aXEhGhvY8ssfhXFo8");
            } else if (numeritoImg == 14) {
                abrirMapa("https://maps.app.goo.gl/LzRAPtjnjCiXXwWi7");
            } else if (numeritoImg == 15) {
                abrirMapa("https://maps.app.goo.gl/uSRCfrV2N9rLkx4e8");
            } else if (numeritoImg == 16) {
                abrirMapa("https://maps.app.goo.gl/Gd8uffF6RKgNQpmv7");
            } else if (numeritoImg == 17) {
                abrirMapa("https://maps.app.goo.gl/jv2RB35gbB1CMFpZ7");
            } else if (numeritoImg == 18) {
                abrirMapa("https://maps.app.goo.gl/ibghRojmQHbKbq2e9");
            } else if (numeritoImg == 19) {
                abrirMapa("https://maps.app.goo.gl/Mf21T4m8ZEm8c4R66");
            } else if (numeritoImg == 20) {
                abrirMapa("https://maps.app.goo.gl/oqSRkv2awdae48PY7");
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cadenita = parent.getItemAtPosition(position).toString();
        if (cadenita.equals("UNIDAD DE MEDICINA FAMILIAR (UMF) 10")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfdiez);
            txtVCP.setText("3440");
            txtVDir.setText("CALZADA DE TLALPAN 931 CIUDAD DE MÉXICO, COL. NIÑOS HÉROES, BENITO JUÁREZ");
            numeritoImg = 1;
        } else if (cadenita.equals("UMF MAGDALENA DE LAS SALINAS HOSPITAL")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfms);
            txtVCP.setText("7760");
            txtVDir.setText("AVENIDA INSTITUTO POLITÉCNICO NACIONAL 1603 GUSTAVO A. MADERO, COL. MAGDALENA DE LAS SALINAS, GUSTAVO A. MADERO");
            numeritoImg = 2;
        } else if (cadenita.equals("UMF 11 PERALVILLO CLÍNICA")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfonce);
            txtVCP.setText("7870");
            txtVDir.setText("CALLE CARUSO Y LEÓN CAVALO 302 GUSTAVO A. MADERO, COL. NUEVA INDUSTRIAL VALLEJO, GUSTAVO A. MADERO");
            numeritoImg = 3;
        } else if (cadenita.equals("UMF CONJUNTO COLONIA HOSPITAL")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfcc);
            txtVCP.setText("6470");
            txtVDir.setText("CALLE SULLIVAN S/N CUAUHTÉMOC, COL. SAN RAFAEL, CUAUHTÉMOC");
            numeritoImg = 4;
        } else if (cadenita.equals("UNIDAD DE MEDICINA FAMILIAR (UMF) 7")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfsiete);
            txtVCP.setText("14370");
            txtVDir.setText("CALZADA DE TLALPAN 4220 CIUDAD DE MÉXICO, COL. SAN LORENZO HUIPULCO, TLALPAN");
            numeritoImg = 5;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 1-A")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgzunoa);
            txtVCP.setText("3300");
            txtVDir.setText("MUNICIPIO LIBRE 270 CIUDAD DE MÉXICO, COL. PORTALES, BENITO JUÁREZ");
            numeritoImg = 6;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 2-A")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgzdosa);
            txtVCP.setText("8400");
            txtVDir.setText("AÑIL ESQUINA FRANCISCO DEL PASO Y TRONCOSO 144 CIUDAD DE MÉXICO, COL. GRANJAS MÉXICO, IZTACALCO");
            numeritoImg = 7;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 8")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgzocho);
            txtVCP.setText("1090");
            txtVDir.setText("AVENIDA RIO MAGDALENA 289 CIUDAD DE MÉXICO, COL. TIZAPAN SAN ANGEL, ÁLVARO OBREGÓN");
            numeritoImg = 8;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 30")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgztreinta);
            txtVCP.setText("8300");
            txtVDir.setText("PLUTARCO ELÍAS CALLES 473 CIUDAD DE MÉXICO, COL. SANTA ANIITA, IZTACALCO");
            numeritoImg = 9;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 47")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgzcuarentaysiete);
            txtVCP.setText("9200");
            txtVDir.setText("CAMPAÑA DEL ÉBANO S/N CIUDAD DE MÉXICO, COL. UNIDAD HABITACIONAL VICENTE GUERRERO, IZTAPALAPA");
            numeritoImg = 10;
        } else if (cadenita.equals("UNIDAD DE MEDICINA FAMILIAR (UMF) 9")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfnueve);
            txtVCP.setText("3800");
            txtVDir.setText("AVENIDA REVOLUCIÓN Y CALLE 7 S/N CIUDAD DE MÉXICO, COL. SAN PEDRO DE LOS PINOS, BENITO JUÁREZ");
            numeritoImg = 11;
        } else if (cadenita.equals("UMF 14 AEROPUERTO CLÍNICA")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfcatorce);
            txtVCP.setText("15540");
            txtVDir.setText("BOULEVARD AEROPUERTO 88 VENUSTIANO CARRANZA, COL. SANTA CRUZ AVIACIÓN, VENUSTIANO CARRANZA");
            numeritoImg = 12;
        } else if (cadenita.equals("CSS MERCED CENTRO DE SEGURIDAD SOCIAL")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.cssm);
            txtVCP.setText("6090");
            txtVDir.setText("SAN PABLO ENTRE TOPACIO Y ROLDÁN 31 S/N CD. DE MÉXICO, COL. CENTRO MERCED, CUAUHTÉMOC");
            numeritoImg = 13;
        } else if (cadenita.equals("HGZ 48 SAN PEDRO XALPA HOSPITAL")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgzcuarentayocho);
            txtVCP.setText("2470");
            txtVDir.setText("CALLE ELPIDIO CORTEZ 300 AZCAPOTZALCO, COL. AMPLIACIÓN SAN PEDRO XALPA, AZCAPOTZALCO");
            numeritoImg = 14;
        } else if (cadenita.equals("HGZ 27 TLATELOLCO HOSPITAL")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgzveintisiete);
            txtVCP.setText("6900");
            txtVDir.setText("CALLE LERDO S/N CUAUHTÉMOC, COL. NONOALCO TLATELOLCO, CUAUHTÉMOC");
            numeritoImg = 15;
        } else if (cadenita.equals("UMF 3 LA JOYA CLÍNICA")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umftres);
            txtVCP.setText("7890");
            txtVDir.setText("CALLE ORIENTE 91 GUSTAVO A. MADERO, COL. LA JOYA, GUSTAVO A. MADERO");
            numeritoImg = 16;
        } else if (cadenita.equals("UMF 40 AZCAPOTZALCO CLÍNICA")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfcuarenta);
            txtVCP.setText("2230");
            txtVDir.setText("AVENIDA HIDALGO 24 AZCAPOTZALCO, COL. SANTA BÁRBARA, AZCAPOTZALCO");
            numeritoImg = 17;
        } else if (cadenita.equals("UMF 33 ROSARIO CLÍNICA")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umftreintaytres);
            txtVCP.setText("2100");
            txtVDir.setText("AVENIDA DE LAS CULTURAS S/N AZCAPOTZALCO, COL. EL ROSARIO, AZCAPOTZALCO");
            numeritoImg = 18;
        } else if (cadenita.equals("UMF 94 SAN JUAN ARAGÓN CLÍNICA")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.umfnoventaycuatro);
            txtVCP.setText("7580");
            txtVDir.setText("AVENIDA CAMINO ANTIGÜO A SAN JUAN DE ARAGÓN 235 GUSTAVO A. MADERO, COL. CASAS ALEMÁN, GUSTAVO A. MADERO");
            numeritoImg = 19;
        } else if (cadenita.equals("HGP 3A MAGDALENA SALINAS HOSPITAL")){
            imgMapa.setVisibility(View.VISIBLE);
            imgMapa.setImageResource(R.drawable.hgptresa);
            txtVCP.setText("7760");
            txtVDir.setText("AVENIDA INSTITUTO POLITÉCNICO NACIONAL S/N GUSTAVO A. MADERO, COL. MAGDALENA DE LAS SALINAS, GUSTAVO A. MADERO");
            numeritoImg = 20;
        } else if (cadenita.equals("SELECIONA OPCION")){
            imgMapa.setVisibility(View.GONE);
            imgMapa.setImageDrawable(null);
            txtVCP.setText("");
            txtVDir.setText("");
            numeritoImg = 0;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    private void abrirMapa(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse(url));
        if (intent.resolveActivity(requireContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), "No hay una aplicación para abrir este enlace", Toast.LENGTH_SHORT).show();
        }
    }
}