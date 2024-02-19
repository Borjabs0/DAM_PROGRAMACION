package com.borjabolufer.segundotrimestre.tema07.ejercicio07;

import java.util.Arrays;
import java.util.Date;

public class Atencion {
    private static final int POSICION_TEMPERATURA = 0;
    private static final int POSICION_PPM = 1;
    private static final int POSICION_TENSION_SISTOLICA = 2;
    private static final int POSICION_TENSION_DIASTOLICA = 3;
    private final Date fechaEntrada;
    private final String sintomatologia;
    private double[] preRev;
    private final Paciente paciente;
    private String motivoAlta;
    private Date fechaAlta;

    public Atencion(Paciente paciente, Date fechaEntrada, String sintomatologia) {
        this.paciente = paciente;
        this.fechaEntrada = fechaEntrada;
        this.sintomatologia = sintomatologia;
        preRev = null;
    }

    public Atencion(Atencion atencion){
        this.fechaEntrada = new Date(atencion.fechaEntrada.getTime());
        this.sintomatologia =  new String(atencion.sintomatologia);
        this.paciente = new Paciente(atencion.paciente);

        if (atencion.preRev != null) {
            this.preRev = new double[atencion.preRev.length];
            for (int i = 0; i < preRev.length; i++) {
                preRev[i] = atencion.preRev[i];

            }
        }
        if (atencion.fechaAlta != null) {
            this.fechaAlta = new Date(atencion.fechaAlta.getTime());
        }
        if (atencion.motivoAlta != null) {
            this.motivoAlta = new String(atencion.motivoAlta);
        }

    }

    public boolean isAtendido() {
        return preRev != null;
    }

    public void altaPaciente(Date fechaAlta, String motivoAlta) {
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public String getSintomatologias() {
        return sintomatologia;
    }

    public void setConstantesVitales(double temperatura, double ppm, double tensionSistolica, double tensionDiastolica) {
        preRev = new double[4];
        setTemperatura(temperatura);
        setPPM(ppm);
        setTensionSistolica(tensionSistolica);
        setTensionDiastolica(tensionDiastolica);

    }

    public double getTemperatura() {
        if (preRev == null)
            return -1;
        return preRev[POSICION_TEMPERATURA];
    }

    private void setTemperatura(double temperatura) {
        preRev[POSICION_TEMPERATURA] = temperatura;
    }

    public double getPPM() {
        if (preRev == null)
            return -1;
        return preRev[POSICION_PPM];
    }

    private void setPPM(double ppm) {
        preRev[POSICION_PPM] = ppm;
    }

    public double getTensionSistolica() {
        if (preRev == null)
            return -1;
        return preRev[POSICION_TENSION_SISTOLICA];
    }

    private void setTensionSistolica(double tensionSistolica) {
        preRev[POSICION_TENSION_SISTOLICA] = tensionSistolica;
    }

    public double getTensionDiastolica() {
        if (preRev == null)
            return -1;
        return preRev[POSICION_TENSION_DIASTOLICA];
    }

    private void setTensionDiastolica(double tensionDiastolica) {
        preRev[POSICION_TENSION_DIASTOLICA] = tensionDiastolica;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atencion atencion = (Atencion) o;

        if (!fechaEntrada.equals(atencion.fechaEntrada)) return false;
        return paciente.equals(atencion.paciente);
    }

    @Override
    public int hashCode() {
        int result = fechaEntrada.hashCode();
        result = 31 * result + paciente.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Atencion(" +
                "paciente= " + paciente.getSip() + "" + paciente.getNombre() +
                "fechaEntrada=" + fechaEntrada +
                ", sintomatologia='" + sintomatologia + '\'' +
                ", preRev=" + Arrays.toString(preRev) +
                ", paciente=" + paciente +
                ", motivoAlta='" + motivoAlta + '\'' +
                ", fechaAlta=" + fechaAlta +
                ")\n";
    }
}
