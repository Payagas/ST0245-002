import java.util.LinkedList;
public class tecladoRoto{
    public static void teclado(String a){
        LinkedList<Character>texto = new LinkedList<>();
        char c = ']';
        int j = 0;
        for(int i=0; i < a.length(); ++i){
            if(a.charAt(i) == ']') c = ']';
            else if(a.charAt(i) == '[') {
                c = '[';
                j = 0;
            }else if(c == ']'){
                texto.addLast(a.charAt(i));
                j = 0;
            }else if(c == '['){
                texto.add(j,a.charAt(i));
                j++;
            }
        }
        while(texto.size()>0){
            System.out.print(texto.getFirst());
            texto.remove();
        }
    }
}
