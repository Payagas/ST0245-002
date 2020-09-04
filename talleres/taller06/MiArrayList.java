import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }     

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size;
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {
        if(size+1 >= elements.length){
            int[] temp = new int[size*2];
            for(int i=0; i < elements.length; i++){
                temp[i] = elements[i];
            }
            elements = temp;
        }
        elements[size] = e;
        size++;
    }    

    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
        return elements[i];
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
        if(size+1 == elements.length){
            int[] temp = new int[size*2];
            for(int i=0; i < elements.length; i++){
                temp[i] = elements[i];
            }
            elements = temp;
        }
        for(int i=size; i >= index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = e;
        size++;
    } 

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        for(int i=index; i < size; i++){
            elements[i] = elements[i+1];
        }
        elements[size] = 0;
        size--;
        if(size <= elements.length /2){
            int[] temp = new int[size];
            for(int i=0; i < size; i++){
                temp[i] = elements[i];
            }
            elements = temp;
        }
    }
}
