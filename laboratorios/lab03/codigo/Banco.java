import java.util.Queue;
import java.util.LinkedList;
public class Banco
{
    static void simulacion (Queue<String> uno, Queue<String> dos, 
                    Queue<String> tres, Queue<String> cuat){
        boolean caj = true;
        while(!(uno.isEmpty() && dos.isEmpty() && 
               tres.isEmpty() && cuat.isEmpty())){
           if(!uno.isEmpty()){
               System.out.println(uno.poll()+" "+cajero(caj));
               caj = !caj;
           }
           if(!dos.isEmpty()){
               System.out.println(dos.poll()+" "+cajero(caj));
               caj = !caj;
           }
           if(!tres.isEmpty()){
               System.out.println(tres.poll()+" "+cajero(caj));
               caj = !caj;
           }
           if(!cuat.isEmpty()){
               System.out.println(cuat.poll()+" "+cajero(caj));
               caj = !caj;
           }
        }
    }
    
    static int cajero(boolean caj){
        if(caj) return 1;
        return 2;
    }
    
    static void test(){
        Queue<String> uno = new LinkedList<String>();
        uno.add("Umberta");
        uno.add("Ursula");
        Queue<String> dos = new LinkedList<String>();
        dos.add("Donna");
        dos.add("Daniel");
        dos.add("Dana");
        dos.add("Dora");
        Queue<String> tres = new LinkedList<String>();
        tres.add("Teresa");
        tres.add("Tom");
        tres.add("Tatiana");
        Queue<String> cuat = new LinkedList<String>();
        cuat.add("Carlos");
        cuat.add("Cora");
        cuat.add("Clara");
        cuat.add("Clem");
        
        System.out.println(uno);
        System.out.println(dos);
        System.out.println(tres);
        System.out.println(cuat);
        System.out.println("La letra inicial indica de que cola son: ");
        simulacion(uno,dos,tres,cuat);
    }
}
