import java.util.*;

public class Taller8 {

    public static int polaca  (String string){
        String[] prefixStr = string.split(" "); 
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<prefixStr.length;i++){
            if(prefixStr[i].equals("+")){
                stack.push(stack.pop()+ stack.pop());
            }
            else if(prefixStr[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(prefixStr[i].equals("-")){
                int m = stack.pop();
                stack.push( stack.pop() - m);
            }
            else if(prefixStr[i].equals("/")){
                stack.push(stack.pop()/stack.pop());
            }
            else{
                stack.push(Integer.parseInt(prefixStr[i]));
            }
        }
        return stack.pop();
    }

    public static Stack<Integer> inversa (Stack<Integer> stack){
        int n = stack.size();
        Stack<Integer> temp = new Stack<Integer>();
        for(int i = 0; i < n; i++) 
            temp.push(stack.pop());
        return temp;
    }

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

    public static void cola (Queue<String> q){
        while(!q.isEmpty()){
            System.out.println("Atendiendo a "+q.poll());
        }
    }
}