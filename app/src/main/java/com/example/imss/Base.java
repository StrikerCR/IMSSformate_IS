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
        basesita.execSQL("create table Vacunas(id INTEGER PRIMARY KEY AUTOINCREMENT, userId INTEGER NOT NULL, vacuna TEXT)");
        basesita.execSQL("INSERT INTO Vacunas(userId, vacuna) VALUES " +
                "(1, 'BCG'), " +
                "(1, 'Hepatitis B'), " +
                "(1, 'Pentavalente acelular'), " +
                "(1, 'Neumococo'), " +
                "(2, 'Rotavirus'), " +
                "(2, 'SRP'), " +
                "(2, 'SR'), " +
                "(2, 'Td'), " +
                "(3, 'Hepatitis A'), " +
                "(3, 'Fiebre amarilla'), " +
                "(3, 'Tifoidea'), " +
                "(3, 'Varicela'), " +
                "(4, 'SRP'), " +
                "(4, 'Influenza'), " +
                "(4, 'Hepatitis A'), " +
                "(4, 'BCG'), " +
                "(5, 'COVID-19 Pfizer'), " +
                "(5, 'Hepatitis B'), " +
                "(5, 'Sarampión'), " +
                "(5, 'Rubeola')");
        basesita.execSQL("create table HistorialClinico(id INTEGER PRIMARY KEY AUTOINCREMENT, userId INTEGER NOT NULL, dia INTEGER, mes INTEGER, año INTEGER, titulo TEXT, descripcion TEXT, solucion TEXT)");
        basesita.execSQL("INSERT INTO HistorialClinico(userId, dia, mes, año, titulo, descripcion, solucion) VALUES " +
                "(1, 8, 3, 2024, 'Hospitalización en UMF 2', 'Ataque al miocardio', 'Estancia: 7 días'), " +
                "(1, 29, 2, 2024, 'Detección de cáncer de próstata', 'Fase: Etapa II', 'Tratamiento: Inyección'), " +
                "(1, 18, 12, 2023, 'Detección de COVID-19', 'Tratamiento: Inyección Sputnik', 'Estancia: Cuarentena'), " +
                "(1, 15, 5, 2022, 'Cirugía de apéndice', 'Apéndice inflamado retirado quirúrgicamente', 'Estancia: 3 días'), " +
                "(1, 22, 11, 2021, 'Vacunación contra la influenza', 'Aplicación de vacuna trivalente', 'Seguimiento: Ninguno requerido'), " +
                "(2, 5, 6, 2023, 'Chequeo general', 'Examenes rutinarios', 'Seguimiento: Ninguno requerido'), " +
                "(2, 12, 8, 2022, 'Tratamiento de hipertensión', 'Inicio de medicación antihipertensiva', 'Revisión anual'), " +
                "(2, 25, 10, 2022, 'Infección urinaria', 'Antibióticos prescritos', 'Seguimiento: Ninguno'), " +
                "(2, 1, 12, 2021, 'Vacunación COVID-19', 'Primera dosis aplicada', 'Segunda dosis programada'), " +
                "(2, 20, 3, 2021, 'Fractura de muñeca', 'Fractura reparada con inmovilización', 'Rehabilitación completada'), " +
                "(3, 15, 4, 2023, 'Tratamiento de diabetes', 'Inicio de insulina diaria', 'Revisión mensual'), " +
                "(3, 18, 11, 2022, 'Detección de anemia', 'Bajos niveles de hemoglobina detectados', 'Tratamiento con suplementos de hierro'), " +
                "(3, 30, 1, 2022, 'Cirugía de cataratas', 'Cirugía exitosa en ojo izquierdo', 'Seguimiento en 1 mes'), " +
                "(3, 22, 5, 2021, 'Neumonía', 'Tratamiento con antibióticos', 'Seguimiento completado'), " +
                "(3, 10, 7, 2020, 'Accidente doméstico', 'Corte profundo en mano suturado', 'Estancia: Ninguna'), " +
                "(4, 2, 2, 2023, 'Chequeo cardiovascular', 'Examen rutinario del corazón', 'Seguimiento anual recomendado'), " +
                "(4, 14, 7, 2022, 'Reacción alérgica', 'Urticaria severa tratada', 'Prescripción de antihistamínicos'), " +
                "(4, 9, 9, 2021, 'Vacunación contra influenza', 'Dosis anual aplicada', 'Seguimiento: Ninguno'), " +
                "(4, 28, 3, 2020, 'Hospitalización por accidente vehicular', 'Fractura de fémur tratada', 'Rehabilitación requerida'), " +
                "(4, 19, 6, 2019, 'Tratamiento de gastritis', 'Recetado inhibidor de ácido', 'Seguimiento opcional'), " +
                "(5, 17, 8, 2023, 'Chequeo prenatal', 'Exámenes rutinarios', 'Próxima cita en 1 mes'), " +
                "(5, 23, 11, 2022, 'Infección respiratoria', 'Tratamiento con nebulización', 'Seguimiento en 1 semana'), " +
                "(5, 6, 4, 2022, 'Hospitalización por apendicitis', 'Cirugía de emergencia', 'Estancia: 4 días'), " +
                "(5, 12, 10, 2021, 'Tratamiento de migraña', 'Inicio de medicación', 'Control periódico'), " +
                "(5, 1, 1, 2020, 'Vacunación contra tétanos', 'Vacuna aplicada por cortadura', 'Seguimiento completado')");
        basesita.execSQL("create table Recetas(id INTEGER PRIMARY KEY AUTOINCREMENT, userId INTEGER NOT NULL, dia INTEGER, mes INTEGER, año INTEGER, medicamento TEXT, dosis TEXT)");
        basesita.execSQL("INSERT INTO Recetas(userId, dia, mes, año, medicamento, dosis) VALUES " +
                "(1, 5, 1, 2024, 'Paracetamol', '500mg cada 8 horas'), " +
                "(1, 10, 1, 2024, 'Amoxicilina', '500mg cada 12 horas'), " +
                "(1, 15, 1, 2024, 'Ibuprofeno', '400mg cada 8 horas'), " +
                "(1, 20, 1, 2024, 'Metformina', '850mg una vez al día'), " +
                "(1, 25, 1, 2024, 'Losartán', '50mg una vez al día'), " +
                "(2, 2, 2, 2024, 'Cefalexina', '500mg cada 6 horas'), " +
                "(2, 7, 2, 2024, 'Clorfenamina', '4mg cada 8 horas'), " +
                "(2, 12, 2, 2024, 'Diclofenaco', '75mg cada 12 horas'), " +
                "(2, 17, 2, 2024, 'Loratadina', '10mg una vez al día'), " +
                "(2, 22, 2, 2024, 'Omeprazol', '20mg en ayunas'), " +
                "(3, 3, 3, 2024, 'Salbutamol', '100mcg cada 6 horas'), " +
                "(3, 8, 3, 2024, 'Prednisona', '50mg una vez al día'), " +
                "(3, 13, 3, 2024, 'Azitromicina', '500mg una vez al día por 3 días'), " +
                "(3, 18, 3, 2024, 'Acetaminofén', '500mg cada 8 horas'), " +
                "(3, 23, 3, 2024, 'Vitamina D', '400 UI al día'), " +
                "(4, 4, 4, 2024, 'Insulina glargina', '10 unidades subcutánea al día'), " +
                "(4, 9, 4, 2024, 'Furosemida', '40mg cada 12 horas'), " +
                "(4, 14, 4, 2024, 'Atorvastatina', '20mg por la noche'), " +
                "(4, 19, 4, 2024, 'Carbamazepina', '200mg cada 12 horas'), " +
                "(4, 24, 4, 2024, 'Enalapril', '10mg cada 12 horas'), " +
                "(5, 5, 5, 2024, 'Captopril', '25mg cada 8 horas'), " +
                "(5, 10, 5, 2024, 'Metoprolol', '50mg dos veces al día'), " +
                "(5, 15, 5, 2024, 'Glucosamina', '1500mg una vez al día'), " +
                "(5, 20, 5, 2024, 'Montelukast', '10mg por la noche'), " +
                "(5, 25, 5, 2024, 'Clopidogrel', '75mg una vez al día')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
