import java.util.LinkedList;
public class PesoVigas
{
    public static int calcularPeso(LinkedList<Integer> ll){
        float val=0, sum=0;
        for(int v: ll){
            sum += v;
        }
        sum /= 2;
        int ind=0;
        for(int v: ll){
            val += v;
            if(val >= sum) break;
            ind++;
        }
        return ind;
    }
    
    public static void test(){
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(10);
        ll.add(12);
        ll.add(14);
        ll.add(16);
        ll.add(18);
        ll.add(20);
        System.out.println("Se pone pivote en la posicion: "+calcularPeso(ll));
    }
}
