import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
     * Se puede leer los elementos por consola con la ayuda de la clase index.
     * luego solo se agregan a un objeto arraylist y se imprime.
     * el arreglo tiene que estar de forma inversa
     * ejemplo, para las entras 1 , 2 , 6, -1
     * el arreglo tendría este orden [ 6, 2, 1].
     * @return un arraylist con todos los elementos ingresados de forma invertida
     */
public class Taller6
{
    public static ArrayList<Integer> opcinal2 (){
	ArrayList<Integer> arry = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	while (n != -1) {
	    arry.add(n);
	    n= in.nextInt();
	}
	ArrayList<Integer> arreglo = new ArrayList<>();
	for(int i = 0; i < arry.size(); i++) {
	    arreglo.add(arry.get(arry.size()-1-i ));
	}
	return arreglo;
    }
}
