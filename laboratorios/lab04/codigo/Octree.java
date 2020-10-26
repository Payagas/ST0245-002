/**
 *This is our data structure, Octree. This will be responsible for positioning each bee in a specific quadrant, 
 *so you can determine if it collides or not. Its main function will be divided into eight quadrants, in 3D. 
 *If more than one bee is found in a quadrant, this quadrant will be divided into multiple subOctrees, found 
 *in the limits of this, until the bee is alone, or within a diagonal quadrant of less than 100 meters in length. 
 *This is done to ensure that all the bees within this quadrant are in danger of colliding.
 * @author: Pablo Maya Villegas
 * @version: 25/10/2020
 * @see Octree
 * @see Bee
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Octree
{
    private double midLat,midLon,midAlt;
    /**
     * This will be the method that represents the Octree, on this method all the recursion will be done, here each bee will be assigned 
     *to its respective sector of the Octree, represented by an ArrayList of 8 spaces (each one representing each sector), where it will 
     *be stored in a LinkedList. The process of deciding which sector each bee goes to will be done by the hashing method. After each bee
     *is located in a sector it will happen to create the sub-views of the Octree with the new method Octree. Before going on to create 
     *the new subdivisions of the Octree, it is asked if the octual diagonal is less than 100 meters, if so it will start printing the 
     *bees located in the sectors where there is more than one bee.
     * @param ArrayList<Bee> abejas: ArrayList with all the bees
     * @param double midLat: will be the value of the latitude found in the middle of the bee with the lowest latitude and the bee with the highest latitude
     * @param double midLon: will be the value of the longitude found in the middle of the bee with the lowest longitude and the bee with the highest longitude
     * @param double midAlt: will be the value of the altitude found in the middle of the bee with the lowest altitude and the bee with the highest altitude
     * @see hashing
     * @see nuevoOct
     */
    public void octree (LinkedList<Bee> abejas,double midLat,double midLon,double midAlt) {
        this.midLat = midLat;
        this.midLon = midLon;
        this.midAlt = midAlt;
        LinkedList[] sectors = filter(abejas);
        for(int i=0; i<8; i++){
            nuevoOctree(sectors[i]);
        }
    }

    /**
     * This method separates the bees list into 8 sections by using the hashing method
     * @param LinkedList<Bee> abejas: The bee list to separate
     * @return an array of linked list containing the filtered bees by sections
     */
    public LinkedList[] filter (LinkedList<Bee> abejas){
        LinkedList[] sectors = new LinkedList[8];
        for(int i=0; i<8; i++){
            sectors[i] = new LinkedList<Bee>();
        }
        for(Bee b: abejas){
            sectors[hashing(b)].add(b);
        }
        return sectors;
    }

    /**
     * This method will be responsible for receiving each bee that is in the octree, and place it in a certain sector of the data structure, 
     *so that it will be located in the space of the ArrayList table corresponding to the sector in which the bee is positioned. Determine the 
     *sector by comparing the minimum, that is, the vertices of the Octree, plus the average values of the Octree with which it is being worked.
     * @param Bee abeja: abeja que sera ubicada
     * @return number of the sector the Bee is located in.
     */
    private int hashing(Bee abeja) {
        int sector = 0;
        if(abeja.getLatitude() >= midLat){
            sector += 4;
        }
        if(abeja.getLongitude() >= midLon){
            sector += 2;
        }
        if(abeja.getAltitude() >= midAlt){
            sector += 1;
        }
        return sector;
    }

    /**
     * This method is responsible for making the recursion, with respect to the main octree method. Receive the parameters corresponding to 
     *the bees located in the sector, and the vertices of this, which are in the ArrayList mins. With the parameter sector they identify how 
     *the vertices of the next sub-octree should be redefined, since these vary by sector.
     * @param LinkedList<Bee> abejas: bees of the corresponding sector
     */
    public void nuevoOctree(LinkedList<Bee> abejas) {
        double minLat,maxLat,minLon,maxLon,minAlt,maxAlt;
        minLat=minLon=minAlt= Integer.MAX_VALUE;
        maxLat=maxLon=maxAlt= Integer.MIN_VALUE;

        for(Bee a: abejas){
            minLat = Math.min(minLat,a.getLatitude());
            minLon = Math.min(minLon,a.getLongitude());
            minAlt = Math.min(minAlt,a.getAltitude());

            maxLat = Math.max(maxLat,a.getLatitude());
            maxLon = Math.max(maxLon,a.getLongitude());
            maxAlt = Math.max(maxAlt,a.getAltitude());
        }

        double midLat=(minLat+maxLat)/2;
        double midLon=(maxLon+minLon)/2;
        double midAlt=(maxAlt+minAlt)/2;
        double ph=Math.sqrt(Math.pow(((minLat-maxLat)/2)*111325,2)+Math.pow(((maxLon-minLon)/2)*111325,2));
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow(((maxAlt-minAlt)/2),2));

        if(abejas.size() > 1){
            if (diagonal>100) {
                Octree octree=new Octree();
                octree.octree(abejas,midLat,midLon,midAlt);
            }else{
                //optional code to print the coordinates of the bees in proximity
                //crash(abejas);
            }
        }
    }

    /**
     * This sector is in charge of printing all the coordinates of the bees of the sector, if it prints them is because
     * all these Bees are in risk of colliding.
     * @param LinkedList<Bee> abejas: bees of the sector
     */
    public void crash(LinkedList<Bee> abejas) {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bee b:abejas) {
            System.out.println(b.getLatitude()+","+b.getLongitude()+","+b.getAltitude());
        }
    }

}