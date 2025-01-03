package com.example.imss;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Base extends SQLiteOpenHelper {
    public Base(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase basesita) {
        basesita.execSQL("CREATE TABLE Usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT, nss TEXT, curp TEXT, numFam1 BIGINT, numFam2 BIGINT)");
        basesita.execSQL("create table Clinicas(nombre text primary key, direccion text, cp text, enlace text)");
        basesita.execSQL("INSERT INTO Clinicas (nombre, direccion, cp, enlace) VALUES " +
                "('UNIDAD DE MEDICINA FAMILIAR (UMF) 10', 'CALZADA DE TLALPAN 931 CIUDAD DE MÉXICO, COL. NIÑOS HÉROES, BENITO JUÁREZ', '3440', 'https://maps.app.goo.gl/tcn5SGFFqBR95RK57')," +
                "('UMF MAGDALENA DE LAS SALINAS HOSPITAL', 'AVENIDA INSTITUTO POLITÉCNICO NACIONAL 1603 GUSTAVO A. MADERO, COL. MAGDALENA DE LAS SALINAS, GUSTAVO A. MADERO', '7760', 'https://maps.app.goo.gl/fsVm54hrdywTkSxb7')," +
                "('UMF 11 PERALVILLO CLÍNICA', 'CALLE CARUSO Y LEÓN CAVALO 302 GUSTAVO A. MADERO, COL. NUEVA INDUSTRIAL VALLEJO, GUSTAVO A. MADERO', '7870', 'https://maps.app.goo.gl/2ezZ4S3muQknUtKz6')," +
                "('UMF CONJUNTO COLONIA HOSPITAL', 'CALLE SULLIVAN S/N CUAUHTÉMOC, COL. SAN RAFAEL, CUAUHTÉMOC', '6470', 'https://maps.app.goo.gl/HsUCQo3CtvozG1UCA')," +
                "('UNIDAD DE MEDICINA FAMILIAR (UMF) 7', 'CALZADA DE TLALPAN 4220 CIUDAD DE MÉXICO, COL. SAN LORENZO HUIPULCO, TLALPAN', '14370', 'https://maps.app.goo.gl/8yXvykHYS46MzD3z8')," +
                "('HOSPITAL GENERAL DE ZONA (HGZ) 1-A', 'MUNICIPIO LIBRE 270 CIUDAD DE MÉXICO, COL. PORTALES, BENITO JUÁREZ', '3300', 'https://maps.app.goo.gl/12m13dahj3mYENgeA')," +
                "('HOSPITAL GENERAL DE ZONA (HGZ) 2-A', 'AÑIL ESQUINA FRANCISCO DEL PASO Y TRONCOSO 144 CIUDAD DE MÉXICO, COL. GRANJAS MÉXICO, IZTACALCO', '8400', 'https://maps.app.goo.gl/pUa5mR48JrsbNySi6')," +
                "('HOSPITAL GENERAL DE ZONA (HGZ) 8', 'AVENIDA RIO MAGDALENA 289 CIUDAD DE MÉXICO, COL. TIZAPAN SAN ANGEL, ÁLVARO OBREGÓN', '1090', 'https://maps.app.goo.gl/PT5jWuqzQLTuiCq99')," +
                "('HOSPITAL GENERAL DE ZONA (HGZ) 30', 'PLUTARCO ELÍAS CALLES 473 CIUDAD DE MÉXICO, COL. SANTA ANIITA, IZTACALCO', '8300', 'https://maps.app.goo.gl/6dk85QSCdmwLDWun6')," +
                "('HOSPITAL GENERAL DE ZONA (HGZ) 47', 'CAMPAÑA DEL ÉBANO S/N CIUDAD DE MÉXICO, COL. UNIDAD HABITACIONAL VICENTE GUERRERO, IZTAPALAPA', '9200', 'https://maps.app.goo.gl/biJFnXRaLbgENMkT6')," +
                "('UNIDAD DE MEDICINA FAMILIAR (UMF) 9', 'AVENIDA REVOLUCIÓN Y CALLE 7 S/N CIUDAD DE MÉXICO, COL. SAN PEDRO DE LOS PINOS, BENITO JUÁREZ', '3800', 'https://maps.app.goo.gl/oKKwh5g3jaREX7SbA')," +
                "('UMF 14 AEROPUERTO CLÍNICA', 'BOULEVARD AEROPUERTO 88 VENUSTIANO CARRANZA, COL. SANTA CRUZ AVIACIÓN, VENUSTIANO CARRANZA', '15540', 'https://maps.app.goo.gl/FmyUAwDu1eo9B9dL6')," +
                "('CSS MERCED CENTRO DE SEGURIDAD SOCIAL', 'SAN PABLO ENTRE TOPACIO Y ROLDÁN 31 S/N CD. DE MÉXICO, COL. CENTRO MERCED, CUAUHTÉMOC', '6090', 'https://maps.app.goo.gl/aXEhGhvY8ssfhXFo8')," +
                "('HGZ 48 SAN PEDRO XALPA HOSPITAL', 'CALLE ELPIDIO CORTEZ 300 AZCAPOTZALCO, COL. AMPLIACIÓN SAN PEDRO XALPA, AZCAPOTZALCO', '2470', 'https://maps.app.goo.gl/LzRAPtjnjCiXXwWi7')," +
                "('HGZ 27 TLATELOLCO HOSPITAL', 'CALLE LERDO S/N CUAUHTÉMOC, COL. NONOALCO TLATELOLCO, CUAUHTÉMOC', '6900', 'https://maps.app.goo.gl/uSRCfrV2N9rLkx4e8')," +
                "('UMF 3 LA JOYA CLÍNICA', 'CALLE ORIENTE 91 GUSTAVO A. MADERO, COL. LA JOYA, GUSTAVO A. MADERO', '7890', 'https://maps.app.goo.gl/Gd8uffF6RKgNQpmv7')," +
                "('UMF 40 AZCAPOTZALCO CLÍNICA', 'AVENIDA HIDALGO 24 AZCAPOTZALCO, COL. SANTA BÁRBARA, AZCAPOTZALCO', '2230', 'https://maps.app.goo.gl/jv2RB35gbB1CMFpZ7')," +
                "('UMF 33 ROSARIO CLÍNICA', 'AVENIDA DE LAS CULTURAS S/N AZCAPOTZALCO, COL. EL ROSARIO, AZCAPOTZALCO', '2100', 'https://maps.app.goo.gl/ibghRojmQHbKbq2e9')," +
                "('UMF 94 SAN JUAN ARAGÓN CLÍNICA', 'AVENIDA CAMINO ANTIGÜO A SAN JUAN DE ARAGÓN 235 GUSTAVO A. MADERO, COL. CASAS ALEMÁN, GUSTAVO A. MADERO', '7580', 'https://maps.app.goo.gl/Mf21T4m8ZEm8c4R66')," +
                "('HGP 3A MAGDALENA SALINAS HOSPITAL', 'AVENIDA INSTITUTO POLITÉCNICO NACIONAL S/N GUSTAVO A. MADERO, COL. MAGDALENA DE LAS SALINAS, GUSTAVO A. MADERO', '7760', 'https://maps.app.goo.gl/oqSRkv2awdae48PY7');");
        basesita.execSQL("create table Satisfaccion(id INTEGER PRIMARY KEY AUTOINCREMENT, satisfac INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
