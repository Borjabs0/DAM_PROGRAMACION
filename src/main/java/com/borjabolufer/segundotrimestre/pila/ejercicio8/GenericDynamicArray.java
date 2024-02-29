package com.borjabolufer.segundotrimestre.pila.ejercicio8;

import java.util.Arrays;

public class GenericDynamicArray<T> {
    private static final double GROW_FACTOR = 2f;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int elementCount;


    public GenericDynamicArray(){
        this(DEFAULT_CAPACITY);
    }
    public GenericDynamicArray(int capacidadInicial) {
        this.data = new Object[capacidadInicial];
        this.elementCount = 0;
    }
    private boolean isFull(){
        return  elementCount == data.length;
    }
    private void resize(){
        Object[] copy = new Object[(int) Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < elementCount; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }

    public  int size(){
        return elementCount;
    }
    public boolean add(T element){
        if(isFull()){
            resize();
        }
        data[elementCount++] = element;
        return true;

    }
    public boolean add(int index, T element){
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
    @SuppressWarnings("unchecked")
    public T remove(int index){
        if (index >= elementCount || index < 0){
            return null;
        }
        T result = (T)data[index];
        moveToLeft(index);
        return result;
    }
    @SuppressWarnings("unchecked")
    public T remove(T element){
        T result = null;
        for (int i = 0; i < elementCount; i++) {
            if (data[i] == element){
                result = (T)data[i];
                moveToLeft(i);
                return result;
            }
        }
        return result;
    }
    @SuppressWarnings("unchecked")
    public T get(int index){
        if (index >= elementCount || index < 0){
            return null;
        }
        return (T)data[index];
    }
    public boolean set(int index, T element){
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

        GenericDynamicArray that = (GenericDynamicArray) o;

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
        Object[] efectiveArray = new Object[elementCount];
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
            sb.append(data[i]).append(" ");
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
