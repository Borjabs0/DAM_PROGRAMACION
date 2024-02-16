package com.borjabolufer.segundotrimestre.tema07;

import com.borjabolufer.Lib.ConsoleMenu;
import com.borjabolufer.Lib.LibIO;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Ejercicio07 {

    public static CentroSalud centroSalud;
    public static ConsoleMenu menuPrincipal;
    public static ConsoleMenu menuConsultas;
    public static ConsoleMenu menuGeneros;

    public static void main(String[] args) {


        CentroSalud centroSalud = new CentroSalud(500, 3000);
        //Menu Principal
        menuPrincipal = new ConsoleMenu("URGENCIAS");
        menuPrincipal.addOpcion("Nuevo paciente ");
        menuPrincipal.addOpcion("Atender paciente ");
        menuPrincipal.addOpcion("Consultas");
        menuPrincipal.addOpcion("Alta médica");
        menuPrincipal.addOpcion("Salir");
        //Consultas submenu
        menuConsultas = new ConsoleMenu("CONSULTAS");
        menuConsultas.addOpcion("Por Sip");
        menuConsultas.addOpcion("Por Fechas");
        menuConsultas.addOpcion("Estadísticas");
        menuConsultas.addOpcion("Mostrar histórico mensual");



        int opcion;
        do {
            opcion = menuPrincipal.mostrarMenu();
            switch (opcion) {
                case 1:
                    nuevoPaciente();
                    break;
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    consultas();
                    break;

                case 4:
                    altaMedica();
                    break;
                case 5:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while (opcion != 5);
        System.out.println(centroSalud);

    }

    private static void altaMedica() {
        String sip = LibIO.solicitarString("Sip", 4, 12);
        String motivoAlta = LibIO.solicitarString("Motivo del alta", 4, 100);
        if (centroSalud.altaMedica(sip, motivoAlta)){
            System.out.println("Paciente dado de alta correctamente");
        }else {
            System.err.println("Paciente no dado de alta");
        }
    }

    public void consultas() {
        int opcion = menuConsultas.mostrarMenu();
        switch (opcion) {
            case 1:
                buscarPorSip();
                break;
            case 2:
                buscarPorFechas();
                break;
            case 3:
                Estadistica estadistica =;
                break;
            case 4:
                mostrarHistoricoMensual();
                break;

        }
    }

    private void mostrarHistoricoMensual() {
        Atencion[] historicoAtenciones = centroSalud.obtenerhistoricoAtenciones();
        System.out.println(Arrays.toString(historicoAtenciones));
        //mostrara datos -1000
        historicoAtenciones[0].setConstantesVitales(-1000, -1000, -1000, -1000);
        System.out.println(historicoAtenciones[0]);
        //
        historicoAtenciones = centroSalud.obtenerhistoricoAtenciones();
        System.out.println(Arrays.toString(historicoAtenciones));
    }

    public void buscarPorSip(){
        String sip;
        sip = LibIO.solicitarString("Sip", 4, 12);
        Paciente paciente = centroSalud.buscarPacientePorSip(sip);
        if (paciente != null){
            System.out.println(paciente);
        }else{
            System.err.printf("No existe ningun paciente con el sip %s\n", sip);
        }
    }

    public  void buscarPorFechas(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = LibIO.solicitarFechaDate("Fecha inicio: [dd/MM/yyyy]", sdf);
        Date fechaFin = LibIO.solicitarFechaDate("Fecha fin: [dd/MM/yyyy]", sdf);
        Atencion[] atencionesPorFecha = centroSalud.buscarAtencionesPorFecha(fechaInicio, fechaFin);
        //Faltan cosas
    }
    public static void nuevoPaciente() {
        String sip;
        sip = LibIO.solicitarString("Sip", 4, 12);
        Paciente paciente = centroSalud.buscarPacientePorSip(sip);

        if (paciente == null) {
            System.out.printf("No existe ningun paciente con el sip %s\n", sip);
            String nombre = LibIO.solicitarString("Nombre", 2, 30);
            Paciente.Genero[] generos = Paciente.Genero.values();
            int opcionGenero = menuGeneros.mostrarMenu();
            Paciente.Genero genero = Paciente.Genero.values()[opcionGenero - 1];
            Date fechaNacimiento = LibIO.solicitarFechaDate("Fecha nacimiento: [dd/MM/yyyy]", new SimpleDateFormat("dd//MM/yyyy"));
            //Ejercicio fecha min y fecha maxima o periodo de tiempo con clase period
            paciente = new Paciente(sip, nombre, genero, fechaNacimiento);
            if (paciente == null) {
                System.err.println("No se puede añadir el paciente");
                return;
            } else {
                System.out.println("Paciente añadido correctamente " + paciente);
            }
        }
        String sintomatologia = LibIO.solicitarString("Sintomatología", 4, 50);
        if (centroSalud.entradaPaciente(paciente, sintomatologia))
            System.out.println("Entrada del paciente registrada correctamente");
        else
            System.out.println("No se puedo registrar la entrada del paciente");
    }

    public static void atenderPaciente() {
        String sip = LibIO.solicitarString("Sip", 4, 12);
        Paciente paciente = centroSalud.buscarPacienteEnEspera(sip);
        if (paciente == null) {
            System.err.println("No existe ningún paciente en espera con ese sip");
            return;
        }
        System.out.println("*** Constantes Vitales ***");
        double temperatura = LibIO.solicitarDouble("Temperatura: ", 34, 45);
        double ppm = LibIO.solicitarDouble("Pulsaciones por minuto: ",  30, 240);
        double tensionSistolica = LibIO.solicitarDouble("Tension Sistolica: ", 21, 200);
        double tensionDiastolica = LibIO.solicitarDouble("Tension Diastolica: ", 10, 200);
        //mal orden
        if (centroSalud.atenderPaciente(sip, temperatura, ppm, tensionSistolica, tensionDiastolica)){
            System.out.println("El paciente ha sido atendido correctamente");
        }else {
            System.err.printf("No se ha encontrado paciente \n", sip);
        }
    }
}