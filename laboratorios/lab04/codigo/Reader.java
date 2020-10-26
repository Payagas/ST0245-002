import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
/**
 * This class is responsible for reading a text file containing an indeterminate number of 
 *bees, identifying their coordinates and storing them in a LinkedList of Bee objects. 
 *Likewise, it is responsible for saving the coordinates of each bee in other LinkedList 
 *corresponding to each coordinate, so that it can be passed to the Octree class, which needs 
 *them to function.
 * @author: Pablo Maya Villegas
 * @version: 25/10/2020
 * @see Octree
 * @see Bee
 */
public class Reader
{
    //Arrays that save the Bees and the coordinates
    LinkedList<Double> lat = new LinkedList();
    LinkedList<Double> lon = new LinkedList();
    LinkedList<Double> alt = new LinkedList();
    LinkedList<Bee>   bees = new LinkedList();
    /**
     * This method is in charge of recieving an adress of where the file is, 
     * and it reads each line in order to pass them to a method that can save 
     * this information in its corresponding LinkedList.
     * @param String dir: adress of where the file is
     * @see splitString
     */
    public void leer (String dir) throws IOException{
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
        getMaxMin();
    }    

    /**
     * This method is in charge of recieving each line of coordinates that is being
     * given by the method leer, here it will save the coordinates in its respective
     * LinkedList, and it will create a Bee with its coordiantes and adds it to the LinkedList.
     * @param String s: line of coordinates
     */
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

    /**
     *This method is responsible for obtaining the minimum and maximum of each coordinate, so we can estimate 
     *the length of the diagonals that will be created in the first division of the Octree, and determine if 
     *it is worth creating an Octree with this data set. Likewise, this is the last step of this class before we
     *start working with our Octree data structure. If it is not worth creating the Octree (because the length of 
     *its diagonals will be less than 100m) it will be printed all the coordinates of the bees of the data set.
     * @see crash
     */
    public void getMaxMin(){
        double minLat=(double)Collections.min(lat);
        double maxLat=(double)Collections.max(lat);

        double minLon=(double)Collections.min(lon);
        double maxLon=(double)Collections.max(lon);

        double minAlt=(double)Collections.min(alt);
        double maxAlt=(double)Collections.max(alt);

        double midD=(minLat+maxLat)/2;
        double midW=(maxLon+minLon)/2;
        double midH=(maxAlt+minAlt)/2;
        double ph=Math.sqrt(Math.pow(((minLat-maxLat)/2)*111325,2)+Math.pow(((maxLon-minLon)/2)*111325,2));
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow(((maxAlt-minAlt)/2),2));
        if (diagonal>100) {
            Octree octree=new Octree();
            octree.octree(bees,midD,midW,midH);
        } else {
            //optional code to print the coordinates of the bees in proximity
            //crash();
        }
    }

    /**
     * This method is in charge of printing all the Bees of this data set,
     * if it prints them is because all these Bees are in danger of colliding.
     */
    public void crash() {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bee b: bees) {
            System.out.println(b.getLatitude()+","+b.getLongitude()+","+b.getAltitude());
        }
    }
}