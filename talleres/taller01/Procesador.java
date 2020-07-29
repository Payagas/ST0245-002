import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Es la interfaz del programa.
 * 
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */
public class Procesador {
    
    ColeccionPuntos cp;
    Scanner scan;
    
    public Procesador(){
        cp = new ColeccionPuntos();
        scan = new Scanner(System.in);
    }

    public void opciones(){
        do{
            System.out.println("==================================");
            System.out.println("1 Calcular los valores de un punto");
            System.out.println("2 Calcular los valores y distancia de dos puntos");
            System.out.println("3 Procesar un archivo de puntos");
            System.out.println("4 Comparar dos fechas");
            System.out.println("5 Usar un contador");
            System.out.println("6 Calcular la distancia entre dos puntos 3D");
            System.out.println("7 Ver los puntos de intermedio entre dos puntos");
            System.out.println("0 Terminar");
            System.out.println("==================================");
        }while(elegir(scan.nextInt()));
    }

    public boolean elegir(int i){
        switch(i){
            case 0:
            return false;
            case 1:
            calcularPunto();
            return true;
            case 2:
            calcular2Puntos();
            return true;
            case 3:
            procesarArchivo();
            return true;
            case 4:
            compararFechas();
            return true;
            case 5:
            contador();
            return true;
            case 6:
            distancia3D();
            return true;
            case 7:
            intermedio();
            return true;
        }
        System.out.println("Opción inválida");
        return true;
    }

    public void calcularPunto(){
        System.out.println("Por favor ingresar X: ");
        double x = scan.nextDouble();
        System.out.println("Por favor ingresar Y: ");
        double y = scan.nextDouble();
        Punto p = new Punto(x,y);
        System.out.println("Punto: "+ p);
        System.out.printf(Locale.US,"Radio Polar: %1.2f%n", p.radioPolar());
        System.out.printf(Locale.US,"Angulo Polar: %1.2f%n", Math.toDegrees(p.anguloPolar()));
    }

    public void calcular2Puntos(){
        System.out.println("Por favor ingresar X1: ");
        double x1 = scan.nextDouble();
        System.out.println("Por favor ingresar Y1: ");
        double y1 = scan.nextDouble();
        System.out.println("Por favor ingresar X2: ");
        double x2 = scan.nextDouble();
        System.out.println("Por favor ingresar Y2: ");
        double y2 = scan.nextDouble();
        Punto p1 = new Punto(x1,y1);
        Punto p2 = new Punto(x2,y2);
        System.out.println("Punto: "+ p1);
        System.out.printf(Locale.US,"Radio Polar: %1.2f%n", p1.radioPolar());
        System.out.printf(Locale.US,"Angulo Polar: %1.2f%n%n", Math.toDegrees(p1.anguloPolar()));

        System.out.println("Punto: "+ p2);
        System.out.printf(Locale.US,"Radio Polar: %1.2f%n", p2.radioPolar());
        System.out.printf(Locale.US,"Angulo Polar: %1.2f%n%n", Math.toDegrees(p2.anguloPolar()));

        System.out.printf(Locale.US,"Distancia euclidiana: %1.2f%n",p1.distanciaEuclidiana(p2));
    }

    public void procesarArchivo(){
        System.out.println("Por favor ingresar la ubicación del archivo");
        System.out.println("Por ejemplo: C:\\Users\\Pablo\\Desktop\\datos.txt ");
        try {
            cp.leerArchivo(scan.next());
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe " + e.getMessage());
        }
        for(int i = 0; i < cp.getSize(); i++){
            Punto p = cp.getArray().get(i);
            System.out.println("Punto: "+ p);
            System.out.printf("Radio Polar: %1.2f%n", p.radioPolar());
            System.out.printf("Angulo Polar: %1.2f%n", Math.toDegrees(p.anguloPolar()));
            if(i-1 >= 0)
                System.out.printf("Distancia euclidiana con punto pasado: %1.2f%n%n", 
                    p.distanciaEuclidiana(cp.getArray().get(i-1)));
            else System.out.println();
        }
    }

    public void compararFechas(){
        System.out.println("Primera fecha: ");
        System.out.println("Por favor ingresar el año: ");
        int anyo = scan.nextInt();
        System.out.println("Por favor ingresar el mes en número: ");
        int mes = scan.nextInt();
        System.out.println("Por favor ingresar el día: ");
        int dia = scan.nextInt();
        Fecha f1 = new Fecha(dia,mes,anyo);
        System.out.println();

        System.out.println("Segunda fecha: ");
        System.out.println("Por favor ingresar el año: ");
        anyo = scan.nextInt();
        System.out.println("Por favor ingresar el mes en número: ");
        mes = scan.nextInt();
        System.out.println("Por favor ingresar el día: ");
        dia = scan.nextInt();
        Fecha f2 = new Fecha(dia,mes,anyo);
        System.out.println();

        String comp;
        if(f1.comparar(f2) > 0){
            comp = " es despues que ";
        }else if(f1.comparar(f2) < 0){
            comp = " es antes que ";
        }else{
            comp = " es igual que ";
        }

        System.out.println(f1+comp+f2);
    }

    public void contador(){
        Contador c = new Contador("Cuenta ");
        System.out.println("Ingrese 0 para terminar ");
        System.out.println("Ingrese la cantidad de incremento: ");
        int incr = scan.nextInt();
        while(incr != 0){
            c.incrementar(incr);
            System.out.println(c);
            System.out.println("Ingrese la cantidad de incremento: ");
            incr = scan.nextInt();
        }
    }

    public void distancia3D(){
        System.out.println("Por favor ingresar X1: ");
        double x1 = scan.nextDouble();
        System.out.println("Por favor ingresar Y1: ");
        double y1 = scan.nextDouble();
        System.out.println("Por favor ingresar Z1: ");
        double z1 = scan.nextDouble();
        System.out.println("Por favor ingresar X2: ");
        double x2 = scan.nextDouble();
        System.out.println("Por favor ingresar Y2: ");
        double y2 = scan.nextDouble();
        System.out.println("Por favor ingresar Z2: ");
        double z2 = scan.nextDouble();

        Punto3D p1 = new Punto3D(x1,y1,z1);
        Punto3D p2 = new Punto3D(x2,y2,z2);
        System.out.println("Punto: "+ p1);
        System.out.println("Punto: "+ p2);
        System.out.printf(Locale.US,"Distancia euclidiana: %1.2f%n",p1.distanciaEuclidiana(p2));
    }

    public void intermedio(){
        System.out.println("Por favor ingresar X1: ");
        double x1 = scan.nextDouble();
        System.out.println("Por favor ingresar Y1: ");
        double y1 = scan.nextDouble();
        System.out.println("Por favor ingresar X2: ");
        double x2 = scan.nextDouble();
        System.out.println("Por favor ingresar Y2: ");
        double y2 = scan.nextDouble();
        Punto p1 = new Punto(x1,y1);
        Punto p2 = new Punto(x2,y2);
        Line2D l2d = new Line2D(p1,p2);
    }
}
