/**
 * Guarda un numero al cual se le puede operar.
 * 
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */
public class Contador {
    
    private int cuenta;
    private final String id;

    public Contador(String id) {
        this.id = id;
        cuenta = 0;
    }

    public void incrementar(int cantidad) {
        cuenta+= cantidad;
    }

    public void decrementar(int cantidad) {
        cuenta-= cantidad;
    }

    public int incrementos() {
        return cuenta;
    }

    public String toString() {
        return "" + id + cuenta;
    }
}
