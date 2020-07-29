/**
 * Guarda una fecha en formato abstracto
 * 
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */
public class Fecha {
    private final int dia, mes, anyo;

    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    public int dia() {
        return dia;
    }
    public int mes() {
        return mes;
    }
    public int anyo() {
        return anyo;
    }

    /**
    * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
    */
    public int comparar(Fecha otra) {
        if(this.toLong() > otra.toLong())return 1;
        if(this.toLong() < otra.toLong())return -1;
        return 0;
    }

    public String toString() {
        long tot = anyo*10000 + mes*100 + dia;
        return "" + tot;
    }
    
    public long toLong(){
        return anyo*10000 + mes*100 + dia;
    }
}