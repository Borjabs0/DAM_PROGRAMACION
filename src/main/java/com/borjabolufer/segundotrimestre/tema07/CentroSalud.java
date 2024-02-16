package com.borjabolufer.segundotrimestre.tema07;

import net.datafaker.Faker;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class CentroSalud {

    private  final Paciente[] pacientes;//array que crece
    private int numPacientes;
    private  final Atencion[] atenciones; //array fijo
    private  int numAtenciones;
    private static Random rnd = new Random();


   public CentroSalud(int capacidadInicialPacientes, int capacidaInicialAtenciones){
       pacientes = new Paciente[capacidadInicialPacientes];
       numPacientes = 0;
       atenciones = new Atencion[capacidaInicialAtenciones];
       numAtenciones = 0;
       if (Config.DEBUG) {
           generarDatosAleatorios(40, 80);

       }
   }

    private void generarDatosAleatorios(int cantidadPacientes, int cantidadAtenciones) {
       generarDatosPaciente(cantidadPacientes);
       generarAtencionesAleatorias(cantidadAtenciones);

    }
    public void generarDatosPaciente(int cantidadPacientes){
       Faker faker= new Faker(new Locale("es","ES"));
       for (int i = 0; i < cantidadPacientes; i++) {
           String sip = String.format("%05d", (i + 1));
           String nombre = faker.name().fullName().toString();
           Paciente.Genero[] valores = Paciente.Genero.values();
           Paciente.Genero genero = valores[faker.random().nextInt(0, valores.length - 1)];
           Date fechaNacimiento =  faker.date().birthday(0, 99);

           pacientes[numPacientes] = new Paciente(sip, nombre, genero, fechaNacimiento);
           numPacientes++;

          /* if (cantidadPacientes[i].getSip() == sip) {
               System.out.println("Paciente existente");
               return cantidadPAcientes[i];
           }else if (cantidadPAcientes[i] == null){
               Paciente paciente = new Paciente(sip, nombre, genero, fechaNacimiento);
               cantidadPAcientes[i] = paciente;
               altaPaciente  = paciente;
               return paciente;
           }
*/
       }

    }



    private void generarAtencionesAleatorias(int cantidadAtenciones){
        Faker faker= new Faker(new Locale("es","ES"));
        for (int i = 0; i < cantidadAtenciones; i++) {
            Date fechaEntrada = faker.date().past(30, 0, TimeUnit.DAYS);
            String sintomatologia = faker.medical().symptoms();
            Paciente paciente = pacientes[faker.random().nextInt(0, numPacientes - 1)];
            Atencion atencion = new Atencion(paciente, fechaEntrada, sintomatologia);
            if (faker.random().nextInt(100) > 100 - 40) {
                double temperatura = faker.random().nextDouble(35, 41);
                double ppm = faker.random().nextDouble(50, 110);
                double tensionSistolica = faker.random().nextDouble(50, 150);
                double tensionDiastolica = faker.random().nextDouble(50, 150);
                atencion.setConstantesVitales(temperatura, ppm, tensionDiastolica, tensionSistolica);
                if (faker.random().nextInt(100) > 100 - 40) {//personas de alta
                    Date fechaAlta = fechaEntrada;
                    String motivoAlta = faker.medical().diagnosisCode();
                    atencion.altaPaciente(fechaAlta, motivoAlta);
                }
            }
            atenciones[numAtenciones] = atencion;
            numAtenciones++;
            }
        }
        public Paciente buscarPacientePorSip(String sip){
            for (int i = 0; i < numPacientes; i++) {
                if (pacientes[i].getSip().equals(sip)){
                    return pacientes[i];
                }
            }
            return null;
        }

public  Paciente nuevoPaciente(String sip, String nombre, Paciente.Genero genero , Date fechaNacimiento){
       if (buscarPacientePorSip(sip) != null)
           return null;
       Paciente paciente = new Paciente(sip, nombre, genero, fechaNacimiento);
       pacientes[numPacientes] = paciente;
       numPacientes++;
       return paciente;
}

    public Atencion buscarAtencionPaciente(String sip, boolean atendido) {
        for (int i = 0; i < numAtenciones; i++) {
            Paciente paciente = atenciones[i].getPaciente();
            if (atenciones[i].isAtendido() && paciente.getSip().equals(sip)) {
                return atenciones[i];
            }
        }
        return null;
    }
public boolean atenderPaciente(String sip, double temperatura, double ppm, double tensionSistolica, double tensionDiastolica){
       Atencion atencion = buscarAtencionPaciente(sip, false);
       if (atencion == null){
           return false;
       }
       atencion.setConstantesVitales(temperatura, ppm, tensionSistolica, tensionDiastolica);
       return true;
}
public Atencion[] buscarAtencionesPorFecha(Date fechaInicio, Date fechaFin){
       int contadorAtenciones = 0;
       Atencion[] atencionesPorFecha = null;
    long timestampFechaInicio = fechaInicio.getTime();
            long timestampFechaFin = fechaFin.getTime();
       for (int i = 0; i < numAtenciones; i++) {
           long timestampAtencion = atenciones[i].getFechaEntrada().getTime();
           if (timestampAtencion >= timestampFechaInicio && timestampAtencion <= timestampFechaFin) {
               contadorAtenciones++;
           }
    }
      /* atencionesPorFecha = new Atencion[contadorAtenciones];
       contadorPorFecha =
       Acabar!!!!!
*/
    }
    public boolean altaMedica(String sip, String motivoAlta){
       Atencion atencion = buscarAtencionPaciente(sip, true);
       if (atencion == null)
           return false;
       atencion.altaPaciente(new Date(), motivoAlta);
        return true;
   }
    public Atencion[] obtenerhistoricoAtenciones(){
        //Opcion 1: Devolver los datos originales (Copia superficial solo copia punteros)
        // return  atenciones;
        // Opcion 2: Devolver datos de una copia
        Atencion[] historicoAtenciones = new Atencion[numAtenciones];
        for (int i = 0; i < numAtenciones; i++) {
            historicoAtenciones[i] = new Atencion(atenciones[i]);
        }
        return  historicoAtenciones;
   }
    public Estadistica obtenerEstadisticas(){
       return new Estadistica((atenciones, ));
    }

    public boolean entradaPaciente(Paciente paciente, String sintomatologia){
    atenciones[numAtenciones] = new Atencion(paciente, new Date(), sintomatologia);
    numAtenciones++;
    return true;
    }

    public Paciente buscarPacienteEnEspera(String sip) {
        for (int i = 0; i < numAtenciones; i++) {
            Paciente paciente = atenciones[i].getPaciente();
            if (atenciones[i].isAtendido() && paciente.getSip().equals(sip)) {
                return paciente;
            }
        }
        return null;
    }
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Pacientes: (\n");
       for (int i = 0; i < numPacientes; i++){
           sb.append(pacientes[i]).append("\n ");
       }
       sb.append(") \n");
       sb.append("Atenciones: (\n");
       for (int j = 0; j < numAtenciones; j++){
           sb.append(atenciones[j]).append("\n ");
       }
       sb.append(") \n");
       return sb.toString();
    }
}