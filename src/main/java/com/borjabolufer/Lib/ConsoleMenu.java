package com.borjabolufer.Lib;
import java.util.Scanner;

public class ConsoleMenu {
    private  static  Scanner scanner = new Scanner(System.in);
    private static final int CAPACIDA_INICIAL = 5 ;
    private final String texto; //encabezado
    private ConsoleMenu[] opciones;//Almacena las opciones del menu
    private int numOpciones; //Indica el numero de opciones hay en el menu

    /**
     * Constructor publico
     * @param texto asigna la variable como argumento
     */
    public ConsoleMenu(String texto) {
        this.texto = texto;
        this.opciones = null;
        numOpciones = 0;
    }

    /**
     * Metodo donde ampliaremos la capacidad del array opcines.
     * Crearemos un nuevo array llamado copia donde almacenaremos
     * los elementos del array original al nuevo doblando el tamaño
     * del array original.
     */
    private void ampliarCapacida(){
        ConsoleMenu[] copia = new ConsoleMenu[opciones.length * 2];
        for (int i = 0; i < opciones.length; i++) {
            copia[i] = opciones[i];
        }
        opciones = copia;

    }

    /**
     * Metodo donde vamos a añadir una nueva opcion al menu
     * @param texto creamos un nuevo objeto consoleMenu con ese texto
     * @return
     */
    public ConsoleMenu addOpcion(String texto){
        if (opciones == null){
            opciones = new ConsoleMenu[CAPACIDA_INICIAL];
        }
        if (numOpciones ==  opciones.length){//El array esta lleno se llama al método ampliarCapacida antes de añadir la nueva opción.
            ampliarCapacida();
        }
        ConsoleMenu resultado = new ConsoleMenu(texto);
        opciones[numOpciones] = resultado;
        numOpciones++;
        return resultado;


        // return null;
        //TAREA MENU CON LETRAS
    }

    /**
     *
     * @return
     */
    public int mostrarMenu(){
        boolean valido;
        int opcion;
        do {
            System.out.println(this);
            opcion = Integer.parseInt(scanner.nextLine());
            valido = opcion >= 1 && opcion <= numOpciones;
        }while (!valido);
        return  opcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*** ").append(texto).append(" ***\n");
        sb.append("-------------------\n");
        sb.append("Elija la opcion\n");
        sb.append("-------------------\n");
        for (int i = 0; i < numOpciones; i++) {
            sb.append(i + 1).append(". ").append(opciones[i].texto).append("\n");//Ajustar con String format
        }
        return sb.toString();
    }
}
