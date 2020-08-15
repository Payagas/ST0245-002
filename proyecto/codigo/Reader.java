import java.io.*; 
import java.util.*;
public class Reader 
{ 
    protected ArrayList<ArrayList> ala;

    public Reader(String arch) throws Exception {
        ala = new ArrayList<>();
        try {
            read(arch);
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage()); 
        }
    }

    public ArrayList<ArrayList> read(String arch) throws Exception 
    { 
        // pass the path to the file as a parameter 
        //"C:\\Users\\Pablo\\Desktop\\datos.csv"
        FileReader fr = new FileReader(arch); 

        ArrayList<String> als = new ArrayList<>(61);

        int i=0;
        int j=0;
        String s = "";
        int esc =0;
        while (i != -1) {
            while(j<77 && (i=fr.read()) != -1){
                if((char)i == ';'){
                    als.add(s);
                    s = "";
                    j++;
                }else{
                    s += (char)i;
                }
            }
            ala.add(als);
            als = new ArrayList<>(61);
            j=0;
        }
        return ala;
    } 
} 