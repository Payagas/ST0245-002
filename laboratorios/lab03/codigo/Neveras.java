import java.util.*;
public class Neveras
{
    public static void asignarSolicitudes  
    (Stack<Node> neveras, Queue<Node> solicitudes){
        while(!solicitudes.isEmpty()){
            Node tienda = solicitudes.poll();
            System.out.println(tienda.nombre +": ");
            for(int i=0; i<tienda.numero; i++){
                Node nevera = neveras.pop();
                System.out.println("    "+nevera.nombre +"_"+nevera.numero);
            }
            System.out.println();
        }
    }
    
    public static void testNeveras(){
        Stack<Node> nev = new Stack<Node>();
        for(int i=1; i<=10; i++){
            nev.push(new Node(i*1354,"NeveraDosMil"));
        }
        for(int i=1; i<=10; i++){
            nev.push(new Node(i*2683,"Artico Portatil"));
        }
        for(int i=1; i<=10; i++){
            nev.push(new Node(i*3147,"Nevera de D1"));
        }
        
        Queue<Node> tien = new LinkedList<Node>();
        tien.add(new Node(5,"Neveras la 33"));
        tien.add(new Node(10,"Neveras y Neveras"));
        tien.add(new Node(15,"Todo en Neveras"));
        
        asignarSolicitudes(nev,tien);
    }
}
