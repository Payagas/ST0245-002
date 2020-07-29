import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Lee un archivo de texto para usar los datos de puntos.
 * Se utiliza un ArrayList
 *
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Mayo, 2020
 */
public class ColeccionPuntos
{
    
    protected ArrayList<Punto> al;

    public ColeccionPuntos() {
        al = new ArrayList<>();
    }

    public void leerArchivo(String nombreArchivo) throws FileNotFoundException {
        Scanner archivo = new Scanner(new File(nombreArchivo));
        while(archivo.hasNextLine()) {
            String linea = archivo.nextLine();
            Scanner sl = new Scanner(linea);
            boolean esc = false;
            while (sl.hasNext()) {
                try {
                    double id = sl.nextDouble();
                    if(sl.hasNext()){
                        double x = sl.nextDouble();
                        if(sl.hasNext()){
                            double y = sl.nextDouble();
                            al.add(new Punto(x,y));
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.print(e.getMessage()); 
                    esc = true;
                }
                if(esc)break;
            }
        }
    }

    public ArrayList<Punto> getArray(){
        return al;
    }

    public int getSize(){
        return al.size();
    }
}
