/**
 * Guarda las coordenadas de un punto 3D y hace operaciones.
 * 
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */

public class Punto3D {

    private double x, y, z;

    public Punto3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }
    
    public double z() {
        return z;
    }

    public double radioPolarXY() {
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
    
    public double radioPolarXZ() {
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.z,2));
    }
    
    public double anguloPolarXY() {
        return Math.atan(this.x/this.y);
    }
    
    public double anguloPolarXZ() {
        return Math.atan(this.x/this.z);
    }

    public double distanciaEuclidiana(Punto3D otro) {
        return Math.sqrt(Math.pow(otro.x()-this.x ,2) + Math.pow(otro.y()-this.y ,2) + Math.pow(otro.z()-this.z ,2));
    }
    
    public String toString(){
        return "{"+ this.x +" "+ this.y +" "+ this.z +"}";
    }
}
