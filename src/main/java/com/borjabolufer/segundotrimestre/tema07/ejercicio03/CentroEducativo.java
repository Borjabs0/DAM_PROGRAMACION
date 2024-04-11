package com.borjabolufer.segundotrimestre.tema07.ejercicio03;

import java.util.Arrays;
import java.util.Objects;

public class CentroEducativo {
    private Alumno[] alumnos;
    private final String nombre;
    private int numAlumnos;

    public CentroEducativo(Alumno[] alumno, String nombre, int capacidadIncial) {
        this.nombre = nombre;
        alumnos = new Alumno[capacidadIncial];
        numAlumnos = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public Alumno altaAlumno(String nombre, String apellidos, String fecha, String grupo, String contacto){
        Alumno alumno = new Alumno(nombre, apellidos, fecha, grupo, contacto);
        if (numAlumnos == alumnos.length){
            ampliarArray();
        }
        alumnos[numAlumnos] = alumno;
        numAlumnos++;
        return  alumno;
    }
    public boolean bajaAlumno(String nia){
        int posicion = buscarPosicionAlumnoPorNia(nia);
        if (posicion >= 0){
            alumnos[posicion] = alumnos [numAlumnos - 1];
            alumnos[numAlumnos - 1] = null;
            numAlumnos--;
            return true;
        }
        return false;
    }
    public Alumno[] buscarAlumnosPorGrupo(String grupo){
        //Averiguar cuantos alumnos hay en ese grupo
        int contador = 0;
        Alumno[]resultado = null;
        for (int i = 0; i < numAlumnos; i++){
            if (alumnos[i].getGrupo().equals(grupo))
                contador++;
        }
        if (contador > 0) {
            resultado = new Alumno[contador];
            //Rellenar el array
            contador = 0;
            for (int i = 0; i < numAlumnos; i++) {
                if (alumnos[i].getGrupo().equals(grupo)) {
                    resultado[contador] = alumnos[i];
                    contador++;
                }
            }
        }
        return resultado;
    }
    public Alumno[] buscarAlumnosPorApellidos(String apellidos){
        //Averiguar cuantos alumnos hay en ese grupo
        int contador = 0;
        Alumno[]resultado = null;
        for (int i = 0; i < numAlumnos; i++){
            if (alumnos[i].getApellidos().startsWith(apellidos))
                contador++;
        }
        if (contador > 0) {
            resultado = new Alumno[contador];
            //Rellenar el array
            contador = 0;
            for (int i = 0; i < numAlumnos; i++) {
                if (alumnos[i].getApellidos().startsWith(apellidos)) {
                    resultado[contador] = alumnos[i];
                    contador++;
                }
            }
        }
        return resultado;
    }
    public Alumno buscarAlumnoPorNia(String nia){
        int posicion = buscarPosicionAlumnoPorNia(nia);
            if (posicion >= 0)
                return alumnos[posicion];
            return null;
    }
    public  int buscarPosicionAlumnoPorNia(String nia){
        for (int i = 0; i < numAlumnos; i++){
            if (alumnos[i].getNia().equals(nia)){
                return i;
            }
        }
        return -1;
    }
    private void ampliarArray(){
        Alumno[] arrayAmpliado = new Alumno[alumnos.length * 2];
        for (int i = 0; i < alumnos.length; i++){
            arrayAmpliado[i] = alumnos[i];//El nuevo array apuntara a los mismos objetos que el antiguo array
        }
        alumnos = arrayAmpliado;// El arrayApliado pasa a ser el nuevo array principal
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroEducativo that = (CentroEducativo) o;

        if (numAlumnos != that.numAlumnos) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(alumnos, that.alumnos)) return false;
        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(alumnos);
        result = 31 * result + nombre.hashCode();
        result = 31 * result + numAlumnos;
        return result;
    }

    @Override
    public String toString() {
        return "CentroEducativo{" +
                "alumnos=" + Arrays.toString(alumnos) +
                ", nombre='" + nombre + '\'' +
                ", numAlumnos=" + numAlumnos +
                '}';
    }
}
