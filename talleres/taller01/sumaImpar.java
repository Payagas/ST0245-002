import java.util.Scanner;
public class sumaImpar
{
    public static void main(String[] args){
        Scanner cs = new Scanner(System.in);
        int x= 0;
        System.out.println("ingresa un numero:");
        int numero = cs.nextInt();
        
        while(numero != 0){
            
            
     
        if (numero%2 == 1){
            x = x + numero;
        }
        numero =  cs.nextInt();
    }
    System.out.println(x);
    }
}
