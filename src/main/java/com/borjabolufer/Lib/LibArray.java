package com.borjabolufer.Lib;
import java.util.Random;


public class LibArray {

    private static Random rnd = new Random();


    public static float calcularMediaArray(int[] array){
        if(array.length == 0){
            return 0.0f;
        }

        int suma = 0;
        for (int i = 0; i < array.length; i++){
            suma += array[i];
        }
        return (float) suma / array.length;
    }


    public static double calcularMediaArray(double[] array){
        if(array.length == 0){
            return 0.0;
        }

        int suma = 0;
        for (int i = 0; i < array.length; i++){
            suma += array[i];
        }
        return (double) suma / array.length;
    }


    public static double calcularMediaMayorQueArray(double[]array, double num){
        if(array.length == 0){
            return 0.0;
        }
        int suma = 0;
        int contador = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] >= num){
                suma += array[i];
                contador++;
            }
        }
        if(contador == 0){
            return -1.0;
        }
        return (double) suma / array.length;
    }


    public static double[] contarElementosArrayMayorQue(double[] array, double num){
        double[] resultado;
        int contador = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > num){
                contador++;
            }
        }
        resultado = new double[contador];
        contador = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > num){
                resultado[contador++] = array[i];
            }
        }
        return resultado;
    }

    public static int[] contarElementosMayoMenor(int[] arrayP, int num){
        int[] resultado = new int[arrayP.length];
        int contador = 0;

        for (int i = 0; i < arrayP.length; i++){
            if(arrayP[i] > num){
                resultado[contador++] = arrayP[i];
            } else {
                resultado[contador++] = -1;
            }
        }
        return resultado;
    }


    public static void posicionArrayPar(char[] array){
        for (int i = 0; i < array.length; i += 2){
            System.out.printf("a[%d] = %c\n", i, array[i]);
        }
    }


    public static void posicionArrayImpar(char[] array){
        for (int i = 1; i < array.length; i += 2){
            System.out.printf("a[%d] = %c\n", i, array[i]);
        }
    }


    public static double[] sumaArrays(double[] arrayUno, double[] arrayDos){
        int longitud = arrayUno.length;
        double[] resultado = new double[longitud];
        for (int i = 0; i < longitud; i++){
            resultado[i] = arrayUno[i] + arrayDos[i];
        }
        return resultado;
    }


    public static double[] divisionArrays(double[] arrayUno, double[] arrayDos){
        int longitud = arrayUno.length;
        double[] resultado = new double[longitud];
        for (int i = 0; i < longitud; i++){
            resultado[i] = arrayUno[i] / arrayDos[i];
        }
        return resultado;
    }


    public static int[] multiplos(int[] array, int multiplo){
        if(multiplo == 0){
            return new int[0];
        }

        int contador = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % multiplo == 0){
                contador++;
            }
        }

        int[] resultado = new int[contador];
        contador = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] % multiplo == 0){
                resultado[contador] = array[i];
                contador++;
            }
        }
        return resultado;
    }


    public static int[] arrayContainsNum(int[] array, int n){
        int contador = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == n){
                contador++;
            }
        }

        int[] resultado = new int[contador];
        contador = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] == n){
                resultado[contador] = array[i];
                contador++;
            }
        }
        return resultado;
    }


    public static void crearArray(int[] vector){
        int min = 0;
        int max = 50;
        for (int i = 0; i < vector.length; i++){
            vector[i] = rnd.nextInt((max - min + 1) + 1);
        }
    }


    public static void visualitzarArray(int[] vector){
        for (int i = 0; i < vector.length; i++){
            System.out.printf("[%d]=[%d]  ", i, vector[i]);
        }
        System.out.printf("\n");
    }


    public static void visualitzarParell(int[] vector){
        boolean allZeros = true;
        for (int i = 0; i < vector.length; i += 2){
            if(vector[i] != 0){
                allZeros = false;
                System.out.printf("[%d]=[%d]  ", i, vector[i]);
            }
        }
        System.out.printf("\n");
        if(allZeros){
            System.out.printf("Elige la opción 1 para rellenar el array, no hay valores asignados al array\n");
        }
    }


    public static void visualitzarMultiple3(int[] vector){
        boolean multiplesFound = false;
        for (int i = 0; i < vector.length; i++){
            if(vector[i] != 0){
                if(vector[i] % 3 == 0){
                    System.out.printf("[%d]=[%d]  ", i, vector[i]);
                    multiplesFound = true;
                }
            }

        }
        System.out.printf("\n");

        if(!multiplesFound){
            System.out.printf("No se han encontrado múltiplos de 3, rellena el array con la opción 1.\n");
        }
    }

    public static int[] arrayInvertido(int[] array){
        int[] resultadoInvertido;
        int contador = 0;
        resultadoInvertido = new int[contador];
        for (int i = array.length -1; i >= 0; i--){
            resultadoInvertido[contador++] = array[i];
        }
        return resultadoInvertido;
    }

    public static int[] arraySumatorio(int[] array, int iteraciones){
        int[] valorSumatorioV = new int[iteraciones];
        int[] resultadoSumatorioP = new int[iteraciones];
        int sumaAcumulativa = 0;
        for (int i = 0; i < iteraciones; i++){
            valorSumatorioV [i] = i;
            sumaAcumulativa = 0;
            for (int j = 0; j <= i; j++){
                sumaAcumulativa += valorSumatorioV[j];
            }
            resultadoSumatorioP[i] = sumaAcumulativa;
        }
        return resultadoSumatorioP;
    }


    public static String mostrarMensajeArrayNulo(int[] array, String mensaje){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0){
                contador++;
            }
        }
        if(contador == 0){
            sb.append(mensaje);
        }
        return sb.toString();
    }

    public static int[] valorParArray(int[] arrayV){
        int[] resultadoPar;
        int contador = 0;

        for(int i = 0; i < arrayV.length; i++){
            if(arrayV[i] != 0 && arrayV[i] % 2 == 0){
                contador++;
            }
        }

        resultadoPar = new int[contador];
        contador = 0;

        for (int i = 0; i < arrayV.length; i++){
            if(arrayV[i] != 0 && arrayV[i] % 2 == 0){
                resultadoPar[contador++] = arrayV[i];
            }
        }
        return resultadoPar;
    }


    public static int[] ordenarArray(int[] array){
        int aux;
        int valorMinimo;
        for (int i = 0; i < array.length - 1; i++){
            valorMinimo = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[valorMinimo]){
                    valorMinimo = j;
                }
            }
            aux = array[valorMinimo];
            array[valorMinimo] = array[i];
            array[i] = aux;
        }
        return array;
    }

    public static int[] ordenarCount(int[] array){
        int max = maximoArray(array); //Crear metodo que calcula el maximo de un array
        int[] resultado = new int[max];
        int[] resultadoFinal = new int[array.length];
        int contador = 0;
        for (int i = 0; i < array.length; i++){
            resultado[array[i]]++;
        }
        contador = 0;
        for(int i = 0; i < resultado.length; i++){
            for (int j = 0; j < resultado[i]; j++){
                resultadoFinal[contador++] = i;
            }
        }
        return resultadoFinal;
    }


    public static int maximoArray(int[] array){
        int contador = 0;
        for (int i = 0; i < array.length; i++){
            contador++;
        }
        return contador;
    }

    //Correcion en clase:

    public static int[] countingSort(int[] array){
        ArrayStats stats = new ArrayStats(array);
        if (stats.getNegativeCount() > 0){
            return null;
        }
        int[] result = new int[array.length];
        int[] counter = new int[stats.getMax() + 1];
        for (int i=0; i < array.length; i++){
            int value = array[i];
            counter[value]++;
        }
        int index = 0;
        for (int i = 0; i < counter.length; i++){
            int value = counter[i];
            for (int j = 0; j < value; j++){
                result[index++] = i;
            }
        }
        return result;
    }

    public static class ArrayStats{
        private int min;
        private int max;
        private long sum;
        private double mean;
        private int positiveCount;
        private int negativeCount;
        private final int[] array;
        public ArrayStats(int[] array){
            this.array = array;
            getStats();
        }
        private void getStats(){
            min = array[0];
            max = array[0];
            mean = 0;
            sum = 0;
            positiveCount = 0;
            negativeCount = 0;
            for(int value : array){
                sum += value;
                if (value > max){
                    max = value;
                }
                if (value < min){
                    min = value;
                }
                if (value < 0){
                    negativeCount++;
                } else if (value > 0){
                    positiveCount++;
                }
                mean = (double) sum / array.length;
            }
        }
        public int getMin(){
            return min;
        }
        public int getMax(){
            return max;
        }
        public long getSum(){
            return sum;
        }
        public double getMean(){
            return mean;
        }
        public int getPositiveCount(){
            return positiveCount;
        }
        public int getNegativeCount(){
            return negativeCount;
        }
    }


    public static int[] ordenacionBurbuja(int[] array){
        int temp;
        for (int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j + 1] < array[j]){
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    public static int[][] matrizRandom(int[][] matriz, int max, int min){
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = rnd.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    public static void mostrarMatrizCompleta(int[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.printf("%d ", matriz[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void mostrarMatrizCompleta(double[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.printf("%.2f ", matriz[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void mostrarMatrizTraspuesta(int[][] matriz){
        for (int j = 0; j < matriz[0].length; j++){
            for (int i = 0; i < matriz.length; i++){
                System.out.printf("%d ", matriz[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static int[][] sumaValoresMatriz(int[][] matriz){
        int[][] matrizResultado = new int[matriz.length][matriz[0].length + 1];
        for (int i = 0; i < matriz.length; i++){
            int sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++){
                matrizResultado[i][j] = matriz[i][j];
                sumaFila += matriz[i][j];
            }
            matrizResultado[i][matriz[0].length] = sumaFila;
        }
        return matrizResultado;
    }


    }

