package com.example.imss;

public class Apoyo {
    private static int numFam2 = 0;
    private static int numeroId = 0;
    private static int numVacunas = 0;

    public static void incrementarNumFam2(){
        numFam2++;
    }
    public static int obtenerNumFam2() {
        return numFam2;
    }
    public static void reiniciarNumFam2() {
        numFam2 = 0;
    }

    public static void modificarId(int numId){
        numeroId = numId;
    }
    public static int obtenerId(){
        return numeroId;
    }
    public static void reiniciarId(){
        numeroId = 0;
    }

    public static void incrementarNumVacunas(){
        numVacunas++;
    }
    public static int obtenerNumVacunas() {
        return numVacunas;
    }
    public static void reiniciarNumVacunas() {
        numVacunas = 0;
    }
}
