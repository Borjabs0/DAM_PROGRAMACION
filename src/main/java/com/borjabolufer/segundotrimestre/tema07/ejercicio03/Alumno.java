package com.borjabolufer.segundotrimestre.tema07.ejercicio03;

import java.util.Objects;

public class Alumno {
    private static long autoincrement = 0;
    private final String nia;
    private final String nombre;
    private final String apellidos;
    private final String fechaNacimento;
    private final String grupo;
    private final String contacto;

    public Alumno(Alumno alumno){
        this(alumno.getNombre(), alumno.getApellidos(), alumno.getFechaNacimento(), alumno.getGrupo(), alumno.getContacto());
    }

    public Alumno(String nombre, String apellidos, String fechaNacimento, String grupo, String contacto) {
        this.nia = String.format("%07d",++autoincrement);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimento = fechaNacimento;
        this.grupo = grupo;
        this.contacto = contacto;
    }


    public String getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimento() {
        return fechaNacimento;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getContacto() {
        return contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (!nia.equals(alumno.nia)) return false;
        if (!nombre.equals(alumno.nombre)) return false;
        if (!apellidos.equals(alumno.apellidos)) return false;
        if (!fechaNacimento.equals(alumno.fechaNacimento)) return false;
        if (!grupo.equals(alumno.grupo)) return false;
        return contacto.equals(alumno.contacto);
    }

    @Override
    public int hashCode() {
        int result = nia.hashCode();
        result = 31 * result + nombre.hashCode();
        result = 31 * result + apellidos.hashCode();
        result = 31 * result + fechaNacimento.hashCode();
        result = 31 * result + grupo.hashCode();
        result = 31 * result + contacto.hashCode();
        return result;
    }
}
