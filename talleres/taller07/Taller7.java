import java.util.*; 
import java.util.ArrayList;

/**
 * 
 * @author Kevin Arley Parra Henao - 201710093010, Daniel Alejandro Mesa Arango - 201710054010 
 * @version: 1.0  18/09/2017
 */
public class Taller7 {
    //compara dos listas
    
   public static boolean  iguales(LinkedList lista1, LinkedList lista2)
    {
        if(lista1.size() != lista2.size()){
            return false;
        }else {
            for (int i = 0; i < lista1.size(); i++) {
               if (lista1.get(i) != lista2.get(i)) return false;
            }
            return true;
        }
    }
    //busca el elemento de mayor tamaño
    public static int maximo(LinkedList lista) {
        return maximoAux(lista.first);
    }
    
    private static int maximoAux(Node nodo) {
        if (nodo.next == null) {
            return nodo.data;
        } else {
            return Math.max(nodo.data, maximoAux(nodo.next));
        }
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        
        list.insert(1, 0);
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 3);
        list.insert(5, 4);
        
        list2.insert(5, 0);
        list2.insert(4, 1);
        list2.insert(3, 2);
        list2.insert(2, 3);
        list2.insert(1, 4);
        
        System.out.println("Lista 1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        System.out.println("Lista 2: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list2.get(i));
        }
        
        System.out.print("Son iguales? ");
        System.out.println(iguales(list, list2));
        
        System.out.print("El maximo de Lista 1: ");
        System.out.println(maximo(list));

        System.out.print("Lista 1 contiene 3? ");
        System.out.println(list.contains(3));

        System.out.println("Removemos el elemento en 2 en lista 1 ");
        list.remove(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        System.out.print("Lista 1 contiene 3? ");
        System.out.println(list.contains(3));
    }

}

