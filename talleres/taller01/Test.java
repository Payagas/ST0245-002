/**
 * Clase de prueba.
 * 
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */
public class Test {
    public static void main(String[] args) {
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i)
            c.incrementar(1);
        // 10
        System.out.printf(c + "\n");
        Punto p = new Punto(-1, 1);
        // -1,1
        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
        // 1*sqrt(2)
        System.out.println("Radio Polar: " + p.radioPolar());
        // -45
        System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));
        // 2
        System.out.println("Distancia euclidiana con [1,1]: " + p.distanciaEuclidiana(new Punto(1, 1)));

        System.out.println();

        Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(2, 5, 2016);
        System.out.println(f1);
        System.out.println(f2);
        // 1
        System.out.println(f1.comparar(f2));
    }

}