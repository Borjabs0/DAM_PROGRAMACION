package com.borjabolufer.segundotrimestre.tema07;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;

public class Paciente {

    public enum Genero{
        HOMBRE, MUJER, OTRO;

        @Override
        public String toString() {
            switch (this){
                case HOMBRE:
                    return "Hombre";
                case MUJER:
                    return "Mujer";
                case OTRO:
                    return "Otro";
            }
            return super.toString();
        }
    }

    private final String sip;
    private final String nombre;
    private final Genero genero;
    private final Date fechaNacimiento;

    public Paciente(String sip, String nombre, Genero genero, Date fechaNacimiento) {
        this.sip = sip;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Paciente(Paciente paciente){
        this.sip = new String(paciente.sip);
        this.nombre = new String(paciente.nombre);
        this.genero = paciente.genero;
        this.fechaNacimiento = new Date(paciente.fechaNacimiento.getTime());
    }
    public String getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        return sip.equals(paciente.sip);
    }
    public int getEdad(){
        LocalDate localDateFechaNacimiento = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();//Obtener edad
        LocalDate localDateActual =  LocalDate.now();
        return Period.between(localDateFechaNacimiento, localDateActual).getYears();
    }
    @Override
    public int hashCode() {
        return sip.hashCode();
    }

    @Override
    public String toString() {
        return "Panciente(" +
                "sip='" + sip + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", fechaNacimiento=" + fechaNacimiento +
                ')';
    }
}
