
public class Taller4
{
    
    public static int arrayMax(int[] array, int n) {
        //n es el numero de objetos en el array
        int max = 0, temp = 0;
        max = array[n]; //(te falto aqui un ;)
        //max es un int distinto cada ciclo
        //para obtenerlo empezamos desde n y le vamos restando 1
        //cada vez que se llama la clase
        if (n > 0) {
            temp = arrayMax(array, n-1);
            //aqui en el segundo parametro seria n - 1
            
            //asi cada ciclo ve un numero diferente
            //empezando desde el ultimo numero del array hasta el primero
            if (temp < max) temp = max;
            
        }
        return temp;
    }
}

