package com.borjabolufer.segundotrimestre.tema07;

public class Estadistica {
    private double mediaTemperatura;
    private double mediaPpm;
    private double mediaTensionSistolica;
    private double mediaTensionDiastolica;
    private double mediaEdadPacientes;
    private double porcentajeHombres;

    private double porcentajeMujeres;

    private double porcentajeOtros;

    public Estadistica(Atencion[] atenciones, int numAtenciones) {
        mediaTemperatura = mediaPpm = mediaTensionSistolica = mediaTensionDiastolica = mediaEdadPacientes = porcentajeHombres = porcentajeMujeres = 0;
        int contadorAtenciones = 0;
        for (int i = 0; i < numAtenciones; i++) {
            Atencion atencion = atenciones[i];
            if(atencion.isAtendido()) {
                mediaTemperatura += atencion.getTemperatura();
                mediaPpm += atencion.getPPM();
                mediaTensionSistolica += atencion.getTensionSistolica();
                mediaTensionDiastolica += atencion.getTensionDiastolica();
            }
            mediaEdadPacientes += atencion.getPaciente().getEdad();
            porcentajeMujeres += atencion.getPaciente().getGenero().equals(Paciente.Genero.MUJER) ? 1 : 0;
            porcentajeHombres += atencion.getPaciente().getGenero().equals(Paciente.Genero.HOMBRE) ? 1 : 0;
            porcentajeOtros += atencion.getPaciente().getGenero().equals(Paciente.Genero.OTRO) ? 1 : 0;

            mediaTemperatura = mediaTemperatura / numAtenciones;
            mediaPpm = mediaPpm / contadorAtenciones;
            mediaTensionSistolica = mediaTensionSistolica / contadorAtenciones;
            mediaTensionSistolica = mediaTensionDiastolica / contadorAtenciones;
            double sumaPorcentajes = porcentajeHombres + porcentajeMujeres + porcentajeOtros;
            porcentajeHombres = (porcentajeHombres * 100) / sumaPorcentajes;
            porcentajeMujeres = (porcentajeMujeres * 100) / sumaPorcentajes;
            //Acabar calculo de porcentajes


        }
    }
}
