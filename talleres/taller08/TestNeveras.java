import java.util.*;
public class TestNeveras
{
    public static void main (String[]neveras){
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
        
        Taller8.asignarSolicitudes(nev,tien);
    }
}
