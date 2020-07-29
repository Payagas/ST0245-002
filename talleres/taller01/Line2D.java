import java.util.*;
/**
 * Calcula los puntos entre dos puntos.
 *
 * @author Pablo Maya 
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */
public class Line2D
{
    
    private Punto p1, p2;
    
    public Line2D(Punto p1, Punto p2){
        if(p1.x() < p2.x()){
            this.p1 = p1;
            this.p2 = p2;
        }else{
            this.p1 = p2;
            this.p2 = p1; 
        }
        valoresIntermedios();
    }

    public double pendiente(){
        return (p2.y() - p1.y())/(p2.x() - p1.x());
    }

    public void valoresIntermedios(){
        double x = p1.x();
        double y = p1.y();
        double p = pendiente();
        for(double i = p1.x(); i < p2.x()-1; i++){
            y += p; x++;
            System.out.printf(Locale.US,"{%1.0f, %1.0f}%n",x,y);
        }
    }
}
