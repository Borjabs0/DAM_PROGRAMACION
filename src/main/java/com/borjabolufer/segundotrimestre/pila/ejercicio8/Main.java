//package com.borjabolufer.segundotrimestre.pila.ejercicio8;
//
//import com.borjabolufer.segundotrimestre.tema07.ejercicio07.Paciente;
//import net.datafaker.Faker;
//
//import java.util.Locale;
//import java.util.Random;
//public class Main {
//    public <T> String arrayToString(T[] array) {
//        StringBuilder sb = new StringBuilder(array.length);
//        sb.append("[ ");
//        for (T t : array) {
//            sb.append(t).append(" ");
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//    public static void  main(String[] args){
//        Faker faker = new Faker();
//        Random random = new Random();
//        GenericDynamicArray<Paciente> pacientes = new GenericDynamicArray<>();
//        for (int i = 0; i < 10; i++) {//falta implementar faker
//            Paciente.Genero genero = Paciente.Genero.values()[random.nextInt(Paciente.Genero.values().length)];
//            pacientes.add(new Paciente(String.format("%05d", i), faker.name().firstName()));
//        }
//        System.out.println(pacientes);
//    }
//}
