package com.borjabolufer.segundotrimestre.tema07.ejercicio06;

public class Tienda {
        private final Bicicleta[] bicicletas;
        private int numReferencia;


        public Tienda(int capacidadIncial) {
            bicicletas = new Bicicleta[capacidadIncial];
            numReferencia = 0;
        }

        public Bicicleta comprarReferencia(String referencia) {
            Bicicleta bicicleta = buscarPorReferencia(referencia);
            if (bicicleta != null) {
                bicicleta.comprar();
                return bicicleta;
            }
            return null;
        }


        public Bicicleta buscarPorReferencia(String referencia) {
            for (int i = 0; i < numReferencia; i++) {
                if (bicicletas[i].getReferencia().equalsIgnoreCase(referencia.toLowerCase())) {
                    return bicicletas[i];
                }
            }
            return null;
        }


        public Bicicleta anayadirBicicletas(String marca, String modelo, float pesoKg, float pulgadas, boolean motor, String fecha, float precio, int referencia) {
            Bicicleta bicicleta = new Bicicleta(marca, modelo, pesoKg, pulgadas, motor, fecha, precio);
            int i = 0;
            boolean bici = true;
            while(i < bicicletas.length && bici == true) {
                if (bicicletas[i] == null) {
                    bicicletas[i] = bicicleta;
                    bici = false;
                }
                i++;
            }
            return bicicleta;
        }

    /**
     * ¡¡¡¡Modificar metodo!!!!
     * @param referencia por terminar
     * @return por termiar
     */
    public Bicicleta venderBicicleta(int referencia) {
            if (referencia == numReferencia) {
                numReferencia--;
                return null;
            }
            return null;
        }
    }
