import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
/**
 * This class is an alternative method of solving the bees problem by using a stack, the complexity is n = n-1.
 */
public class StackBees
{
    public static void main(String[]args)throws IOException{
        ReaderStack rs = new ReaderStack();
        String dir = "100abejas.txt";
        try{
            LinkedList<Bee> bees = rs.leer(dir);
            System.out.println(colisions(bees));
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
    static String colisions(LinkedList<Bee> bees){
        String col = "";
        for(int i=0; i<bees.size(); i++){
            Bee bb = bees.pop();
            int x = i+1;
            for(Bee b: bees){
                if(distance(bb,b) < 100){
                    col += "("+i+","+x+"), ";
                }
                x++;
            }
        }
        return col;
    }
    
    static double distance(Bee a, Bee b){
        return  Math.sqrt(Math.pow(a.getLatitude()-b.getLatitude(),2)+
                Math.pow(a.getLongitude()-b.getLongitude(),2)+
                Math.pow(a.getAltitude()-b.getAltitude(),2));
    }
}

class ReaderStack
{
    LinkedList<Double> lat = new LinkedList();
    LinkedList<Double> lon = new LinkedList();
    LinkedList<Double> alt = new LinkedList();
    LinkedList<Bee>   bees = new LinkedList();
    
    public LinkedList<Bee> leer (String dir) throws IOException{
        lat = new LinkedList();
        lon = new LinkedList();
        alt = new LinkedList();
        bees= new LinkedList();
        try (BufferedReader br=new BufferedReader(new FileReader(dir))){
            String line;
            while ((line=br.readLine())!=null){
                splitString(line);
            } 
        } catch (IOException e){
            e.printStackTrace();
        }
        return bees;
    }    

    public void splitString(String s){
        String [] str=s.split(",");  
        try{
            lat.addFirst(Double.parseDouble(str[0]));
            lon.addFirst(Double.parseDouble(str[1]));
            alt.addFirst(Double.parseDouble(str[2]));
            Bee bee=new Bee(Double.parseDouble(str[0]),Double.parseDouble(str[1]),Double.parseDouble(str[2]));
            bees.addFirst(bee);
        } catch (Exception e){
        }
    }
}
