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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ccfraguc extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnMenuF7N2, btnCuentaF7N2, btnRetornoF7N2, btnEscucharF7N2, btnEmergenciaF7N2, btnGlosarioF7N2;
    TextView txtVCP2, txtVDir2;
    Spinner spnOpc2;
    ImageView imgMapa2;
    String [] nombresImg2 = {"SELECIONA OPCION", "UNIDAD DE MEDICINA FAMILIAR (UMF) 10",
            "UMF MAGDALENA DE LAS SALINAS HOSPITAL", "UMF 11 PERALVILLO CLÍNICA",
            "UMF CONJUNTO COLONIA HOSPITAL", "UNIDAD DE MEDICINA FAMILIAR (UMF) 7",
            "HOSPITAL GENERAL DE ZONA (HGZ) 1-A", "HOSPITAL GENERAL DE ZONA (HGZ) 2-A",
            "HOSPITAL GENERAL DE ZONA (HGZ) 8", "HOSPITAL GENERAL DE ZONA (HGZ) 30",
            "HOSPITAL GENERAL DE ZONA (HGZ) 47", "UNIDAD DE MEDICINA FAMILIAR (UMF) 9",
            "UMF 14 AEROPUERTO CLÍNICA", "CSS MERCED CENTRO DE SEGURIDAD SOCIAL",
            "HGZ 48 SAN PEDRO XALPA HOSPITAL", "HGZ 27 TLATELOLCO HOSPITAL",
            "UMF 3 LA JOYA CLÍNICA", "UMF 40 AZCAPOTZALCO CLÍNICA", "UMF 33 ROSARIO CLÍNICA",
            "UMF 94 SAN JUAN ARAGÓN CLÍNICA", "HGP 3A MAGDALENA SALINAS HOSPITAL"};
    ArrayAdapter adaptadito2;
    int numeritoImg2 = 0;
    int userId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ccfraguc, container, false);
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
        btnMenuF7N2 = view.findViewById(R.id.btnMenuF7N2);
        btnMenuF7N2.setOnClickListener(this);
        btnCuentaF7N2 = view.findViewById(R.id.btnCuentaF7N2);
        btnCuentaF7N2.setOnClickListener(this);
        btnEscucharF7N2 = view.findViewById(R.id.btnEscucharF7N2);
        btnEscucharF7N2.setOnClickListener(this);
        btnEmergenciaF7N2 = view.findViewById(R.id.btnEmergenciaF7N2);
        btnEmergenciaF7N2.setOnClickListener(this);
        btnGlosarioF7N2 = view.findViewById(R.id.btnGlosarioF7N2);
        btnGlosarioF7N2.setOnClickListener(this);
        btnRetornoF7N2 = view.findViewById(R.id.btnRetornoF7N2);
        btnRetornoF7N2.setOnClickListener(this);

        txtVCP2 = view.findViewById(R.id.txtVCP2);
        txtVDir2 = view.findViewById(R.id.txtVDir2);

        spnOpc2 = view.findViewById(R.id.spnOpc2);
        adaptadito2 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, nombresImg2);
        imgMapa2 = view.findViewById(R.id.imgMapa2);
        imgMapa2.setOnClickListener(this);
        spnOpc2.setOnItemSelectedListener(this);
        spnOpc2.setAdapter(adaptadito2);

        SQLiteDatabase basesita = admin.getReadableDatabase();
        String query = "SELECT nombre, apellidos, nss, curp, numFam1, numFam2 FROM Usuarios WHERE id = ?";
        Cursor fila = basesita.rawQuery(query, new String[]{String.valueOf(userId)});
        if (fila.moveToFirst()) {
            btnCuentaF7N2.setText(fila.getString(0));
        }
        fila.close();
        basesita.close();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnMenuF7N2) {
            Intent intentito = new Intent(getActivity(), NcMenu.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnCuentaF7N2) {
            Intent intentito = new Intent(getActivity(), NcCuenta.class);
            startActivity(intentito);
        } else if (view.getId() == R.id.btnRetornoF7N2) {
            Navigation.findNavController(view).navigate(R.id.ccfraginicio);
        } else if (view.getId() == R.id.btnEscucharF7N2) {
            //Nada
        } else if (view.getId() == R.id.btnEmergenciaF7N2) {
            //Nada
        } else if (view.getId() == R.id.btnGlosarioF7N2) {
            Intent intentito = new Intent(getActivity(), CcGlosario.class);
            startActivity(intentito);
        }  else if (view.getId() == R.id.imgMapa) {
            if (numeritoImg2 == 1){
                abrirMapa("https://maps.app.goo.gl/tcn5SGFFqBR95RK57");
            } else if (numeritoImg2 == 2) {
                abrirMapa("https://maps.app.goo.gl/fsVm54hrdywTkSxb7");
            } else if (numeritoImg2 == 3) {
                abrirMapa("https://maps.app.goo.gl/2ezZ4S3muQknUtKz6");
            } else if (numeritoImg2 == 4) {
                abrirMapa("https://maps.app.goo.gl/HsUCQo3CtvozG1UCA");
            } else if (numeritoImg2 == 5) {
                abrirMapa("https://maps.app.goo.gl/8yXvykHYS46MzD3z8");
            } else if (numeritoImg2 == 6) {
                abrirMapa("https://maps.app.goo.gl/12m13dahj3mYENgeA");
            } else if (numeritoImg2 == 7) {
                abrirMapa("https://maps.app.goo.gl/pUa5mR48JrsbNySi6");
            } else if (numeritoImg2 == 8) {
                abrirMapa("https://maps.app.goo.gl/PT5jWuqzQLTuiCq99");
            } else if (numeritoImg2 == 9) {
                abrirMapa("https://maps.app.goo.gl/6dk85QSCdmwLDWun6");
            } else if (numeritoImg2 == 10) {
                abrirMapa("https://maps.app.goo.gl/biJFnXRaLbgENMkT6");
            } else if (numeritoImg2 == 11) {
                abrirMapa("https://maps.app.goo.gl/oKKwh5g3jaREX7SbA");
            } else if (numeritoImg2 == 12) {
                abrirMapa("https://maps.app.goo.gl/FmyUAwDu1eo9B9dL6");
            } else if (numeritoImg2 == 13) {
                abrirMapa("https://maps.app.goo.gl/aXEhGhvY8ssfhXFo8");
            } else if (numeritoImg2 == 14) {
                abrirMapa("https://maps.app.goo.gl/LzRAPtjnjCiXXwWi7");
            } else if (numeritoImg2 == 15) {
                abrirMapa("https://maps.app.goo.gl/uSRCfrV2N9rLkx4e8");
            } else if (numeritoImg2 == 16) {
                abrirMapa("https://maps.app.goo.gl/Gd8uffF6RKgNQpmv7");
            } else if (numeritoImg2 == 17) {
                abrirMapa("https://maps.app.goo.gl/jv2RB35gbB1CMFpZ7");
            } else if (numeritoImg2 == 18) {
                abrirMapa("https://maps.app.goo.gl/ibghRojmQHbKbq2e9");
            } else if (numeritoImg2 == 19) {
                abrirMapa("https://maps.app.goo.gl/Mf21T4m8ZEm8c4R66");
            } else if (numeritoImg2 == 20) {
                abrirMapa("https://maps.app.goo.gl/oqSRkv2awdae48PY7");
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cadenita = parent.getItemAtPosition(position).toString();
        if (cadenita.equals("UNIDAD DE MEDICINA FAMILIAR (UMF) 10")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfdiez);
            txtVCP2.setText("3440");
            txtVDir2.setText("CALZADA DE TLALPAN 931 CIUDAD DE MÉXICO, COL. NIÑOS HÉROES, BENITO JUÁREZ");
            numeritoImg2 = 1;
        } else if (cadenita.equals("UMF MAGDALENA DE LAS SALINAS HOSPITAL")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfms);
            txtVCP2.setText("7760");
            txtVDir2.setText("AVENIDA INSTITUTO POLITÉCNICO NACIONAL 1603 GUSTAVO A. MADERO, COL. MAGDALENA DE LAS SALINAS, GUSTAVO A. MADERO");
            numeritoImg2 = 2;
        } else if (cadenita.equals("UMF 11 PERALVILLO CLÍNICA")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfonce);
            txtVCP2.setText("7870");
            txtVDir2.setText("CALLE CARUSO Y LEÓN CAVALO 302 GUSTAVO A. MADERO, COL. NUEVA INDUSTRIAL VALLEJO, GUSTAVO A. MADERO");
            numeritoImg2 = 3;
        } else if (cadenita.equals("UMF CONJUNTO COLONIA HOSPITAL")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfcc);
            txtVCP2.setText("6470");
            txtVDir2.setText("CALLE SULLIVAN S/N CUAUHTÉMOC, COL. SAN RAFAEL, CUAUHTÉMOC");
            numeritoImg2 = 4;
        } else if (cadenita.equals("UNIDAD DE MEDICINA FAMILIAR (UMF) 7")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfsiete);
            txtVCP2.setText("14370");
            txtVDir2.setText("CALZADA DE TLALPAN 4220 CIUDAD DE MÉXICO, COL. SAN LORENZO HUIPULCO, TLALPAN");
            numeritoImg2 = 5;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 1-A")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgzunoa);
            txtVCP2.setText("3300");
            txtVDir2.setText("MUNICIPIO LIBRE 270 CIUDAD DE MÉXICO, COL. PORTALES, BENITO JUÁREZ");
            numeritoImg2 = 6;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 2-A")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgzdosa);
            txtVCP2.setText("8400");
            txtVDir2.setText("AÑIL ESQUINA FRANCISCO DEL PASO Y TRONCOSO 144 CIUDAD DE MÉXICO, COL. GRANJAS MÉXICO, IZTACALCO");
            numeritoImg2 = 7;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 8")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgzocho);
            txtVCP2.setText("1090");
            txtVDir2.setText("AVENIDA RIO MAGDALENA 289 CIUDAD DE MÉXICO, COL. TIZAPAN SAN ANGEL, ÁLVARO OBREGÓN");
            numeritoImg2 = 8;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 30")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgztreinta);
            txtVCP2.setText("8300");
            txtVDir2.setText("PLUTARCO ELÍAS CALLES 473 CIUDAD DE MÉXICO, COL. SANTA ANIITA, IZTACALCO");
            numeritoImg2 = 9;
        } else if (cadenita.equals("HOSPITAL GENERAL DE ZONA (HGZ) 47")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgzcuarentaysiete);
            txtVCP2.setText("9200");
            txtVDir2.setText("CAMPAÑA DEL ÉBANO S/N CIUDAD DE MÉXICO, COL. UNIDAD HABITACIONAL VICENTE GUERRERO, IZTAPALAPA");
            numeritoImg2 = 10;
        } else if (cadenita.equals("UNIDAD DE MEDICINA FAMILIAR (UMF) 9")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfnueve);
            txtVCP2.setText("3800");
            txtVDir2.setText("AVENIDA REVOLUCIÓN Y CALLE 7 S/N CIUDAD DE MÉXICO, COL. SAN PEDRO DE LOS PINOS, BENITO JUÁREZ");
            numeritoImg2 = 11;
        } else if (cadenita.equals("UMF 14 AEROPUERTO CLÍNICA")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfcatorce);
            txtVCP2.setText("15540");
            txtVDir2.setText("BOULEVARD AEROPUERTO 88 VENUSTIANO CARRANZA, COL. SANTA CRUZ AVIACIÓN, VENUSTIANO CARRANZA");
            numeritoImg2 = 12;
        } else if (cadenita.equals("CSS MERCED CENTRO DE SEGURIDAD SOCIAL")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.cssm);
            txtVCP2.setText("6090");
            txtVDir2.setText("SAN PABLO ENTRE TOPACIO Y ROLDÁN 31 S/N CD. DE MÉXICO, COL. CENTRO MERCED, CUAUHTÉMOC");
            numeritoImg2 = 13;
        } else if (cadenita.equals("HGZ 48 SAN PEDRO XALPA HOSPITAL")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgzcuarentayocho);
            txtVCP2.setText("2470");
            txtVDir2.setText("CALLE ELPIDIO CORTEZ 300 AZCAPOTZALCO, COL. AMPLIACIÓN SAN PEDRO XALPA, AZCAPOTZALCO");
            numeritoImg2 = 14;
        } else if (cadenita.equals("HGZ 27 TLATELOLCO HOSPITAL")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgzveintisiete);
            txtVCP2.setText("6900");
            txtVDir2.setText("CALLE LERDO S/N CUAUHTÉMOC, COL. NONOALCO TLATELOLCO, CUAUHTÉMOC");
            numeritoImg2 = 15;
        } else if (cadenita.equals("UMF 3 LA JOYA CLÍNICA")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umftres);
            txtVCP2.setText("7890");
            txtVDir2.setText("CALLE ORIENTE 91 GUSTAVO A. MADERO, COL. LA JOYA, GUSTAVO A. MADERO");
            numeritoImg2 = 16;
        } else if (cadenita.equals("UMF 40 AZCAPOTZALCO CLÍNICA")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfcuarenta);
            txtVCP2.setText("2230");
            txtVDir2.setText("AVENIDA HIDALGO 24 AZCAPOTZALCO, COL. SANTA BÁRBARA, AZCAPOTZALCO");
            numeritoImg2 = 17;
        } else if (cadenita.equals("UMF 33 ROSARIO CLÍNICA")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umftreintaytres);
            txtVCP2.setText("2100");
            txtVDir2.setText("AVENIDA DE LAS CULTURAS S/N AZCAPOTZALCO, COL. EL ROSARIO, AZCAPOTZALCO");
            numeritoImg2 = 18;
        } else if (cadenita.equals("UMF 94 SAN JUAN ARAGÓN CLÍNICA")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.umfnoventaycuatro);
            txtVCP2.setText("7580");
            txtVDir2.setText("AVENIDA CAMINO ANTIGÜO A SAN JUAN DE ARAGÓN 235 GUSTAVO A. MADERO, COL. CASAS ALEMÁN, GUSTAVO A. MADERO");
            numeritoImg2 = 19;
        } else if (cadenita.equals("HGP 3A MAGDALENA SALINAS HOSPITAL")){
            imgMapa2.setVisibility(View.VISIBLE);
            imgMapa2.setImageResource(R.drawable.hgptresa);
            txtVCP2.setText("7760");
            txtVDir2.setText("AVENIDA INSTITUTO POLITÉCNICO NACIONAL S/N GUSTAVO A. MADERO, COL. MAGDALENA DE LAS SALINAS, GUSTAVO A. MADERO");
            numeritoImg2 = 20;
        } else if (cadenita.equals("SELECIONA OPCION")){
            imgMapa2.setVisibility(View.GONE);
            imgMapa2.setImageDrawable(null);
            txtVCP2.setText("");
            txtVDir2.setText("");
            numeritoImg2 = 0;
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