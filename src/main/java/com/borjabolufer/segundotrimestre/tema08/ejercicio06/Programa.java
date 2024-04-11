package com.borjabolufer.segundotrimestre.tema08.ejercicio06;

public class Programa {
    private enum Clasificacion{
        PESO_BAJO, NORMAL, SOBRE_PESO, OBESIDAD,
        DELGADEZ_SEVERA, DELGADEZ_MODERADA, DELGADEZ_LEVE,
        PREOBESIDAD, OBESIDAD_LEVE, OBESIDAD_MEDIA, OBESIDAD_MORBIDA
    }
    private float masa;
    private float estatura;
    public Programa() {


    }
//    public  String comprobarPeso(float masa, float estatura){
//        if (IMC(masa, estatura) < 18.50){
//            return String.valueOf(Clasificacion.PESO_BAJO);
//        }
//        if (IMC(masa, estatura) < 16.00){
//            return String.valueOf(Clasificacion.DELGADEZ_SEVERA);
//        }
//        if (IMC(masa, estatura) >= 16.00 && IMC(masa,estatura) <= 16.99){
//            return String.valueOf(Clasificacion.DELGADEZ_MODERADA);
//        }
//        if (IMC(masa, estatura) >= 17.00 && IMC(masa,estatura) <= 18.49){
//            return String.valueOf(Clasificacion.DELGADEZ_LEVE);
//        }if(IMC(masa, estatura) >= 18.50 && IMC(masa,estatura) <= 24.99){
//            return String.valueOf(Clasificacion.NORMAL);
//        }
//    }
    public float IMC(float masa, float estatura){
        return (float) (masa / Math.pow(estatura, 2));
    }

}
