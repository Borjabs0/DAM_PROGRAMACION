//package com.borjabolufer.segundotrimestre.tema07.ejercicio03;
//
//import java.util.Scanner;
//
//public class Principal {
//    private static CentroEducativo centroEducativo;
//    private  static Scanner scanner;
//    public static int main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//    public static void bajaAlumno(){
//        System.out.println("Nia: ");
//        String nia = scanner.nextLine();
//        if (centroEducativo.bajaAlumno(nia)) {
//            System.out.println("Alumno dado de baja correctamente");
//        }else{
//            System.out.println("No se elimino el alumno");
//            }
//    }
//    public static void altaAlumno() {
//        String nombre;
//        String apellidos = "";
//        String fechanacimiento = "";
//        String grupo = "";
//        String telefono = "";
//        boolean valido;
//        do {
//            System.out.println("Nombre: ");
//            nombre = scanner.nextLine();
//            valido = nombre.length() >= 2;
//            if (!valido) {
//                System.out.println("El nombre debe de tener al menos 2 caracteres");
//            }
//        } while (!valido);
//        do {
//            System.out.println("Apellidos: ");
//            nombre = scanner.nextLine();
//            valido = apellidos.length() >= 2;
//            if (!valido) {
//                System.out.println("Los apellidos deben de tener al menos 4 caracteres");
//            }
//        } while (!valido);
//        do {
//            System.out.println("Fecha de nacimiento [dd-mm-yyyy]: ");
//            nombre = scanner.nextLine();
//            valido = fechanacimiento.length() == 10 && fechanacimiento.charAt(2) == '-' && fechanacimiento.charAt(5) == '-';
//            if (!valido) {
//                System.out.println("Fecha incorrecta: el formato debe ser [dd-mm-yyyy]");
//            }
//        } while (!valido);
//
//        do {
//            System.out.println("Grupo: ");
//            nombre = scanner.nextLine();
//            valido = grupo.length() >= 3;
//            if (!valido) {
//                System.out.println("El grupo debe de tener al menos 3 caracteres");
//            }
//        } while (!valido);
//        do {
//            System.out.println("Teléfono: ");
//            nombre = scanner.nextLine();
//            valido = telefono.length() >= 9 && telefono.length() == 11;
//            if (!valido) {
//                System.out.println("El telefono debe de tener al menos 9 caracteres");
//            }
//        } while (!valido);
//         Alumno alumno = centroEducativo.altaAlumno(nombre, apellidos, fechanacimiento, grupo, telefono);
//        if (alumno != null) {
//            System.out.println("Alumno creado correctamente");
//            System.out.println(alumno);
//        } else{
//            System.out.println("ERROR AL CREAR EL ALUMNO");
//            }
//
//    }
//
//
//    public static int menuPrincipal(){
//        int opcion = -1;
//        boolean valido;
//        do {
//            System.out.println("*********************");
//            System.out.println("1. Nuevo alummno");
//            System.out.println("2. Nuevo alummno");
//            System.out.println("3. Nuevo alummno");
//            System.out.println("");
//            System.out.println("");
//            opcion = Integer.parseInt(scanner.nextLine());
//            valido = opcion >= 0 && opcion < 4;
//            if (!valido) {
//                System.out.println("Opción no válida");
//            }
//        }while (!valido);{
//            return opcion;
//        }
//
//
//        }
//    }
//}