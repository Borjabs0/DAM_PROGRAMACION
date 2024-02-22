package com.borjabolufer.segundotrimestre.pila.ejercicio1;

import java.util.Arrays;

public class DynamicArray {
    private static final double GROW_FACTOR = 2f;
    private static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int elementCount;


    public  DynamicArray(){
        this(DEFAULT_CAPACITY);
    }
    public DynamicArray(int capacidadInicial) {
        this.data = new double[capacidadInicial];
        this.elementCount = 0;
    }
    private boolean isFull(){
        return  elementCount == data.length;
    }
    private void resize(){
        double[] copy = new double[(int) Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < elementCount; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }

    public  int size(){
        return elementCount;
    }
    public boolean add(double element){
        if(isFull()){
            resize();
        }
        data[elementCount++] = element;
        return true;

    }
    public boolean add(int index, double element){
        if (index >= elementCount || index < 0){
            return false;
        }
        if (isFull()){
            resize();
        }
        moveToRight(index);
        data[index] = element;
        return true;
    }
    private void moveToRight(int index){
        for (int i = elementCount; i > index; i++) {
            data[i] = data[i - 1];
        }
        elementCount++;
    }
    private void moveToLeft(int index){
        for (int i = index; i < elementCount - 1; i++) {
            data[i] = data[i + 1];
        }
        elementCount--;
    }

    public double remove(int index){
        if (index >= elementCount || index < 0){
            return Double.POSITIVE_INFINITY;
        }
        double result = data[index];
        moveToLeft(index);
        return result;
    }

    public double remove(double element){
        double result = Double.POSITIVE_INFINITY;
        for (int i = 0; i < elementCount; i++) {
            if (data[i] == element){
                result = data[i];
                moveToLeft(i);
                return result;
            }
        }
        return result;
    }
    public double get(int index){
        if (index >= elementCount || index < 0){
            return Double.POSITIVE_INFINITY;
        }
        return data[index];
    }
    public boolean set(int index, double element){
        if (index >= elementCount || index < 0){
            return false;
        }
        data[index] = element;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicArray that = (DynamicArray) o;

        if (elementCount != that.elementCount) return false;
        for (int i = 0; i < elementCount; i++) {
            if (data[i] != that.data[i])
                return false;
        }
        return true;
        //return Arrays.equals(data, that.data);
    }

    // Habria que crear una funcion hash que solo tuvise en cuenta
    // los primeros elementCount - 1 elementos
    @Override
    public int hashCode() {
        double[] efectiveArray = new double[elementCount];
        for (int i = 0; i < efectiveArray.length; i++) {
            efectiveArray[i] = data[i];
        }
        int result = Arrays.hashCode(efectiveArray);
        result = 31 * result + elementCount;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < elementCount; i++) {
            sb.append(String.format("%.02f ", data[i]));
        }
        sb.append(" ]");
        return sb.toString();
        /*
        return "DynamicArray{" +
                ", data=" + Arrays.toString(data) +
                ", elementCount=" + elementCount +
                '}';
    */
    }

}
