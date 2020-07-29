/**
 * Guarda los puntos x,y de una coordenada y hace distintas operaciones.
 * 
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */
public class Punto {
    
    private double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double radioPolar() {
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
    
    public double anguloPolar() {
        return Math.atan(this.x/this.y);
    }

    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow(otro.x()-this.x ,2) + Math.pow(otro.y()-this.y ,2));
    }
    
    public String toString(){
        return "{"+ this.x +" "+ this.y +"}";
    }
}