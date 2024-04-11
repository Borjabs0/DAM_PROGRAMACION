package com.borjabolufer.segundotrimestre.tema07.ejercicio7p;


import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class AtencionMedica {
    // Constantes usadas para la validación de datos
    public final static int MIN_TEMPERATURA = 33;
    public final static int MAX_TEMPERATURA = 45;
    public final static int MIN_PPM = 35;
    public final static int MAX_PPM = 230;
    public final static int MIN_TENSION_SISTOLICA = 50;
    public final static int MAX_TENSION_SISTOLICA = 250;
    public final static int MIN_TENSION_DIASTOLICA = 20;
    public final static int MAX_TENSION_DIASTOLICA = 150;

    // Constantes para el acceso a los componentes del array preRev
    public final static int TEMPERATURA = 0;
    public final static int PPM = 1;
    public final static int TENSION_SISTOLICA = 2;
    public final static int TENSION_DIASTOLICA = 3;

    public enum MotivoAlta {
        MEJORA, DERIVACION_HOSPITAL, DEFUNCION;

        @Override
        public String toString() {
            switch (this) {
                case MEJORA:
                    return "Mejora";
                case DERIVACION_HOSPITAL:
                    return "Derivación hospital";
                case DEFUNCION:
                    return "Defunción";
            }
            throw new IllegalArgumentException();
        }

        public static MotivoAlta fromInteger(int x) {
            switch (x) {
                case 0:
                    return MEJORA;
                case 1:
                    return DERIVACION_HOSPITAL;
                case 2:
                    return DEFUNCION;
            }
            return null;
        }

    }
    private final Paciente paciente;
    private final GregorianCalendar fechaEntrada;
    private final String sintomatologia;
    private final float[] preRev;
    private GregorianCalendar fechaAlta;
    private MotivoAlta motivoAlta;
    private boolean atendido;

    private AtencionMedica(Paciente paciente, String sintomatologia, GregorianCalendar fechaEntrada) {
        this.paciente = paciente;
        this.sintomatologia = sintomatologia;
        this.fechaEntrada = fechaEntrada;
        this.fechaAlta = null;
        this.preRev = new float[4];
        this.atendido = false;
    }

    public AtencionMedica(Paciente paciente, String sintomatologia) {
        this(paciente, sintomatologia, new GregorianCalendar());
    }

    public AtencionMedica(Paciente paciente, String sintomatologia, GregorianCalendar fechaEntrada, float temperatura, float ppm, float tenSis, float tenDias, GregorianCalendar fechaAlta, MotivoAlta motivoAlta) {
        this(paciente, sintomatologia, fechaEntrada);
        atender(temperatura, ppm, tenSis, tenDias);
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
        this.atendido = true;
    }

    /**
     * Registra las constantes vitales
     * @param temperatura
     * @param ppm
     * @param tenSis
     * @param tenDias
     * @return
     */
    public boolean atender(float temperatura, float ppm, float tenSis, float tenDias) {
        if (fechaAlta == null) {
            atendido = true;
            this.preRev[TEMPERATURA] = temperatura;
            this.preRev[PPM] = ppm;
            this.preRev[TENSION_SISTOLICA] = tenSis;
            this.preRev[TENSION_DIASTOLICA] = tenDias;
            return true;
        }
        return false;
    }

    /**
     * Da de alta al paciente con el motivo indicado
     * @param motivoAlta
     * @return
     */
    public boolean darAlta(MotivoAlta motivoAlta) {
        if (fechaAlta == null) {
            fechaAlta = new GregorianCalendar();
            this.motivoAlta = motivoAlta;
            return true;
        }
        return false;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public GregorianCalendar getFechaEntrada() {
        return fechaEntrada;
    }

    public String getSintomatologia() {
        return sintomatologia;
    }

    public float getTemperatura() {
        return preRev[TEMPERATURA];
    }

    public float getPpm() {
        return preRev[PPM];
    }

    public float getTensionSistolica() {
        return preRev[TENSION_SISTOLICA];
    }
    public float getTensionDiastolica() {
        return preRev[TENSION_DIASTOLICA];
    }

    public float[] getPreRev() {
        return preRev;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    public MotivoAlta getMotivoAlta() {
        return motivoAlta;
    }

    public boolean isAtendido() {
        return atendido;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        String result = String.format("%10d", paciente.getSip()) + "\t" +
                String.format("%-24s", paciente.getNombre() + " " + paciente.getApellido1()) +
                String.format("%-14s", sdfFecha.format(fechaEntrada.getTime())) +
                String.format("%-6s", sdfHora.format(fechaEntrada.getTime())) +
                String.format("%4d", paciente.getEdad()) + "\t" +
                String.format("%-28s", sintomatologia);
        if (preRev[TEMPERATURA] != 0) {
            result += String.format("%5.1f", preRev[TEMPERATURA]) +
                    String.format("%5.0f", preRev[PPM]) +
                    String.format("%5.0f", preRev[TENSION_SISTOLICA]) +
                    String.format("%5.0f", preRev[TENSION_DIASTOLICA]) + "\t";
        }
        if (fechaAlta != null) {
            result += String.format("%-14s", sdfFecha.format(fechaAlta.getTime())) +
                    String.format("%-8s", sdfHora.format(fechaAlta.getTime())) +
                    String.format("%-12s", motivoAlta);
        }
        return result;
    }
}